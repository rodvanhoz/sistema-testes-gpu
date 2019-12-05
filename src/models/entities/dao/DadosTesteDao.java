package models.entities.dao;

import java.util.List;

import models.entities.tables.Gpus;
import models.entities.tables.Jogos;
import models.entities.tables.TestesGpu;
import models.entities.views.DadosTeste;
import models.entities.views.Processador;

public interface DadosTesteDao {

	List<DadosTeste> findAll();
	List<DadosTeste> findByGpu(Gpus gpu);
	List<DadosTeste> findByJogo(Jogos jogo);
	List<DadosTeste> findByProcessador(Processador processador);
	List<DadosTeste> findByTester(String tester);
	DadosTeste findById(int idTesteGpu);
	TestesGpu findByIdTesteGpu(int idTesteGpu);
	void inserir(TestesGpu testeGpu);
	void atualizar(TestesGpu testeGpu);
	void remover(TestesGpu testeGpu);
	
}
