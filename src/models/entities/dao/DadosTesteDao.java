package models.entities.dao;

import java.util.List;

import models.entities.views.DadosTeste;

public interface DadosTesteDao {

	List<DadosTeste> findAll();
	List<DadosTeste> findByGpu();
	List<DadosTeste> findByJogo();
	List<DadosTeste> findByProcessador();
	List<DadosTeste> findByTester();
	
}
