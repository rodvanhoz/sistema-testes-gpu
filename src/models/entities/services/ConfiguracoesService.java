package models.entities.services;

import java.util.List;

import models.entities.dao.ConfiguracoesDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.Configuracoes;

public class ConfiguracoesService {
	private ConfiguracoesDao dao = DaoFactory.createConfiguracoesDao();
	
	public List<Configuracoes> findAll() {
		return dao.findAll();
	}

	public Configuracoes findById(int idConfiguracao) {
		return dao.findById(idConfiguracao);
	}
	
	public List<Configuracoes> findByApi(String api) {
		return dao.findByApi(api);
	}

	public List<Configuracoes> findByQualidadeGrafica(String qualidadeGrafica) {
		return dao.findByQualidadeGrafica(qualidadeGrafica);
	}

	public List<Configuracoes> findByResolucaoAbrev(int resolucaoAbrev) {
		return dao.findByResolucaoAbrev(resolucaoAbrev);
	}
	
	public void inserir(Configuracoes configuracao) {
		dao.inserir(configuracao);
	}
	
	public void atualizar(Configuracoes configuracao) {
		dao.atualizar(configuracao);
	}
	
	public void remover(Configuracoes configuracao) {
		dao.remover(configuracao);
	}
	
}
