package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.entidade.Equipamento;
import br.com.senai.fatesg.primefaces.persistencia.EquipamentoDao;
import br.com.senai.fatesg.primefaces.persistencia.EquipamentoDaoJpa;

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

	public Equipamento geEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	public void alterar(RowEditEvent event) {
		try {
			equipamento = (Equipamento) event.getObject();
			equipamentoDao.alterar(equipamento);
			equipamento = new Equipamento();
			UtilFaces.addMensagemFaces("Alterado com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Não foi possivel Editar");
		}
	}

	public void Excluir(int id) {
		try {
			equipamentoDao.excluirPorId(id);
			listar(null);
			UtilFaces.addMensagemFaces("Excluido com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Não foi possivel excluir");
		}
	}
}
