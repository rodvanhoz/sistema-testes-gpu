package models.entities.services;

import java.util.List;

import models.entities.dao.DadosTesteDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.Gpus;
import models.entities.tables.Jogos;
import models.entities.tables.TestesGpu;
import models.entities.views.DadosTeste;
import models.entities.views.Processador;

public class DadosTesteService {

	private DadosTesteDao dao = DaoFactory.createDadosTesteDao();
	
	public List<DadosTeste> findAll() {
		return dao.findAll();
	}
	
	public List<DadosTeste> findByGpu(Gpus gpu) {
		return dao.findByGpu(gpu);
	}
	
	public List<DadosTeste> findByJogo(Jogos jogo) {
		return dao.findByJogo(jogo);
	}
	
	public List<DadosTeste> findByProcessador(Processador processador) {
		return dao.findByProcessador(processador);
	}
	
	public List<DadosTeste> findByTester(String tester) {
		return dao.findByTester(tester);
	}
	
	public DadosTeste findById(int idTesteGpu) {
		return dao.findById(idTesteGpu);
	}
	
	public TestesGpu findByIdTesteGpu(int idTesteGpu) {
		return dao.findByIdTesteGpu(idTesteGpu);
	}
	
	public void inserir(TestesGpu testeGpu) {
		dao.inserir(testeGpu);
	}
	
	public void atualizar(TestesGpu testeGpu) {
		dao.atualizar(testeGpu);
	}
	
	public void remover(TestesGpu testeGpu) {
		dao.remover(testeGpu);
	}
}
