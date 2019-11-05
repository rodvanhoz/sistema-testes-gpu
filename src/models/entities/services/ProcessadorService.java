package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.ProcessadorDao;
import models.entities.views.Processador;

public class ProcessadorService {
	
	private ProcessadorDao dao = DaoFactory.createProcessadorDao();
	
	public List<Processador> findAll() {
		return dao.findAll();
	}

}
