package models.entities.views;

import java.io.Serializable;
import java.util.Date;

public class DadosTeste implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nomeModeloGpu;
	private String nomeModeloProcessador;
	private String nomeJogo;
	private Integer resolucaoAbrev;
	private String qualidadeGrafica;
	private String api;
	private String fxaa;
	private String ssao;
	private String aa;
	private String rt;
	private String taa;
	private String NVidiaTec;
	private Double avgFps;
	private Double minFps;
	private String nomeTester;
	private Date dtTeste;
	private String nomeDriverGpu;
	private Integer idTesteGpu;
	private Integer idJogo; 
	private Integer idConfiguracao; 
	private Integer idConfiguracaoJogo; 
	private Integer idGpu; 
	private Integer idProcessador;
	
	public DadosTeste(String nomeModeloGpu, String nomeModeloProcessador, String nomeJogo, Integer resolucaoAbrev,
			String qualidadeGrafica, String api, String fxaa, String ssao, String aa, String rt, String taa,
			String nVidiaTec, Double avgFps, Double minFps, String nomeTester, Date dtTeste, String nomeDriverGpu,
			Integer idTesteGpu, Integer idJogo, Integer idConfiguracao, Integer idConfiguracaoJogo, Integer idGpu, Integer idProcessador) {
		this.nomeModeloGpu = nomeModeloGpu;
		this.nomeModeloProcessador = nomeModeloProcessador;
		this.nomeJogo = nomeJogo;
		this.resolucaoAbrev = resolucaoAbrev;
		this.qualidadeGrafica = qualidadeGrafica;
		this.api = api;
		this.fxaa = fxaa;
		this.ssao = ssao;
		this.aa = aa;
		this.rt = rt;
		this.taa = taa;
		this.NVidiaTec = nVidiaTec;
		this.avgFps = avgFps;
		this.minFps = minFps;
		this.nomeTester = nomeTester;
		this.dtTeste = dtTeste;
		this.nomeDriverGpu = nomeDriverGpu;
		this.idTesteGpu = idTesteGpu;
		this.idJogo = idJogo; 
		this.idConfiguracao = idConfiguracao; 
		this.idConfiguracaoJogo = idConfiguracaoJogo; 
		this.idGpu = idGpu; 
		this.idProcessador = idProcessador;
	}

	public String getNomeModeloGpu() {
		return nomeModeloGpu;
	}

	public void setNomeModeloGpu(String nomeModeloGpu) {
		this.nomeModeloGpu = nomeModeloGpu;
	}

	public String getNomeModeloProcessador() {
		return nomeModeloProcessador;
	}

	public void setNomeModeloProcessador(String nomeModeloProcessador) {
		this.nomeModeloProcessador = nomeModeloProcessador;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public Integer getResolucaoAbrev() {
		return resolucaoAbrev;
	}

	public void setResolucaoAbrev(Integer resolucaoAbrev) {
		this.resolucaoAbrev = resolucaoAbrev;
	}

	public String getQualidadeGrafica() {
		return qualidadeGrafica;
	}

	public void setQualidadeGrafica(String qualidadeGrafica) {
		this.qualidadeGrafica = qualidadeGrafica;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getFxaa() {
		return fxaa;
	}

	public void setFxaa(String fxaa) {
		this.fxaa = fxaa;
	}

	public String getSsao() {
		return ssao;
	}

	public void setSsao(String ssao) {
		this.ssao = ssao;
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getTaa() {
		return taa;
	}

	public void setTaa(String taa) {
		this.taa = taa;
	}

	public String getNVidiaTec() {
		return NVidiaTec;
	}

	public void setNVidiaTec(String nVidiaTec) {
		NVidiaTec = nVidiaTec;
	}

	public Double getAvgFps() {
		return avgFps;
	}

	public void setAvgFps(Double avgFps) {
		this.avgFps = avgFps;
	}

	public Double getMinFps() {
		return minFps;
	}

	public void setMinFps(Double minFps) {
		this.minFps = minFps;
	}

	public String getNomeTester() {
		return nomeTester;
	}

	public void setNomeTester(String nomeTester) {
		this.nomeTester = nomeTester;
	}

	public Date getDtTeste() {
		return dtTeste;
	}

	public void setDtTeste(Date dtTeste) {
		this.dtTeste = dtTeste;
	}

	public String getNomeDriverGpu() {
		return nomeDriverGpu;
	}

	public void setNomeDriverGpu(String nomeDriverGpu) {
		this.nomeDriverGpu = nomeDriverGpu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdTesteGpu() {
		return idTesteGpu;
	}

	public void setIdTesteGpu(Integer idTesteGpu) {
		this.idTesteGpu = idTesteGpu;
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Integer idJogo) {
		this.idJogo = idJogo;
	}

	public Integer getIdConfiguracao() {
		return idConfiguracao;
	}

	public void setIdConfiguracao(Integer idConfiguracao) {
		this.idConfiguracao = idConfiguracao;
	}

	public Integer getIdConfiguracaoJogo() {
		return idConfiguracaoJogo;
	}

	public void setIdConfiguracaoJogo(Integer idConfiguracaoJogo) {
		this.idConfiguracaoJogo = idConfiguracaoJogo;
	}

	public Integer getIdGpu() {
		return idGpu;
	}

	public void setIdGpu(Integer idGpu) {
		this.idGpu = idGpu;
	}

	public Integer getIdProcessador() {
		return idProcessador;
	}

	public void setIdProcessador(Integer idProcessador) {
		this.idProcessador = idProcessador;
	}

	@Override
	public String toString() {
		return "DadosTeste [nomeModeloGpu=" + nomeModeloGpu + ", nomeModeloProcessador=" + nomeModeloProcessador
				+ ", nomeJogo=" + nomeJogo + ", resolucaoAbrev=" + resolucaoAbrev + ", qualidadeGrafica="
				+ qualidadeGrafica + ", api=" + api + ", fxaa=" + fxaa + ", ssao=" + ssao + ", aa=" + aa + ", rt=" + rt
				+ ", taa=" + taa + ", NVidiaTec=" + NVidiaTec + ", avgFps=" + avgFps + ", minFps=" + minFps
				+ ", nomeTester=" + nomeTester + ", dtTeste=" + dtTeste + ", nomeDriverGpu=" + nomeDriverGpu + "]";
	}
	
	
}
