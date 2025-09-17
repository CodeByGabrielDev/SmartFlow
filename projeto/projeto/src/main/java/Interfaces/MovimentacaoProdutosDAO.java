package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.MovimentacoesProdutos;

public interface MovimentacaoProdutosDAO {

	MovimentacoesProdutos selectById(EntityManager em, int id);


	void insert(EntityManager em,MovimentacoesProdutos mov);

}
