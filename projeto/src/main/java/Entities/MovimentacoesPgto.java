package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimentacoesParcelas")
public class MovimentacoesPgto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao mov;
	@ManyToOne
	@JoinColumn(name = "tipoPgto")
	private TiposPgto tipoDePgto;
	@Column(name = "numero_parcela")
	private int parcela;//definido com base no TIPO de pagamento >DEBITO A VISTA 1 parcela > credito a Vista 1 parcelas
									// agora, credito parcelado em duas vezes sera DUAS parcelas e dividido o valor total pela quantidade de parcelas.
	

	public MovimentacoesPgto() {

	}

	public MovimentacoesPgto(Movimentacao mov, TiposPgto tipoDePgto) {
		super();
		this.mov = mov;
		this.tipoDePgto = tipoDePgto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movimentacao getMov() {
		return mov;
	}

	public void setMov(Movimentacao mov) {
		this.mov = mov;
	}

	public TiposPgto getTipoDePgto() {
		return tipoDePgto;
	}

	public void setTipoDePgto(TiposPgto tipoDePgto) {
		this.tipoDePgto = tipoDePgto;
	}
	
	
}
