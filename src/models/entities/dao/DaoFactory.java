package models.entities.dao;

import db.DB;
import models.entities.dao.impl.DadosTesteDaoJDBC;

public class DaoFactory {

	public static DadosTesteDao createDadosTesteDao() {
		return new DadosTesteDaoJDBC(DB.getConnection());
	}
}
