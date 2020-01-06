package models.entities.services;

import java.util.List;

import db.DbException;
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
		checaCamposConfiguracoes(configuracao);
		dao.inserir(configuracao);
	}
	
	public void atualizar(Configuracoes configuracao) {
		if (configuracao.getIdConfiguracao() == null || configuracao.getIdConfiguracao() == 0) {
			throw new DbException("ERRO: IdConfiguracao não informado para o update");
		}
		checaCamposConfiguracoes(configuracao);
		dao.atualizar(configuracao);
	}
	
	public void remover(Configuracoes configuracao) {
		dao.remover(configuracao);
	}
	
	private void checaCamposConfiguracoes(Configuracoes configuracoes) {
		if (configuracoes.getResolucaoAbrev() == null || configuracoes.getResolucaoAbrev() == 0) {
			throw new DbException("Resolução Abreviada é obrigatório");
		}
		if (configuracoes.getResolucaoDetalhe() == null || configuracoes.getResolucaoDetalhe() == "") {
			throw new DbException("Resolução é obrigatório");
		}
		if (configuracoes.getResolucaoDetalhe().indexOf("x") <= 0) {
			throw new DbException("Formato da Resolução tem que ser no padrão 9999x9999. Ex: 1920x1080");
		}
		if (Integer.parseInt(configuracoes.getResolucaoDetalhe().split("x")[1]) != configuracoes.getResolucaoAbrev()) {
			throw new DbException("Resolução detalhe diferente da abreviada: " + configuracoes.getResolucaoDetalhe() + " e " + configuracoes.getResolucaoAbrev());
		}
	}
	
}
