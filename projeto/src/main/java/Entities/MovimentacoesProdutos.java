package Entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacao_produtos")
public class MovimentacoesProdutos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "id_movimentacao")
	private Movimentacao movimentacaoVinculada;
	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produtos produtoVinculado;
	@Column(name = "data_venda")
	private LocalDateTime dataVenda;
	@Column(name = "valor_cancelado")
	private double valorCancelado;
	@Column(name = "cancelada")
	private boolean vendaCancelada;
	@Column(name = "data_cancelamento")
	private LocalDateTime dataCancelamento;

	public MovimentacoesProdutos() {

	}

	public MovimentacoesProdutos(Movimentacao movimentacaoVinculada, Produtos produtoVinculado) {
		this.vendaCancelada = false;
		this.movimentacaoVinculada = movimentacaoVinculada;
		this.produtoVinculado = produtoVinculado;
		this.valorCancelado = 0;
		dataVenda = LocalDateTime.now();
		dataCancelamento = null;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movimentacao getMovimentacaoVinculada() {
		return movimentacaoVinculada;
	}

	public void setMovimentacaoVinculada(Movimentacao movimentacaoVinculada) {
		this.movimentacaoVinculada = movimentacaoVinculada;
	}

	public Produtos getProdutoVinculado() {
		return produtoVinculado;
	}

	public void setProdutoVinculado(Produtos produtoVinculado) {
		this.produtoVinculado = produtoVinculado;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorCancelado() {
		return valorCancelado;
	}

	public void setValorCancelado(double valorCancelado) {
		this.valorCancelado = valorCancelado;
	}

	public boolean isVendaCancelada() {
		return vendaCancelada;
	}

	public void setVendaCancelada(boolean vendaCancelada) {
		this.vendaCancelada = vendaCancelada;
	}

	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(LocalDateTime dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

}
