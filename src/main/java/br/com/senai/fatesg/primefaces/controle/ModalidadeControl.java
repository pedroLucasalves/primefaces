package br.com.senai.fatesg.primefaces.controle;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Modalidade;
import br.com.senai.fatesg.primefaces.persistencia.ModalidadeDao;

@Named("ModalidadeControl")
@Scope("conversation")
public class ModalidadeControl {

	private Modalidade modalidade = new Modalidade();

	@Autowired
	private ModalidadeDao modalidadeDao;

	private List<Modalidade> modalidades = new ArrayList<Modalidade>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		try {
			modalidadeDao.alterar(modalidade);
			listar(evt);
			modalidade = new Modalidade();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			modalidades = modalidadeDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void Salvar(RowEditEvent event) {
		try {
			modalidade = (Modalidade) event.getObject();
			modalidadeDao.alterar(modalidade);
			modalidade = new Modalidade();
			UtilFaces.addMensagemFaces("Alterado com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Não foi possivel Editar");
		}
	}

	public void ExcluirContato(int id) {
		try {
			modalidadeDao.excluirPorId(id);
			listar(null);
			UtilFaces.addMensagemFaces("Excluido com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Não foi possivel excluir");
		}
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Modalidade ",
				((Modalidade) event.getObject()).getDescricao() + " selecionado ");
		modalidade = ((Modalidade) event.getObject());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Modalidade Unselected",
				((Modalidade) event.getObject()).getId() + "selecionado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
