package models.entities.services;

import java.util.List;

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
	
	public void inserir(Jogos jogo) {
		dao.inserir(jogo);
	}
	
	public void atualizar(Jogos jogo) {
		dao.atualizar(jogo);
	}
	
	public void remover(Jogos jogo) {
		dao.remover(jogo);
	}
}
