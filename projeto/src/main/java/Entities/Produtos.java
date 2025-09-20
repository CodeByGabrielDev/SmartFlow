package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "referencia")
	private String referencia;
	
	private double preco_peca;
	@OneToMany(mappedBy = "produtoVinculado")
	private List<MovimentacoesProdutos> productVinculado = new ArrayList<>();
	@OneToMany(mappedBy = "product")
	private List<NotaFiscalItem> notaFiscalItem = new ArrayList<>();

	public Produtos() {

	}

	public Produtos(String referencia, double preco_peca) {
		super();
		this.referencia = referencia;
		this.preco_peca = preco_peca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getPreco_peca() {
		return preco_peca;
	}

	public void setPreco_peca(double preco_peca) {
		this.preco_peca = preco_peca;
	}

	public List<NotaFiscalItem> getNotaFiscalItem() {
		return notaFiscalItem;
	}

	public void setNotaFiscalItem(List<NotaFiscalItem> notaFiscalItem) {
		this.notaFiscalItem = notaFiscalItem;
	}

}
