package models.entities.dao;

import db.DB;
import models.entities.dao.impl.DadosTesteDaoJDBC;
import models.entities.dao.impl.PlacaDeVideoDaoJDBC;
import models.entities.dao.impl.ProcessadorDaoJDBC;

public class DaoFactory {

	public static DadosTesteDao createDadosTesteDao() {
		return new DadosTesteDaoJDBC(DB.getConnection());
	}
	
	public static ProcessadorDao createProcessadorDao() {
		return new ProcessadorDaoJDBC(DB.getConnection());
	}
	
	public static PlacaDeVideoDao createPlacaDeVideoDao() {
		return new PlacaDeVideoDaoJDBC(DB.getConnection());
	}
}
