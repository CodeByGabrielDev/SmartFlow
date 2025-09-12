package Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import DAO.MovimentacaoDAO;
import Entities.Movimentacao;
import Utils.JPAUtils;

public class ServicesMovimentacao {
	MovimentacaoDAO mov = new MovimentacaoDAO();

	public void realizarMovimentacao(Movimentacao mov) {
		EntityManager em = JPAUtils.getEmf();
		EntityTransaction et = em.getTransaction();
		et.begin();

		try {
			if (mov != null) {
				this.mov.insert(em, mov);
				et.commit();
			}
		} catch (Exception e) {
			et.rollback();
			throw new RuntimeException("Error to make a transcation " + e.getMessage());
		} finally {
			em.close();

		}
	}

	public void cancelarMovimentacao(int id) {
		EntityManager em = JPAUtils.getEmf();
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
					movBuscada.setDataVenda(LocalDateTime.now());
					movBuscada.setValorCancelado(movBuscada.getPrice());
					movBuscada.setPrice(0);
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
