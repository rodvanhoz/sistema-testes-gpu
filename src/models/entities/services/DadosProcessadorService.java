package models.entities.services;

import java.util.List;

import db.DbException;
import models.entities.dao.DadosProcessadorDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.DadosProcessador;

public class DadosProcessadorService {
	
	private DadosProcessadorDao dao = DaoFactory.createDadosProcessadorDao();
	
	public List<DadosProcessador> findAll() {
		return dao.findAll();
	}
	
	public DadosProcessador findById(int idDadosProcessador) {
		return dao.findById(idDadosProcessador);
	}
	
	public void inserir(DadosProcessador dadosProcessador) {
		dao.inserir(checaCamposDadosProcessador(dadosProcessador));
	}
	
	public void atualizar(DadosProcessador dadosProcessador) {
		if (dadosProcessador.getIdDadosProcessador() == null || dadosProcessador.getIdDadosProcessador() == 0) {
			throw new DbException("ERRO: IdDadosProcessador não informado para o update");
		}
		dao.atualizar(checaCamposDadosProcessador(dadosProcessador));
	}
	
	public void remover(DadosProcessador dadosProcessador) {
		dao.remover(dadosProcessador);
	}
	
	private DadosProcessador checaCamposDadosProcessador(DadosProcessador dados) {
		
		DadosProcessador d = dados;
		
		if (dados.getProcessSize() == null) {
			d.setProcessSize(0);
		}
		if (dados.gettCaseMax() == null) {
			d.settCaseMax(0.0);
		}
		if (dados.getTransistors() == null) {
			d.setTransistors(0.0);
		}
		
		return d;
	}

}
