package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sequencial;
	@Column(name = "preco_nota")
	private double price;
	@Column(name = "natureza_operacao")
	private int CFOP;
	@Column(name = "registro_cliente")
	private String registroCliente;
	@OneToMany(mappedBy = "notaFiscal")
	List<NotaFiscalItem> notaFiscalItem = new ArrayList<>();
	@Column(nullable = false)
	private boolean inutilizada;
	@Column(name = "data_inutilizacao")
	private LocalDate dataInutilizacao;

	public NotaFiscal() {

	}

	public NotaFiscal(int cFOP) {

		CFOP = cFOP;
		inutilizada = false;
		dataInutilizacao = null;
	}

	public int getSequencial() {
		return sequencial;
	}

	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCFOP() {
		return CFOP;
	}

	public void setCFOP(int cFOP) {
		CFOP = cFOP;
	}

	public boolean isInutilizada() {
		return inutilizada;
	}

	public void setInutilizada(boolean inutilizada) {
		this.inutilizada = inutilizada;
	}

	public LocalDate getDataInutilizacao() {
		return dataInutilizacao;
	}

	public void setDataInutilizacao(LocalDate dataInutilizacao) {
		this.dataInutilizacao = dataInutilizacao;
	}

	public List<NotaFiscalItem> getNotaFiscalItem() {
		return notaFiscalItem;
	}

	public void setNotaFiscalItem(List<NotaFiscalItem> notaFiscalItem) {
		this.notaFiscalItem = notaFiscalItem;
	}

}
