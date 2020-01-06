package models.entities.services;

import java.util.List;

import db.DbException;
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
		dao.inserir(checaCamposProcessadores(processador));
	}
	
	public void atualizar(Processadores processador) {
		if (processador.getIdProcessador() == null || processador.getIdProcessador() == 0) {
			throw new DbException("ERRO: IdProcessador não foi informado para o update");
		}
		
		dao.atualizar(checaCamposProcessadores(processador));
	}
	
	public void remover(Processadores processador) {
		dao.remover(processador);
	}
	
	private Processadores checaCamposProcessadores(Processadores processador) {
		Processadores p = processador;
		
		if (processador.getNomeFabricante() == "" || processador.getNomeFabricante() == null) {
			throw new DbException("Nome do Fabricante é obrigatório");
		}
		if (processador.getNomeModelo() == "" || processador.getNomeModelo() == null) {
			throw new DbException("Descrição do modelo é obrigatório");
		}
		if (processador.getReleased() == null) {
			throw new DbException("Data de Lancto. é obrigatório");
		}
		if (processador.getMemorySupport() == "" || processador.getMemorySupport() == null) {
			throw new DbException("Memory Suport é obrigatório");
		}
		if (processador.getFrequencia()  == null || processador.getFrequencia() == 0) {
			throw new DbException("Clock da Frequência é obrigatório");
		}
		if (processador.getTurbofrequencia() == null || processador.getTurbofrequencia() == 0) {
			throw new DbException("Clock do Turbo Frequência é obrigatório");
		}
		if (processador.getBaseClock() == null || processador.getBaseClock() == 0) {
			throw new DbException("Base Clock é obrigatório");
		}
		if (processador.getMultiplicador() == null || processador.getMultiplicador() == 0) {
			throw new DbException("Valor do Multiplicador é obrigatório");
		}
		if (processador.getMultiplDesbloqueado() == "" || processador.getMultiplDesbloqueado() == null) {
			throw new DbException("Informar se o Multiplicador é desbloqueado (Y/N)");
		}
		if (processador.getNroCores() == null || processador.getNroCores() == 0) {
			throw new DbException("Nro. Cores é obrigatório");
		}
		if (processador.getNroThreads() == null || processador.getNroThreads() == 0) {
			p.setNroThreads(processador.getNroCores());
		}
		if (processador.getTdp() == null || processador.getTdp() == 0) {
			throw new DbException("TDP é obrigatório");
		}
		if (processador.getSmp() == null || processador.getSmp() == 0) {
			p.setSmp(0);
		}
		if (processador.getDadosProcessador() == null) {
			throw new DbException("Dados do Processador não foi informado");
		}
		
		return p;
	}
}
