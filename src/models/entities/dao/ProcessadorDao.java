package models.entities.dao;

import java.util.List;

import models.entities.tables.Gpus;
import models.entities.tables.Processadores;
import models.entities.views.Processador;

public interface ProcessadorDao {
	
	List<Processador> findAll();
	List<Processador> findByModelo(String modelo);
	List<Processador> findByFabricante(String fabricante);
	List<Processador> findByCodename(String codename);
	List<Processador> findByGraficoIntegrado(Gpus graficoIntegrado);
	Processador findById(int idProcessador);
	Processadores findByIdProcessadores(int idProcessador);
	void inserir(Processadores processador);
	void atualizar(Processadores processador);
	void remover(Processadores processador);

}
