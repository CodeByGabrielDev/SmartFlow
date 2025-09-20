package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.PessoaFisica;

public interface PessoaFisicaDAO {

	PessoaFisica selectById(EntityManager em,int id);


	void insert(EntityManager em,PessoaFisica pessoaFisica);

	void update(EntityManager em,PessoaFisica pessoa);

	void delete(EntityManager em,int id);
}
