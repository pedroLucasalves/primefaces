package br.com.senai.fatesg.primefaces.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.senai.fatesg.primefaces.entidade.Equipamento;
import br.com.senai.fatesg.primefaces.persistencia.EquipamentoDao;

@Repository("equipamentoDao")
public class EquipamentoDaoJpa extends PersistenciaJpa<Equipamento> implements EquipamentoDao{

   private static final long serialVersionUID = 1L;

}
