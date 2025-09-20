package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.NotaFiscalItem;

public interface NotaFiscalItemDAO {

	NotaFiscalItem selectbyId(EntityManager em, int id);


	void insert(EntityManager em, NotaFiscalItem notaFiscalitem);

	void delete(EntityManager em, NotaFiscalItem nota);

}
