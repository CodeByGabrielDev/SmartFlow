package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.NotaFiscal;

public interface NotaFiscalDAO {

	NotaFiscal selectById(EntityManager em, int id);

	void insert(EntityManager em, NotaFiscal nota);

	void update(EntityManager em, NotaFiscal nota);



}
