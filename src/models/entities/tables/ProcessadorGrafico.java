package models.entities.tables;

import java.io.Serializable;

public class ProcessadorGrafico implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProcGrafico;
	private String nomeGpu;
	private String variantGpu;
	private String arquitetura;
	private String fundicao;
	private Integer nnProcessador;
	private Double nroTransistors;
	private Integer mmProcessador;
	
	public ProcessadorGrafico(Integer idProcGrafico, String nomeGpu, String variantGpu, String arquitetura,
			String fundicao, Integer nnProcessador, Double nroTransistors, Integer mmProcessador) {
		this.idProcGrafico = idProcGrafico;
		this.nomeGpu = nomeGpu;
		this.variantGpu = variantGpu;
		this.arquitetura = arquitetura;
		this.fundicao = fundicao;
		this.nnProcessador = nnProcessador;
		this.nroTransistors = nroTransistors;
		this.mmProcessador = mmProcessador;
	}

	public Integer getIdProcGrafico() {
		return idProcGrafico;
	}

	public void setIdProcGrafico(Integer idProcGrafico) {
		this.idProcGrafico = idProcGrafico;
	}

	public String getNomeGpu() {
		return nomeGpu;
	}

	public void setNomeGpu(String nomeGpu) {
		this.nomeGpu = nomeGpu;
	}

	public String getVariantGpu() {
		return variantGpu;
	}

	public void setVariantGpu(String variantGpu) {
		this.variantGpu = variantGpu;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public String getFundicao() {
		return fundicao;
	}

	public void setFundicao(String fundicao) {
		this.fundicao = fundicao;
	}

	public Integer getNnProcessador() {
		return nnProcessador;
	}

	public void setNnProcessador(Integer nnProcessador) {
		this.nnProcessador = nnProcessador;
	}

	public Double getNroTransistors() {
		return nroTransistors;
	}

	public void setNroTransistors(Double nroTransistors) {
		this.nroTransistors = nroTransistors;
	}

	public Integer getMmProcessador() {
		return mmProcessador;
	}

	public void setMmProcessador(Integer mmProcessador) {
		this.mmProcessador = mmProcessador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProcessadorGrafico [idProcGrafico=" + idProcGrafico + ", nomeGpu=" + nomeGpu + ", variantGpu="
				+ variantGpu + ", arquitetura=" + arquitetura + ", fundicao=" + fundicao + ", nnProcessador="
				+ nnProcessador + ", nroTransistors=" + nroTransistors + ", mmProcessador=" + mmProcessador + "]";
	}
	
}
