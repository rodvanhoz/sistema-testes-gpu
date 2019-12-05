package models.entities.views;

import java.io.Serializable;
import java.util.Date;

public class PlacaDeVideo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer idGpu;
	private String nomeFabricante;
	private String nomeModelo;
	private String nomeGpu;
	private String arquitetura;
	private Integer shadingUnits;
	private Integer rops;
	private Integer tmus;
	private Integer tamMemoriaKB;
	private String tpMemoria;
	private Double gpuClock;
	private Double boostClock;
	private String directX;
	private String openGL;
	private String openCL;
	private String vulkan;
	private Double memClock;
	private Double memClockEfetivo;
	private Integer tamBanda;
	private Double tdp;
	private String busInterface;
	private Date dtLancto;
	
	public PlacaDeVideo(Integer idGpu, String nomeFabricante, String nomeModelo, String nomeGpu, String arquitetura,
			Integer shadingUnits, Integer rops, Integer tmus, Integer tamMemoriaKB, String tpMemoria, Double gpuClock,
			Double boostClock, String directX, String openGL, String openCL, String vulkan, Double memClock, Double memClockEfetivo, 
			Integer tamBanda, Double tdp, String busInterface, Date dtLancto) {
		this.idGpu = idGpu;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.nomeGpu = nomeGpu;
		this.arquitetura = arquitetura;
		this.shadingUnits = shadingUnits;
		this.rops = rops;
		this.tmus = tmus;
		this.tamMemoriaKB = tamMemoriaKB;
		this.tpMemoria = tpMemoria;
		this.gpuClock = gpuClock;
		this.boostClock = boostClock;
		this.directX = directX;
		this.openGL = openGL;
		this.openCL = openCL;
		this.vulkan = vulkan;
		this.memClock = memClock;
		this.memClockEfetivo = memClockEfetivo;
		this.tamBanda = tamBanda;
		this.tdp = tdp;
		this.busInterface = busInterface;
		this.dtLancto = dtLancto;
	}

	public Integer getIdGpu() {
		return idGpu;
	}

	public void setIdGpu(Integer idGpu) {
		this.idGpu = idGpu;
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

	public String getNomeGpu() {
		return nomeGpu;
	}

	public void setNomeGpu(String nomeGpu) {
		this.nomeGpu = nomeGpu;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public Integer getShadingUnits() {
		return shadingUnits;
	}

	public void setShadingUnits(Integer shadingUnits) {
		this.shadingUnits = shadingUnits;
	}

	public Integer getRops() {
		return rops;
	}

	public void setRops(Integer rops) {
		this.rops = rops;
	}

	public Integer getTmus() {
		return tmus;
	}

	public void setTmus(Integer tmus) {
		this.tmus = tmus;
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

	public String getDirectX() {
		return directX;
	}

	public void setDirectX(String directX) {
		this.directX = directX;
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
	
	public String getOpenGL() {
		return openGL;
	}

	public void setOpenGL(String openGL) {
		this.openGL = openGL;
	}

	public String getOpenCL() {
		return openCL;
	}

	public void setOpenCL(String openCL) {
		this.openCL = openCL;
	}

	public String getVulkan() {
		return vulkan;
	}

	public void setVulkan(String vulkan) {
		this.vulkan = vulkan;
	}

	@Override
	public String toString() {
		return idGpu + ": " + nomeFabricante + " " + nomeModelo + " - " + tamMemoriaKB + " MB " + tpMemoria;
	}

}
