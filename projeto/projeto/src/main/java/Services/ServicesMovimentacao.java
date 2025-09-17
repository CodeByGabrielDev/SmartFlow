package Services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.MovimentacaoDAO;
import Entities.Movimentacao;
import Entities.Produtos;
import Utils.JPAUtils;

public class ServicesMovimentacao {
	MovimentacaoDAO mov = new MovimentacaoDAO();
	ServiceMovimentacaoProduto serviceProdutoMov = new ServiceMovimentacaoProduto();
	ServicesNotaFiscal serviceNotaFIscal = new ServicesNotaFiscal();

	public void realizarMovimentacao(EntityManager em, List<Produtos> listaDeProdutos, Movimentacao mov) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			if (mov != null) {
				this.mov.insert(em, mov);

				serviceProdutoMov.inserirDadosMovimentacaoProduto(em, listaDeProdutos, mov);
				serviceNotaFIscal.emitirNotaFiscal(em, listaDeProdutos, mov);
				et.commit();
			}

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
				System.out.println("rollback!");
			} else {
				System.out.println("sem rollback");
			}
			throw new RuntimeException("Error to make a transcation " + e.getMessage());
		} finally {
			em.close();

		}
	}

	public void cancelarMovimentacao(EntityManager em, int id) {

		EntityTransaction et = em.getTransaction();
		et.begin();
		Movimentacao movBuscada = this.mov.selectById(em, id);

		try {
			if (movBuscada != null) {
				Long validadorDeTempo = ChronoUnit.MINUTES.between(movBuscada.getDataVenda(), LocalDateTime.now());
				if (validadorDeTempo > 10) {
					throw new RuntimeException("It is not possible to cancel after 10 minutes ");
				} else {
					movBuscada.setCancelada(true);
					movBuscada.setValorCancelado(movBuscada.getPrice());
					movBuscada.setPrice(0.0);
					movBuscada.setDataCancelamento(LocalDateTime.now());
					et.commit();
				}
			}
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException("has Occurred a error " + e.getMessage());
		} finally {
			em.close();
		}

	}

}
