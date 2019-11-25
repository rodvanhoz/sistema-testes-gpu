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
	
	public void inserir(Jogos jogo) {
		dao.inserir(jogo);
	}
}
