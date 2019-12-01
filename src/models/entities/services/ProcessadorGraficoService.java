package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.ProcessadorGraficoDao;
import models.entities.tables.ProcessadorGrafico;

public class ProcessadorGraficoService {

	private ProcessadorGraficoDao dao = DaoFactory.createProcessadorGraficoDao();

	public List<ProcessadorGrafico> findAll() {
		return dao.findAll();
	}
	
	public ProcessadorGrafico findById(int idProcessadorGrafico) {
		return dao.findById(idProcessadorGrafico);
	}
	
	public List<ProcessadorGrafico> findByArquitetura(String arquitetura) {
		return dao.findByArquitetura(arquitetura);
	}
	
	public List<ProcessadorGrafico> findByFundicao(String fundicao) {
		return dao.findByFundicao(fundicao);
	}
	
	public List<ProcessadorGrafico> findByNomeGPU(String nomeGPU) {
		return dao.findByNomeGPU(nomeGPU);
	}
	
	public void inserir(ProcessadorGrafico processadorGrafico) {
		dao.inserir(processadorGrafico);
	}
	
	public void atualizar(ProcessadorGrafico processadorGrafico) {
		dao.atualizar(processadorGrafico);
	}
	
	public void remover(ProcessadorGrafico processadorGrafico) {
		dao.remover(processadorGrafico);
	}
}


