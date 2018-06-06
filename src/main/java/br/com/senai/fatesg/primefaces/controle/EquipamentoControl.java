package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.entidade.Equipamento;
import br.com.senai.fatesg.primefaces.persistencia.EquipamentoDao;

@Named("EquipamentoControl")
@Scope("conversation")
public class EquipamentoControl {

	private Equipamento equipamento = new Equipamento();

	@Autowired
	private EquipamentoDao equipamentoDao;

	private List<Equipamento> equipamentos = new ArrayList<Equipamento>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		try {
			equipamentoDao.alterar(equipamento);
			listar(evt);
			equipamento = new Equipamento();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			equipamentos = equipamentoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Equipamento getContato() {
		return equipamento;
	}

	public void setContato(Contato contato) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> geEquipamentos() {
		return equipamentos;
	}
}

	