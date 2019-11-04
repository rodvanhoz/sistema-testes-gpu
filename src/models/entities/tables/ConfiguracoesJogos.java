package models.entities.tables;

import java.io.Serializable;

public class ConfiguracoesJogos implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idConfiguracaoJogo;
	private Jogos Jogo;
	private Configuracoes Configuracao;
	
	public ConfiguracoesJogos(Integer idConfiguracaoJogo, Jogos jogo, Configuracoes configuracao) {
		this.idConfiguracaoJogo = idConfiguracaoJogo;
		this.Jogo = jogo;
		this.Configuracao = configuracao;
	}

	public Integer getIdConfiguracaoJogo() {
		return idConfiguracaoJogo;
	}

	public void setIdConfiguracaoJogo(Integer idConfiguracaoJogo) {
		this.idConfiguracaoJogo = idConfiguracaoJogo;
	}

	public Jogos getJogo() {
		return Jogo;
	}

	public void setJogo(Jogos jogo) {
		Jogo = jogo;
	}

	public Configuracoes getConfiguracao() {
		return Configuracao;
	}

	public void setConfiguracao(Configuracoes configuracao) {
		Configuracao = configuracao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ConfiguracoesJogos [idConfiguracaoJogo=" + idConfiguracaoJogo + ", Jogo=" + Jogo.getNomeJogo() + ", Configuracao="
				+ Configuracao.getQualidadeGrafica() + "]";
	}
	
	
	
}
