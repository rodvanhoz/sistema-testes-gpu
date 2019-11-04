package models.entities.tables;

import java.io.Serializable;

public class Arquiteturas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idArquitetura;
	private String nomeArquitetura;
	
	public Arquiteturas(Integer idArquitetura, String nomeArquitetura) {
		this.idArquitetura = idArquitetura;
		this.nomeArquitetura = nomeArquitetura;
	}

	public Integer getIdArquitetura() {
		return idArquitetura;
	}

	public void setIdArquitetura(Integer idArquitetura) {
		this.idArquitetura = idArquitetura;
	}

	public String getNomeArquitetura() {
		return nomeArquitetura;
	}

	public void setNomeArquitetura(String nomeArquitetura) {
		this.nomeArquitetura = nomeArquitetura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Arquiteturas [idArquitetura=" + idArquitetura + ", nomeArquitetura=" + nomeArquitetura + "]";
	}

}
