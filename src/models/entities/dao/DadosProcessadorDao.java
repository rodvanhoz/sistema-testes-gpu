package models.entities.dao;

import java.util.List;

import models.entities.tables.DadosProcessador;

public interface DadosProcessadorDao {
	
	List<DadosProcessador> findAll();
	DadosProcessador findById(int idDadosProcessador);
	void inserir(DadosProcessador dadosProcessador);
	void atualizar(DadosProcessador dadosProcessador);
	void remover(DadosProcessador dadosProcessador);

}
