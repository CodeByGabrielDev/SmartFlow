package Interfaces;

import java.util.List;

import javax.persistence.EntityManager;

import Entities.Pessoa;

public interface PessoaDAO {

	Pessoa selectById(EntityManager em,int id);


}
