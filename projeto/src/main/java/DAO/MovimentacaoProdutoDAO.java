package DAO;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.MovimentacoesProdutos;
import Interfaces.MovimentacaoProdutosDAO;

public class MovimentacaoProdutoDAO implements MovimentacaoProdutosDAO {

	@Override
	public MovimentacoesProdutos selectById(EntityManager em, int id) {
		return em.find(MovimentacoesProdutos.class, id);
	}

	@Override
	public void insert(EntityManager em, MovimentacoesProdutos mov) {
		em.persist(mov);

	}

	@Override
	public void update(EntityManager em, MovimentacoesProdutos mov) {
		em.merge(mov);
		
	}
	

}
