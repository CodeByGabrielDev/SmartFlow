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

	public NotaFiscalItem() {

	}

	public NotaFiscalItem(NotaFiscal notaFiscal, Produtos product) {

		this.notaFiscal = notaFiscal;
		this.product = product;
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

}
