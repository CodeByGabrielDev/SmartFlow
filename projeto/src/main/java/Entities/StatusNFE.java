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
@Table(name = "Status_NFE")
public class StatusNFE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "desc_programador")
	private String descProgramador;
	@OneToMany(mappedBy = "status")
	private List<NotaFiscal>notas = new ArrayList<>();

	public StatusNFE() {

	}

	public StatusNFE(String descProgramador) {
		super();
		this.descProgramador = descProgramador;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescProgramador() {
		return descProgramador;
	}

	public void setDescProgramador(String descProgramador) {
		this.descProgramador = descProgramador;
	}

}
