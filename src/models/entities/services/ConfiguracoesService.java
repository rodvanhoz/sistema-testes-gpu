package models.entities.services;

import java.util.List;

import models.entities.dao.ConfiguracoesDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.Configuracoes;

public class ConfiguracoesService {
	private ConfiguracoesDao dao = DaoFactory.createConfiguracoesDao();
	
	public List<Configuracoes> findAll() {
		return dao.findAll();
	}
}
