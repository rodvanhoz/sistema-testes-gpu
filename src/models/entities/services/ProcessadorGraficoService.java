package models.entities.services;

import java.util.List;

import db.DbException;
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
		dao.inserir(checaCamposProcessadorGrafico(processadorGrafico));
	}
	
	public void atualizar(ProcessadorGrafico processadorGrafico) {
		if (processadorGrafico.getIdProcGrafico() == null || processadorGrafico.getIdProcGrafico() == 0) {
			throw new DbException("ERRO: IdProcessadorGrafico não foi informado para o update");
		}
		
		dao.atualizar(checaCamposProcessadorGrafico(processadorGrafico));
	}
	
	public void remover(ProcessadorGrafico processadorGrafico) {
		dao.remover(processadorGrafico);
	}
	
	private ProcessadorGrafico checaCamposProcessadorGrafico(ProcessadorGrafico proc) {
		
		ProcessadorGrafico p = proc;
		
		if (proc.getNomeGpu() == null || proc.getNomeGpu() == "") {
			throw new DbException("Nome do Processador Gráfico é obrigatório");
		}
		if (proc.getVariantGpu() == null || proc.getVariantGpu() == "") {
			throw new DbException("Nome da Variant GPU é obrigatório");
		}
		if (proc.getFundicao() == null || proc.getFundicao() == "") {
			throw new DbException("Fundição é obrigatório");
		}
		if (proc.getArquitetura() == null || proc.getArquitetura() == "") {
			throw new DbException("Arquitetura é obrigatório");
		}
		if (proc.getNnProcessador() == null || proc.getMmProcessador() == 0) {
			throw new DbException("Litografia é obrigatório");
		}
		if (proc.getNroTransistors() == null) {
			p.setNroTransistors(0.0);
		}
		if (proc.getMmProcessador() == null) {
			p.setMmProcessador(0);
		}
		
		return p;
	}
}


