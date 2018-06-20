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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.senai.fatesg.primefaces.entidade.Contato;
import br.com.senai.fatesg.primefaces.persistencia.ContatoDao;
import br.com.senai.fatesg.primefaces.persistencia.ContatoDaoJpa;

@Named("ContatoControl")
@Scope("conversation")
public class ContatoControl {

	private Contato contato = new Contato();

	@Autowired
	private ContatoDao contatoDao;

	private List<Contato> contatos = new ArrayList<Contato>();

	@PostConstruct
	public void init() {
		listar(null);
	}

	public void confirmar(ActionEvent evt) {
		try {
			contatoDao.alterar(contato);
			listar(evt);
			contato = new Contato();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			contatos = contatoDao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void onRowEdit(RowEditEvent event) {
		try {
		contato = (Contato) event.getObject();
		contatoDao.alterar(contato);
		contato = new Contato();
		UtilFaces.addMensagemFaces("Alterado com sucesso!");
		}catch(Exception e){
			UtilFaces.addMensagemFaces("Não foi possivel Editar");
		}
	}

	public void ExcluirContato(int id) {
		try {
			contatoDao.excluirPorId(id);
			listar(null);
			UtilFaces.addMensagemFaces("Excluido com sucesso!");
		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Não foi possivel excluir");
		}
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Contato ", ((Contato) event.getObject()).getId() + " selecionado ");
		contato = ((Contato) event.getObject());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
