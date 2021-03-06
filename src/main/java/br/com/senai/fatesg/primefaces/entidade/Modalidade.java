package br.com.senai.fatesg.primefaces.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Modalidade {

	@Id
	@GeneratedValue(generator = "modalidade_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "modalidade_seq", sequenceName = " modalidade_seq", allocationSize = 1, initialValue = 1)

	private Integer id;

	private String descricao;

	private String valorMensal;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(String valor) {
		this.valorMensal = valor;
	}

	public Integer getId() {
		return id;
	}
}
