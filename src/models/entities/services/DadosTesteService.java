package models.entities.services;

import java.util.List;

import models.entities.dao.DadosTesteDao;
import models.entities.dao.DaoFactory;
import models.entities.views.DadosTeste;

public class DadosTesteService {

	private DadosTesteDao dao = DaoFactory.createDadosTesteDao();
	
	public List<DadosTeste> findAll() {
		return dao.findAll();
	}
}
