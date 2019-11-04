package models.entities.tables;

import java.io.Serializable;
import java.util.Date;

public class Gpus implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idGpu;
	private ProcessadorGrafico ProcessadorGrafico;
	private CaracteristicasGraficas CaracteristicasGraficas;
	private RenderConfig RenderConfig;
	private String nomeFabricante;
	private String nomeModelo;
	private Integer tamMemoriaKB;
	private String tpMemoria;
	private Integer tamBanda;
	private Double tdp;
	private Double gpuClock;
	private Double boostClock;
	private Double memClock;
	private Double memClockEfetivo;
	private String busInterface;
	private Date dtLancto;
	
	public Gpus(Integer idGpu, models.entities.tables.ProcessadorGrafico processadorGrafico,
			models.entities.tables.CaracteristicasGraficas caracteristicasGraficas,
			models.entities.tables.RenderConfig renderConfig, String nomeFabricante, String nomeModelo,
			Integer tamMemoriaKB, String tpMemoria, Integer tamBanda, Double tdp, Double gpuClock, Double boostClock,
			Double memClock, Double memClockEfetivo, String busInterface, Date dtLancto) {
		this.idGpu = idGpu;
		this.ProcessadorGrafico = processadorGrafico;
		this.CaracteristicasGraficas = caracteristicasGraficas;
		this.RenderConfig = renderConfig;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.tamMemoriaKB = tamMemoriaKB;
		this.tpMemoria = tpMemoria;
		this.tamBanda = tamBanda;
		this.tdp = tdp;
		this.gpuClock = gpuClock;
		this.boostClock = boostClock;
		this.memClock = memClock;
		this.memClockEfetivo = memClockEfetivo;
		this.busInterface = busInterface;
		this.dtLancto = dtLancto;
	}

	public Integer getIdGpu() {
		return idGpu;
	}

	public void setIdGpu(Integer idGpu) {
		this.idGpu = idGpu;
	}

	public ProcessadorGrafico getProcessadorGrafico() {
		return ProcessadorGrafico;
	}

	public void setProcessadorGrafico(ProcessadorGrafico processadorGrafico) {
		ProcessadorGrafico = processadorGrafico;
	}

	public CaracteristicasGraficas getCaracteristicasGraficas() {
		return CaracteristicasGraficas;
	}

	public void setCaracteristicasGraficas(CaracteristicasGraficas caracteristicasGraficas) {
		CaracteristicasGraficas = caracteristicasGraficas;
	}

	public RenderConfig getRenderConfig() {
		return RenderConfig;
	}

	public void setRenderConfig(RenderConfig renderConfig) {
		RenderConfig = renderConfig;
	}

	public String getNomeFabricante() {
		return nomeFabricante;
	}

	public void setNomeFabricante(String nomeFabricante) {
		this.nomeFabricante = nomeFabricante;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public Integer getTamMemoriaKB() {
		return tamMemoriaKB;
	}

	public void setTamMemoriaKB(Integer tamMemoriaKB) {
		this.tamMemoriaKB = tamMemoriaKB;
	}

	public String getTpMemoria() {
		return tpMemoria;
	}

	public void setTpMemoria(String tpMemoria) {
		this.tpMemoria = tpMemoria;
	}

	public Integer getTamBanda() {
		return tamBanda;
	}

	public void setTamBanda(Integer tamBanda) {
		this.tamBanda = tamBanda;
	}

	public Double getTdp() {
		return tdp;
	}

	public void setTdp(Double tdp) {
		this.tdp = tdp;
	}

	public Double getGpuClock() {
		return gpuClock;
	}

	public void setGpuClock(Double gpuClock) {
		this.gpuClock = gpuClock;
	}

	public Double getBoostClock() {
		return boostClock;
	}

	public void setBoostClock(Double boostClock) {
		this.boostClock = boostClock;
	}

	public Double getMemClock() {
		return memClock;
	}

	public void setMemClock(Double memClock) {
		this.memClock = memClock;
	}

	public Double getMemClockEfetivo() {
		return memClockEfetivo;
	}

	public void setMemClockEfetivo(Double memClockEfetivo) {
		this.memClockEfetivo = memClockEfetivo;
	}

	public String getBusInterface() {
		return busInterface;
	}

	public void setBusInterface(String busInterface) {
		this.busInterface = busInterface;
	}

	public Date getDtLancto() {
		return dtLancto;
	}

	public void setDtLancto(Date dtLancto) {
		this.dtLancto = dtLancto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Gpus [idGpu=" + idGpu + ", ProcessadorGrafico=" + ProcessadorGrafico.getNomeGpu() + ", CaracteristicasGraficas="
				+ CaracteristicasGraficas.getDirectX() + ", RenderConfig=" + RenderConfig.getIdRenderConfig() + ", nomeFabricante=" + nomeFabricante
				+ ", nomeModelo=" + nomeModelo + ", tamMemoriaKB=" + tamMemoriaKB + ", tpMemoria=" + tpMemoria
				+ ", tamBanda=" + tamBanda + ", tdp=" + tdp + ", gpuClock=" + gpuClock + ", boostClock=" + boostClock
				+ ", memClock=" + memClock + ", memClockEfetivo=" + memClockEfetivo + ", busInterface=" + busInterface
				+ ", dtLancto=" + dtLancto + "]";
	}
	
	
}
