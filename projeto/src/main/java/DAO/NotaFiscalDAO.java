package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.NotaFiscal;
import Utils.JPAUtils;

public class NotaFiscalDAO implements Interfaces.NotaFiscalDAO {

	@Override
	public NotaFiscal selectById(EntityManager em, int id) {
		return em.find(NotaFiscal.class, id);
	}

	@Override
	public void insert(EntityManager em, NotaFiscal nota) {
		em.persist(nota);

	}

	@Override
	public void update(EntityManager em, NotaFiscal nota) {
		em.merge(nota);

	}


}
