package models.entities.dao;

import java.util.List;

import models.entities.tables.Configuracoes;
import models.entities.tables.Jogos;

public interface ConfiguracoesDao {
	
	List<Configuracoes> findAll();
	Configuracoes findById(int idConfiguracao);
	List<Configuracoes> findByQualidadeGrafica(String qualidadeGrafica);
	List<Configuracoes> findByResolucaoAbrev(int resolucaoAbrev);
	List<Configuracoes> findByApi(String api);
	void inserir(Configuracoes configuracao);
	void atualizar(Configuracoes configuracao);
	void remover(Configuracoes configuracao);

	
}
