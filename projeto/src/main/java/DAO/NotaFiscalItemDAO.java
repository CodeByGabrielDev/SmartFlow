package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.NotaFiscal;
import Entities.NotaFiscalItem;
import Entities.Produtos;

public class NotaFiscalItemDAO implements Interfaces.NotaFiscalItemDAO {

	@Override
	public NotaFiscalItem selectbyId(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(NotaFiscalItem.class, id);
	}

	@Override
	public void insert(EntityManager em, NotaFiscalItem notaFiscalitem) {
		em.persist(notaFiscalitem);

	}

	@Override
	public void delete(EntityManager em, NotaFiscalItem nota) {
		em.remove(nota);

	}

}
