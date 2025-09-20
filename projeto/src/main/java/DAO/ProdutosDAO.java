package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Entities.NotaFiscal;
import Entities.Produtos;

public class ProdutosDAO implements Interfaces.ProdutosDAO {

	@Override
	public Produtos selectById(EntityManager em, int id) {
		// TODO Auto-generated method stub
		return em.find(Produtos.class, id);
	}

	@Override
	public void insert(EntityManager em, Produtos product) {
		em.persist(product);

	}

	@Override
	public void update(EntityManager em, Produtos product) {
		em.merge(product);

	}

	@Override
	public void delete(EntityManager em, Produtos product) {
		em.remove(product);

	}

}
