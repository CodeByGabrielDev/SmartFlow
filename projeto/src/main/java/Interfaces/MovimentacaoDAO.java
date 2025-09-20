package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Movimentacao;

public interface MovimentacaoDAO {

	Movimentacao selectById(EntityManager em, int id);

	void insert(EntityManager em, Movimentacao mov);

	void update(EntityManager em, Movimentacao mov);

}
