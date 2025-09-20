package Interfaces;

import javax.persistence.EntityManager;

import Entities.MovimentacoesPgto;

public interface MovimetacaoParcelasDAO {
	
	MovimentacoesPgto selectId(EntityManager em,int id) ;
	
	void insert(EntityManager em,MovimentacoesPgto mov);
	
	void update(EntityManager em,MovimentacoesPgto mov);
}
