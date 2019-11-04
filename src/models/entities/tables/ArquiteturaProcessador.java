package models.entities.tables;

import java.io.Serializable;

public class ArquiteturaProcessador implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idArquiteturaProc;
	private Arquiteturas Arquitetura;
	private Processadores Processador;
	
	public ArquiteturaProcessador(Integer idArquiteturaProc, Arquiteturas arquitetura, Processadores processador) {
		this.idArquiteturaProc = idArquiteturaProc;
		Arquitetura = arquitetura;
		Processador = processador;
	}

	public Integer getIdArquiteturaProc() {
		return idArquiteturaProc;
	}

	public void setIdArquiteturaProc(Integer idArquiteturaProc) {
		this.idArquiteturaProc = idArquiteturaProc;
	}

	public Arquiteturas getArquitetura() {
		return Arquitetura;
	}

	public void setArquitetura(Arquiteturas arquitetura) {
		Arquitetura = arquitetura;
	}

	public Processadores getProcessador() {
		return Processador;
	}

	public void setProcessador(Processadores processador) {
		Processador = processador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArquiteturaProcessador [idArquiteturaProc=" + idArquiteturaProc + ", Arquitetura=" + Arquitetura.getNomeArquitetura()
				+ ", Processador=" + Processador + "]";
	}
	
}
