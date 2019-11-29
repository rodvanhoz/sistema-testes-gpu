package models.entities.tables;

import java.io.Serializable;
import java.util.Date;

public class Jogos implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idJogo;
	private String nomeJogo;
	private Date dtLancto;
	
	public Jogos(Integer idJogo, String nomeJogo, Date dtLancto) {
		this.idJogo = idJogo;
		this.nomeJogo = nomeJogo;
		this.dtLancto = dtLancto;
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Integer idJogo) {
		this.idJogo = idJogo;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
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
		return idJogo + " - " + nomeJogo;
	}
	
}
