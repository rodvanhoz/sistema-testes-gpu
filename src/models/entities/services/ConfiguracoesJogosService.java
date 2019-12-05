package models.entities.services;

import java.util.List;

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
		dao.inserir(configuracaoJogo);
	}
	
	public void atualizar(ConfiguracoesJogos configuracaoJogo) {
		dao.atualizar(configuracaoJogo);
	}
	
	public void remover(ConfiguracoesJogos configuracaoJogo) {
		dao.remover(configuracaoJogo);
	}

}
