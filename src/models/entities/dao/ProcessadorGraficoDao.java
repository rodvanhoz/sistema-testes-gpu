package models.entities.dao;

import java.util.List;

import models.entities.tables.ProcessadorGrafico;

public interface ProcessadorGraficoDao {
	
	List<ProcessadorGrafico> findAll();
	ProcessadorGrafico findById(int idProcessadorGrafico);
	List<ProcessadorGrafico> findByArquitetura(String arquitetura);
	List<ProcessadorGrafico> findByFundicao(String fundicao);
	List<ProcessadorGrafico> findByNomeGPU(String nomeGPU);
	void inserir(ProcessadorGrafico processadorGrafico);
	void atualizar(ProcessadorGrafico processadorGrafico);
	void remover(ProcessadorGrafico processadorGrafico);
}
