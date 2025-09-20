package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.NotaFiscal;
import Entities.Produtos;

public interface ProdutosDAO {

	Produtos selectById(EntityManager em,int id);

	void insert(EntityManager em,Produtos product);

	void update(EntityManager em,Produtos product);

	void delete(EntityManager em,Produtos product);

}
