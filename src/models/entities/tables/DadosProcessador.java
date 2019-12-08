package models.entities.tables;

import java.io.Serializable;

public class DadosProcessador implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idDadosProcessador;
	private String socket;
	private String foundry;
	private Integer processSize;
	private Double transistors;
	private String packag;
	private Double tCaseMax;
	
	public DadosProcessador(Integer idDadosProcessador, String socket, String foundry, Integer processSize,
			Double transistors, String packag, Double tCaseMax) {
		this.idDadosProcessador = idDadosProcessador;
		this.socket = socket;
		this.foundry = foundry;
		this.processSize = processSize;
		this.transistors = transistors;
		this.packag = packag;
		this.tCaseMax = tCaseMax;
	}

	public Integer getIdDadosProcessador() {
		return idDadosProcessador;
	}

	public void setIdDadosProcessador(Integer idDadosProcessador) {
		this.idDadosProcessador = idDadosProcessador;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getFoundry() {
		return foundry;
	}

	public void setFoundry(String foundry) {
		this.foundry = foundry;
	}

	public Integer getProcessSize() {
		return processSize;
	}

	public void setProcessSize(Integer processSize) {
		this.processSize = processSize;
	}

	public Double getTransistors() {
		return transistors;
	}

	public void setTransistors(Double transistors) {
		this.transistors = transistors;
	}

	public String getPackag() {
		return packag;
	}

	public void setPackag(String packag) {
		this.packag = packag;
	}

	public Double gettCaseMax() {
		return tCaseMax;
	}

	public void settCaseMax(Double tCaseMax) {
		this.tCaseMax = tCaseMax;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return idDadosProcessador + ": " + socket + ", foundry="
				+ foundry + ", processSize=" + processSize + ", transistors=" + transistors + ", packag=" + packag
				+ ", tCaseMax=" + tCaseMax + "]";
	}
}
