package models.entities.services;

import java.util.List;

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
		dao.inserir(dadosProcessador);
	}
	
	public void atualizar(DadosProcessador dadosProcessador) {
		dao.atualizar(dadosProcessador);
	}
	
	public void remover(DadosProcessador dadosProcessador) {
		dao.remover(dadosProcessador);
	}

}
