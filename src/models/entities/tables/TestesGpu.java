package models.entities.tables;

import java.io.Serializable;
import java.util.Date;

public class TestesGpu implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTesteGpu;
	private ConfiguracoesJogos ConfiguracaoJogo;
	private Gpus Gpu;
	private Processadores Processador;
	private String nomeDriverGpu;
	private Double avgFps;
	private Double minFps;
	private Date dtTeste;
	private String nomeTester;
	public TestesGpu(Integer idTesteGpu, ConfiguracoesJogos configuracaoJogo, Gpus gpu, Processadores processador,
			String nomeDriverGpu, Double avgFps, Double minFps, Date dtTeste, String nomeTester) {
		this.idTesteGpu = idTesteGpu;
		this.ConfiguracaoJogo = configuracaoJogo;
		this.Gpu = gpu;
		this.Processador = processador;
		this.nomeDriverGpu = nomeDriverGpu;
		this.avgFps = avgFps;
		this.minFps = minFps;
		this.dtTeste = dtTeste;
		this.nomeTester = nomeTester;
	}
	public Integer getIdTesteGpu() {
		return idTesteGpu;
	}
	public void setIdTesteGpu(Integer idTesteGpu) {
		this.idTesteGpu = idTesteGpu;
	}
	public ConfiguracoesJogos getConfiguracaoJogo() {
		return ConfiguracaoJogo;
	}
	public void setConfiguracaoJogo(ConfiguracoesJogos configuracaoJogo) {
		ConfiguracaoJogo = configuracaoJogo;
	}
	public Gpus getGpu() {
		return Gpu;
	}
	public void setGpu(Gpus gpu) {
		Gpu = gpu;
	}
	public Processadores getProcessador() {
		return Processador;
	}
	public void setProcessador(Processadores processador) {
		Processador = processador;
	}
	public String getNomeDriverGpu() {
		return nomeDriverGpu;
	}
	public void setNomeDriverGpu(String nomeDriverGpu) {
		this.nomeDriverGpu = nomeDriverGpu;
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
	public Date getDtTeste() {
		return dtTeste;
	}
	public void setDtTeste(Date dtTeste) {
		this.dtTeste = dtTeste;
	}
	public String getNomeTester() {
		return nomeTester;
	}
	public void setNomeTester(String nomeTester) {
		this.nomeTester = nomeTester;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "TestesGpu [idTesteGpu=" + idTesteGpu + ", ConfiguracaoJogo=" + ConfiguracaoJogo + ", Gpu=" + Gpu.getNomeModelo()
				+ ", Processador=" + Processador.getNomeModelo() + ", nomeDriverGpu=" + nomeDriverGpu + ", avgFps=" + avgFps
				+ ", minFps=" + minFps + ", dtTeste=" + dtTeste + ", nomeTester=" + nomeTester + "]";
	}
	
	
}
