package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.PessoaFisica;
import Entities.PessoaJuridica;

public interface PessoaJuridicaDAO {
	
	PessoaJuridica electById(EntityManager em,int id);


	void insert(EntityManager em,PessoaJuridica pessoa);

	void update(EntityManager em,PessoaJuridica pessoa);

	void delete(EntityManager em,int id);
}
