package br.com.senai.fatesg.primefaces.entidade;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Equipamento {
	@Id
	@GeneratedValue(generator = "equipamento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "equipamento_seq", sequenceName = "equipamento_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	private String nome;

	private Date aquisicao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(Date aquisicao) {
		this.aquisicao = aquisicao;
	}

}
