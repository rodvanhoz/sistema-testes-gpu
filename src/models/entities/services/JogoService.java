package models.entities.services;

import java.util.ArrayList;
import java.util.List;

import db.DbException;
import models.entities.dao.DaoFactory;
import models.entities.dao.JogoDao;
import models.entities.tables.Jogos;

public class JogoService {

	private JogoDao dao = DaoFactory.createJogoDao();
	
	public List<Jogos> findAll() {
		return dao.findAll();
	}
	
	public Jogos findById(int idJogo) {
		return dao.findById(idJogo);
	}
	
	public List<Jogos> findByNomeJogo(String nomeJogo) {
		return dao.findByNomeJogo(nomeJogo);
	}
	
	public void inserir(Jogos jogo) {
		checaCamposJogos(jogo);
		dao.inserir(jogo);
	}
	
	public void atualizar(Jogos jogo) {
		if (jogo.getIdJogo() == null || jogo.getIdJogo() == 0) {
			throw new DbException("ERRO: IdJogo não informado para o Update");
		}
		checaCamposJogos(jogo);
		dao.atualizar(jogo);
	}
	
	public void remover(Jogos jogo) {
		dao.remover(jogo);
	}
	
	private void checaCamposJogos(Jogos jogo) {
		if (jogo.getNomeJogo() == "" || jogo.getNomeJogo() == null) {
			throw new DbException("Nome do Jogo é obrigatório");
		}
		if (jogo.getDtLancto() == null) {
			throw new DbException("Data de Lancto. é obrigatório");
		}
		
		List<Jogos> jogos = findByNomeJogo(jogo.getNomeJogo());
		
		for (Jogos j : jogos) {
			if (jogo.getNomeJogo().toLowerCase() == j.getNomeJogo().toLowerCase() && jogo.getDtLancto() == j.getDtLancto()) {
				throw new DbException("Jogo já cadastrado!");
			}
		}
	}
}
