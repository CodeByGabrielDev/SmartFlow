package Entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
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
	@ManyToOne
	@JoinColumn(name = "id_pessoa_vinculada", nullable = true)
	private Pessoa pessoa;
	@OneToMany(mappedBy = "notaFiscal")
	List<NotaFiscalItem> notaFiscalItem = new ArrayList<>();
	@Column(name = "data_emissao")
	private LocalDateTime emissao;
	@Column(nullable = false)
	private boolean inutilizada;
	@Column(name = "data_inutilizacao")
	private LocalDate dataInutilizacao;
	@Column(name = "data_cancelamento")
	private LocalDateTime dataCancelamento;
	@Column(name = "nota_cancelada")
	private boolean notaCancelada;
	@ManyToOne
	@JoinColumn(name = "status_NFE")
	private StatusNFE status;
	@OneToOne
	private Movimentacao mov;

	public NotaFiscal() {

	}

	public NotaFiscal(int cFOP, double price, Pessoa pessoa) {
		CFOP = cFOP;
		this.price = price;
		this.pessoa = pessoa;
		inutilizada = false;
		dataInutilizacao = null;
		notaCancelada = false;
		dataCancelamento = null;
		emissao = LocalDateTime.now();
	}

	public Movimentacao getMov() {
		return mov;
	}

	public void setMov(Movimentacao mov) {
		this.mov = mov;
	}

	public int getSequencial() {
		return sequencial;
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

	public Pessoa getRegistroCliente() {
		return pessoa;
	}

	public void setRegistroCliente(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDateTime getEmissao() {
		return emissao;
	}

	public void setEmissao(LocalDateTime emissao) {
		this.emissao = emissao;
	}

	public boolean isNotaCancelada() {
		return notaCancelada;
	}

	public void setNotaCancelada(boolean notaCancelada) {
		this.notaCancelada = notaCancelada;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public StatusNFE getStatus() {
		return status;
	}

	public void setStatus(StatusNFE status) {
		this.status = status;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

}
