package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Movimentacao;
import Utils.JPAUtils;

public class MovimentacaoDAO implements Interfaces.MovimentacaoDAO {

	@Override
	public Movimentacao selectById(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Movimentacao.class, id);
	}

	@Override
	public void insert(EntityManager em, Movimentacao mov) {
		em.persist(mov);

	}

	@Override
	public void update(EntityManager em, Movimentacao mov) {
		em.merge(mov);
	}

}
