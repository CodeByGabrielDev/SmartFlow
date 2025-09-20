package Entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

	@Column(nullable = false)
	private int idade;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private LocalDate data_cadastramento;

	public PessoaFisica() {

	}

	public PessoaFisica(String nome, int idade, String cpf) {
		super(nome);
		this.idade = idade;
		this.cpf = cpf;
		this.data_cadastramento = LocalDate.now();
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getData_cadastramento() {
		return data_cadastramento;
	}

	public void setData_cadastramento(LocalDate data_cadastramento) {
		this.data_cadastramento = data_cadastramento;
	}

}
