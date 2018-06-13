package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Equipamento;
import br.com.senai.fatesg.primefaces.entidade.Modalidade;
import br.com.senai.fatesg.primefaces.persistencia.EquipamentoDao;

@Repository("modalidadeDao")
public class ModalidadeDaoJpa extends PersistenciaJpa<Modalidade> implements ModalidadeDao{

   private static final long serialVersionUID = 1L;

}
