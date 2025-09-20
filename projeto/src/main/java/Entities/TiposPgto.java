package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_pgto")
public class TiposPgto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "tipo_pgto")
	private char letraIdentificadora;
	@Column(name = "desc_programador")
	private String desc;
	@OneToMany(mappedBy = "tipoDePgto")
	private List<MovimentacoesPgto> mov = new ArrayList<>();

	public TiposPgto() {

	}

	public TiposPgto(char letraIdentificadora, String desc) {
		super();
		this.letraIdentificadora = letraIdentificadora;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getLetraIdentificadora() {
		return letraIdentificadora;
	}

	public void setLetraIdentificadora(char letraIdentificadora) {
		this.letraIdentificadora = letraIdentificadora;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<MovimentacoesPgto> getMov() {
		return mov;
	}

	public void setMov(List<MovimentacoesPgto> mov) {
		this.mov = mov;
	}

}
