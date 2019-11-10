package models.entities.dao;

import java.util.List;

import models.entities.tables.Configuracoes;

public interface ConfiguracoesDao {
	
	List<Configuracoes> findAll();
	Configuracoes findById(int idConfiguracao);
	List<Configuracoes> findByQualidadeGrafica(String qualidadeGrafica);
	List<Configuracoes> findByResolucaoAbrev(String resolucaoAbrev);
	List<Configuracoes> findByApi(String api);
	
}
