package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.ProcessadorDao;
import models.entities.tables.Gpus;
import models.entities.tables.Processadores;
import models.entities.views.Processador;

public class ProcessadorService {
	
	private ProcessadorDao dao = DaoFactory.createProcessadorDao();
	
	public List<Processador> findAll() {
		return dao.findAll();
	}
	
	public List<Processador> findByModelo(String modelo) {
		return dao.findByModelo(modelo);
	}
	
	public List<Processador> findByFabricante(String fabricante) {
		return dao.findByFabricante(fabricante);
	}
	
	public List<Processador> findByCodename(String codename) {
		return dao.findByCodename(codename);
	}
	
	public List<Processador> findByGraficoIntegrado(Gpus graficoIntegrado) {
		return dao.findByGraficoIntegrado(graficoIntegrado);
	}
	
	public Processador findById(int idProcessador) {
		return dao.findById(idProcessador);
	}

	public Processadores findByIdProcessadores(int idProcessador) {
		return dao.findByIdProcessadores(idProcessador);
	}

	public void inserir(Processadores processador) {
		dao.inserir(processador);
	}
	
	public void atualizar(Processadores processador) {
		dao.atualizar(processador);
	}
	
	public void remover(Processadores processador) {
		dao.remover(processador);
	}
	
}
