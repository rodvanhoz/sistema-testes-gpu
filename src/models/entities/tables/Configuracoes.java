package models.entities.tables;

import java.io.Serializable;

public class Configuracoes implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idConfiguracao;
	private Integer resolucaoAbrev;
	private String resolucaoDetalhe;
	private String api;
	private String qualidadeGrafica;
	private String ssao;
	private String fxaa;
	private String taa;
	private String rt;
	private String aa;
	private String NVidiaTec;
	
	public Configuracoes(Integer idConfiguracao, Integer resolucaoAbrev, String resolucaoDetalhe, String api,
			String qualidadeGrafica, String ssao, String fxaa, String taa, String rt, String aa, String nVidiaTec) {
		this.idConfiguracao = idConfiguracao;
		this.resolucaoAbrev = resolucaoAbrev;
		this.resolucaoDetalhe = resolucaoDetalhe;
		this.api = api;
		this.qualidadeGrafica = qualidadeGrafica;
		this.ssao = ssao;
		this.fxaa = fxaa;
		this.taa = taa;
		this.rt = rt;
		this.aa = aa;
		NVidiaTec = nVidiaTec;
	}

	public Integer getIdConfiguracao() {
		return idConfiguracao;
	}

	public void setIdConfiguracao(Integer idConfiguracao) {
		this.idConfiguracao = idConfiguracao;
	}

	public Integer getResolucaoAbrev() {
		return resolucaoAbrev;
	}

	public void setResolucaoAbrev(Integer resolucaoAbrev) {
		this.resolucaoAbrev = resolucaoAbrev;
	}

	public String getResolucaoDetalhe() {
		return resolucaoDetalhe;
	}

	public void setResolucaoDetalhe(String resolucaoDetalhe) {
		this.resolucaoDetalhe = resolucaoDetalhe;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getQualidadeGrafica() {
		return qualidadeGrafica;
	}

	public void setQualidadeGrafica(String qualidadeGrafica) {
		this.qualidadeGrafica = qualidadeGrafica;
	}

	public String getSsao() {
		return ssao;
	}

	public void setSsao(String ssao) {
		this.ssao = ssao;
	}

	public String getFxaa() {
		return fxaa;
	}

	public void setFxaa(String fxaa) {
		this.fxaa = fxaa;
	}

	public String getTaa() {
		return taa;
	}

	public void setTaa(String taa) {
		this.taa = taa;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getNVidiaTec() {
		return NVidiaTec;
	}

	public void setNVidiaTec(String nVidiaTec) {
		NVidiaTec = nVidiaTec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Configuracoes [idConfiguracao=" + idConfiguracao + ", resolucaoAbrev=" + resolucaoAbrev
				+ ", resolucaoDetalhe=" + resolucaoDetalhe + ", api=" + api + ", qualidadeGrafica=" + qualidadeGrafica
				+ ", ssao=" + ssao + ", fxaa=" + fxaa + ", taa=" + taa + ", rt=" + rt + ", aa=" + aa + ", NVidiaTec="
				+ NVidiaTec + "]";
	}	
	
}
