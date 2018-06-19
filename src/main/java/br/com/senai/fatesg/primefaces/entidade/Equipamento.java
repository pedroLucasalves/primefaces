package br.com.senai.fatesg.primefaces.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Equipamento {
	@Id
	@GeneratedValue(generator = "equipamento_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "equipamento_seq", sequenceName = "equipamento_seq", allocationSize = 1, initialValue = 1)
	private Integer id;

	private String descricao;

	private String QtdEquipamento;

	public String getQtdEquipamento() {
		return QtdEquipamento;
	}

	public void setQtdEquipamento(String qtdEquipamento) {
		QtdEquipamento = qtdEquipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

}
