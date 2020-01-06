package models.entities.services;

import java.util.List;

import db.DbException;
import models.entities.dao.ConfiguracoesJogosDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.Configuracoes;
import models.entities.tables.ConfiguracoesJogos;
import models.entities.tables.Jogos;
import models.entities.views.ConfiguracoesJogosW;

public class ConfiguracoesJogosService {
	
	private ConfiguracoesJogosDao dao = DaoFactory.createConfiguracoesJogosDao();
	
	public List<ConfiguracoesJogosW> findAll() {
		return dao.findAll();
	}
	
	public ConfiguracoesJogosW findById(int idConfiguracaoJogos) {
		return dao.findById(idConfiguracaoJogos);
	}
	
	public ConfiguracoesJogos findByConfiguracaoJogos(int idConfiguracaoJogos) {
		return dao.findByConfiguracaoJogos(idConfiguracaoJogos);
	}
	
	public ConfiguracoesJogosW findByJogo(Jogos jogo) {
		return dao.findByJogo(jogo);
	}
	
	public ConfiguracoesJogosW findByConfiguracao(Configuracoes configuracao) {
		return dao.findByConfiguracao(configuracao);
	}
	
	public void inserir(ConfiguracoesJogos configuracaoJogo) {
		checaCamposConfiguracoesJogos(configuracaoJogo);
		dao.inserir(configuracaoJogo);
	}
	
	public void atualizar(ConfiguracoesJogos configuracaoJogo) {
		if (configuracaoJogo.getIdConfiguracaoJogo() == null || configuracaoJogo.getIdConfiguracaoJogo() == 0) {
			throw new DbException("ERRO: IdConfiguracaoJogo não informado para o update");
		}
		
		checaCamposConfiguracoesJogos(configuracaoJogo);
		dao.atualizar(configuracaoJogo);
	}
	
	public void remover(ConfiguracoesJogos configuracaoJogo) {
		dao.remover(configuracaoJogo);
	}
	
	private void checaCamposConfiguracoesJogos(ConfiguracoesJogos config) {
		if (config.getConfiguracao() == null) {
			throw new DbException("Configuração é obrigatório");
		}
		if (config.getJogo() == null) {
			throw new DbException("Jogo é obrigatório");
		}
	}

}
