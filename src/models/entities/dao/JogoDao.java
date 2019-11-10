package models.entities.dao;

import java.util.Date;
import java.util.List;

import models.entities.tables.Jogos;

public interface JogoDao {
	
	List<Jogos> findAll();
	List<Jogos> findByDtLancto(Date dtLancto);
	Jogos findById(int idJogo);
	void inserir(Jogos jogo);
	void atualizar(Jogos jogo);
	void remover(Jogos jogo);

}
