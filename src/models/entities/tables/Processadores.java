package models.entities.tables;

import java.io.Serializable;
import java.util.Date;

public class Processadores implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProcessador;
	private DadosProcessador DadosProcessador;
	private String nomeFabricante;
	private String nomeModelo;
	private String market;
	private Date released;
	private String codename;
	private String generation;
	private String memorySupport;
	private Double frequencia;
	private Double turbofrequencia;
	private Double baseClock;
	private Double multiplicador;
	private String multiplDesbloqueado;
	private Integer nroCores;
	private Integer nroThreads;
	private Integer smp;
	private Gpus Gpu;
	private Double tdp;
	
	public Processadores(Integer idProcessador, models.entities.tables.DadosProcessador dadosProcessador,
			String nomeFabricante, String nomeModelo, String market, Date released, String codename, String generation,
			String memorySupport, Double frequencia, Double turbofrequencia, Double baseClock, Double multiplicador,
			String multiplDesbloqueado, Integer nroCores, Integer nroThreads, Integer smp, Gpus gpu, Double tdp) {
		this.idProcessador = idProcessador;
		this.DadosProcessador = dadosProcessador;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.market = market;
		this.released = released;
		this.codename = codename;
		this.generation = generation;
		this.memorySupport = memorySupport;
		this.frequencia = frequencia;
		this.turbofrequencia = turbofrequencia;
		this.baseClock = baseClock;
		this.multiplicador = multiplicador;
		this.multiplDesbloqueado = multiplDesbloqueado;
		this.nroCores = nroCores;
		this.nroThreads = nroThreads;
		this.smp = smp;
		this.Gpu = gpu;
		this.tdp = tdp;
	}

	public Integer getIdProcessador() {
		return idProcessador;
	}

	public void setIdProcessador(Integer idProcessador) {
		this.idProcessador = idProcessador;
	}

	public DadosProcessador getDadosProcessador() {
		return DadosProcessador;
	}

	public void setDadosProcessador(DadosProcessador dadosProcessador) {
		DadosProcessador = dadosProcessador;
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

	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public String getCodename() {
		return codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getMemorySupport() {
		return memorySupport;
	}

	public void setMemorySupport(String memorySupport) {
		this.memorySupport = memorySupport;
	}

	public Double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}

	public Double getTurbofrequencia() {
		return turbofrequencia;
	}

	public void setTurbofrequencia(Double turbofrequencia) {
		this.turbofrequencia = turbofrequencia;
	}

	public Double getBaseClock() {
		return baseClock;
	}

	public void setBaseClock(Double baseClock) {
		this.baseClock = baseClock;
	}

	public Double getMultiplicador() {
		return multiplicador;
	}

	public void setMultiplicador(Double multiplicador) {
		this.multiplicador = multiplicador;
	}

	public String getMultiplDesbloqueado() {
		return multiplDesbloqueado;
	}

	public void setMultiplDesbloqueado(String multiplDesbloqueado) {
		this.multiplDesbloqueado = multiplDesbloqueado;
	}

	public Integer getNroCores() {
		return nroCores;
	}

	public void setNroCores(Integer nroCores) {
		this.nroCores = nroCores;
	}

	public Integer getNroThreads() {
		return nroThreads;
	}

	public void setNroThreads(Integer nroThreads) {
		this.nroThreads = nroThreads;
	}

	public Integer getSmp() {
		return smp;
	}

	public void setSmp(Integer smp) {
		this.smp = smp;
	}

	public Gpus getGpu() {
		return Gpu;
	}

	public void setGpu(Gpus gpu) {
		Gpu = gpu;
	}

	public Double getTdp() {
		return tdp;
	}

	public void setTdp(Double tdp) {
		this.tdp = tdp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Processadores [idProcessador=" + idProcessador + ", DadosProcessador=" + DadosProcessador.getIdDadosProcessador()
				+ ", nomeFabricante=" + nomeFabricante + ", nomeModelo=" + nomeModelo + ", market=" + market
				+ ", released=" + released + ", codename=" + codename + ", generation=" + generation
				+ ", memorySupport=" + memorySupport + ", frequencia=" + frequencia + ", turbofrequencia="
				+ turbofrequencia + ", baseClock=" + baseClock + ", multiplicador=" + multiplicador
				+ ", multiplDesbloqueado=" + multiplDesbloqueado + ", nroCores=" + nroCores + ", nroThreads="
				+ nroThreads + ", smp=" + smp + ", Gpu=" + Gpu.getNomeModelo() + ", tdp=" + tdp + "]";
	}


}
