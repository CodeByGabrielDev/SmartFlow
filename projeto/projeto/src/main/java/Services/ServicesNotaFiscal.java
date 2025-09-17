package Services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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

	public void emitirNotaFiscal(EntityManager em, List<Produtos> listaDeProdutos, Movimentacao mov) {

		try {
			NotaFiscal notaFiscal = new NotaFiscal(5102, mov.getPrice(), mov.getPessoa());
			if (mov.getPessoa() == null) {
				notaFiscal.setPessoa(null);
			}
			em.persist(notaFiscal);
			notaItem.inserirItens(em, notaFiscal, listaDeProdutos);
			notaFiscal.setStatus(em.find(StatusNFE.class, 1));
			em.merge(notaFiscal);

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

	public void cancelarNotaComBaseMovimentacao(EntityManager em, int id) {
		NotaFiscal nota = em.find(NotaFiscal.class, id);
		if (nota == null) {
			throw new IllegalArgumentException("");
		}
	}

	private NotaFiscal validarTempoDeNota(NotaFiscal nota) {
		Long validacao = ChronoUnit.MINUTES.between(nota.getEmissao(), LocalDateTime.now());
		if (validacao > 10) {
			throw new IllegalArgumentException("Error, the invoice have more then 10 minutes");
		} else {
			return nota;
		}
	}

}
