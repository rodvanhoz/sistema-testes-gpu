package models.entities.dao;

import java.util.List;

import models.entities.tables.Configuracoes;
import models.entities.tables.ConfiguracoesJogos;
import models.entities.tables.Jogos;
import models.entities.views.ConfiguracoesJogosW;

public interface ConfiguracoesJogosDao {

	List<ConfiguracoesJogosW> findAll();
	ConfiguracoesJogosW findById(int idConfiguracaoJogos);
	ConfiguracoesJogosW findByJogo(Jogos jogo);
	ConfiguracoesJogosW findByConfiguracao(Configuracoes configuracao);
	ConfiguracoesJogos findByConfiguracaoJogos(int idConfiguracaoJogos);
	void inserir(ConfiguracoesJogos configuracaoJogo);
	void atualizar(ConfiguracoesJogos configuracaoJogo);
	void remover(ConfiguracoesJogos configuracaoJogo);
}
