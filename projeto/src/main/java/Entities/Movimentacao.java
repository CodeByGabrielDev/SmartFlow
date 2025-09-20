package Entities;

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

@Entity
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticket;
	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;
	@Column(name = "preco", nullable = false)
	private Double price;
	@Column(name = "data_venda")
	private LocalDateTime dataVenda;
	@OneToMany(mappedBy = "movimentacaoVinculada")
	private List<MovimentacoesProdutos> produtosMovimentacao = new ArrayList<>();
	private boolean cancelada;
	@Column(name = "valor_cancelado")
	private Double valorCancelado;
	@Column(name = "data_cancelamento")
	private LocalDateTime dataCancelamento;
	@OneToMany(mappedBy = "mov")
	private List<MovimentacoesPgto> movPgto;
	@OneToOne
	@JoinColumn(nullable = true, name = "nota_referenciada")
	private NotaFiscal notaReferenciada;

	public Movimentacao() {

	}

	public Movimentacao(Pessoa pessoa, double price) {
		this.pessoa = pessoa;
		this.price = price;
		cancelada = false;
		dataVenda = LocalDateTime.now();
		valorCancelado = null;
		dataCancelamento = null;
	}

	public int getTicket() {
		return ticket;
	}

	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	public Double getValorCancelado() {
		return valorCancelado;
	}

	public void setValorCancelado(Double valorCancelado) {
		this.valorCancelado = valorCancelado;
	}

	public List<MovimentacoesProdutos> getProdutosMovimentacao() {
		return produtosMovimentacao;
	}

	public void setProdutosMovimentacao(List<MovimentacoesProdutos> produtosMovimentacao) {
		this.produtosMovimentacao = produtosMovimentacao;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public NotaFiscal getNota_referenciada() {
		return notaReferenciada;
	}

	public void setNota_referenciada(NotaFiscal nota_referenciada) {
		this.notaReferenciada = nota_referenciada;
	}

	public List<MovimentacoesPgto> getMovPgto() {
		return movPgto;
	}

	public void setMovPgto(List<MovimentacoesPgto> movPgto) {
		this.movPgto = movPgto;
	}

	public NotaFiscal getNotaReferenciada() {
		return notaReferenciada;
	}

	public void setNotaReferenciada(NotaFiscal notaReferenciada) {
		this.notaReferenciada = notaReferenciada;
	}

}
