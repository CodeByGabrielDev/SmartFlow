package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota_fiscal_item")
public class NotaFiscalItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_nf")
	private NotaFiscal notaFiscal;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produtos product;
	@Column(name = "referencia_produt0",nullable = false)
	private String produtoReferencia;

	public NotaFiscalItem() {

	}

	

	public NotaFiscalItem(NotaFiscal notaFiscal, Produtos product, String produtoReferencia) {
		super();
		this.notaFiscal = notaFiscal;
		this.product = product;
		this.produtoReferencia = produtoReferencia;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Produtos getProduct() {
		return product;
	}

	public void setProduct(Produtos product) {
		this.product = product;
	}



	public String getProdutoReferencia() {
		return produtoReferencia;
	}



	public void setProdutoReferencia(String produtoReferencia) {
		this.produtoReferencia = produtoReferencia;
	}
	
}
