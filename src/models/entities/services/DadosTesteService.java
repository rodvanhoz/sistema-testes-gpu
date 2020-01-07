package models.entities.services;

import java.util.List;

import db.DbException;
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
		dao.inserir(checaCamposTestesGpu(testeGpu));
	}
	
	public void atualizar(TestesGpu testeGpu) {
		dao.atualizar(checaCamposTestesGpu(testeGpu));
	}
	
	public void remover(TestesGpu testeGpu) {
		dao.remover(testeGpu);
	}
	
	private TestesGpu checaCamposTestesGpu(TestesGpu teste) {
		TestesGpu t = teste;
		
		if (teste.getConfiguracaoJogo() == null) {
			throw new DbException("Configuração do Jogo não foi informado");
		}
		if (teste.getGpu() == null) {
			throw new DbException("Gpu não foi informada");
		}
		if (teste.getProcessador() == null) {
			throw new DbException("Processador não foi informado");
		}
		if (teste.getNomeTester().compareTo("") == 0 || teste.getNomeTester() == null) {
			throw new DbException("Nome do Tester é obrigatório");
		}
		if (teste.getDtTeste() == null) {
			throw new DbException("Data do Teste é obrigatório");
		}
		if (teste.getMinFps() == null) {
			t.setMinFps(0.0);
		}
		if (teste.getAvgFps() < teste.getMinFps()) {
			throw new DbException("FpsMim não pode ser maior que FpsAvg");
		}
		
		return t;
	}
}
