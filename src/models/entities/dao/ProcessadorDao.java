package models.entities.dao;

import java.util.List;

import models.entities.views.Processador;

public interface ProcessadorDao {
	
	List<Processador> findAll();
	List<Processador> findByModelo();
	List<Processador> findByFabricante();
	List<Processador> findByCodename();
	List<Processador> findByGraficoIntegrado();

}
