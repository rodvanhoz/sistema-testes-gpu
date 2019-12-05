package models.entities.views;

import java.io.Serializable;

public class Processador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idProcessador;
	private String nomeFabricante;
	private String nomeModelo;
	private Integer nroCores;
	private Integer nroThreads;
	private Double tdp;
	private Double frequencia;
	private Double turboFrequencia;
	private String codeName;
	private String socket;
	private String graficoIntegrado;
	private int idDadosProcessador;
	
	public Processador(Integer idProcessador, String nomeFabricante, String nomeModelo, Integer nroCores,
			Integer nroThreads, Double tdp, Double frequencia, Double turboFrequencia, String codeName, String socket,
			String graficoIntegrado, int idDadosProcessador) {
		this.idProcessador = idProcessador;
		this.nomeFabricante = nomeFabricante;
		this.nomeModelo = nomeModelo;
		this.nroCores = nroCores;
		this.nroThreads = nroThreads;
		this.tdp = tdp;
		this.frequencia = frequencia;
		this.turboFrequencia = turboFrequencia;
		this.codeName = codeName;
		this.socket = socket;
		this.graficoIntegrado = graficoIntegrado;
		this.idDadosProcessador = idDadosProcessador;
	}

	public int getIdDadosProcessador() {
		return idDadosProcessador;
	}


	public void setIdDadosProcessador(int idDadosProcessador) {
		this.idDadosProcessador = idDadosProcessador;
	}


	public Integer getIdProcessador() {
		return idProcessador;
	}

	public void setIdProcessador(Integer idProcessador) {
		this.idProcessador = idProcessador;
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

	public Double getTdp() {
		return tdp;
	}

	public void setTdp(Double tdp) {
		this.tdp = tdp;
	}

	public Double getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}

	public Double getTurboFrequencia() {
		return turboFrequencia;
	}

	public void setTurboFrequencia(Double turboFrequencia) {
		this.turboFrequencia = turboFrequencia;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getGraficoIntegrado() {
		return graficoIntegrado;
	}

	public void setGraficoIntegrado(String graficoIntegrado) {
		this.graficoIntegrado = graficoIntegrado;
	}

	@Override
	public String toString() {
		return idProcessador + ": " + nomeFabricante + " " + nomeModelo + " " + nroCores + " cores / " + nroThreads + " threads";
	}
	
}
