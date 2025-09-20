package Services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import DAO.NotaFiscalDAO;
import DAO.NotaFiscalItemDAO;
import Entities.Movimentacao;
import Entities.NotaFiscal;
import Entities.NotaFiscalItem;
import Entities.Produtos;
import Entities.StatusNFE;
import Utils.JPAUtils;

public class ServicesNotaFiscal {

	NotaFiscalDAO notadao = new NotaFiscalDAO();
	ServiceNotaFiscalItem notaItem = new ServiceNotaFiscalItem();

	public NotaFiscal emitirNotaFiscal(EntityManager em, List<Produtos> listaDeProdutos, Movimentacao mov) {

		try {
			NotaFiscal notaFiscal = new NotaFiscal(5102, mov.getPrice(), mov.getPessoa());
			if (mov.getPessoa() == null) {
				notaFiscal.setPessoa(null);
			}
			em.persist(notaFiscal);
			notaItem.inserirItens(em, notaFiscal, listaDeProdutos);
			notaFiscal.setStatus(em.find(StatusNFE.class, 1));
			em.merge(notaFiscal);
			notaFiscal.setMov(mov);
			return notaFiscal;

		} catch (Exception e) {
			if (em.isOpen()) {
				System.out.println("entity manager aberto");
			} else {
				System.out.println("Entity fechado");
			}
			throw new RuntimeException("Error to execute a issue of a invoice " + e.getMessage());
		} finally {
			em.close();
		}

	}

	public void cancelarNotaComBaseMovimentacao(EntityManager em, Movimentacao mov) {
		
		try {
			if (mov.getDataCancelamento() != null) {
				String jpql = "SELECT e FROM NotaFiscal e WHERE e.sequencial = :sequencial";
				TypedQuery<NotaFiscal> lista = em.createQuery(jpql, NotaFiscal.class);
				lista.setParameter("sequencial", mov.getNota_referenciada().getSequencial());
				List<NotaFiscal> Notancontrada = lista.getResultList();
				for (NotaFiscal nota : Notancontrada) {
					if (mov.getNota_referenciada().getSequencial() != nota.getSequencial()) {
						throw new RuntimeException("O sequencial da nota é difernete.");
					} else {
						nota.setNotaCancelada(true);
						nota.setStatus(em.find(StatusNFE.class, 2));
						em.merge(nota);
						
					}
				}
			} else {
				throw new RuntimeException("Movimentacao ainda nao cancelada.");
			}
		} catch (Exception e) {
			
			throw new RuntimeException("Erro ao executar o cancelamento da nota fiscal");
		} finally {
			em.close();
		}
	}

	public void cancelarNotaFiscalPelaTela(EntityManager em, int sequencial) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			NotaFiscal nota = em.find(NotaFiscal.class, sequencial);
			if (nota != null) {
				if (validarTempoDeNota(nota)) {
					nota.setNotaCancelada(true);
					nota.setStatus(em.find(StatusNFE.class, 2));
					nota.setDataCancelamento(LocalDateTime.now());
					em.merge(nota);
					et.commit();
				}
			}
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException("Erro ao executar o cancelamento da nota fiscal " + e.getMessage());
		} finally {
			em.close();
		}

	}

	private boolean validarTempoDeNota(NotaFiscal nota) {
		Long validacao = ChronoUnit.HOURS.between(nota.getEmissao(), LocalDateTime.now());
		if (validacao > 24) {
			throw new IllegalArgumentException("Error, the invoice have more then 24 hours");
		} else {
			return true;
		}
	}

}
