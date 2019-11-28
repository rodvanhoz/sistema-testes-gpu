package models.entities.dao;

import db.DB;
import models.entities.dao.impl.ConfiguracoesDaoJDBC;
import models.entities.dao.impl.ConfiguracoesJogosDaoJDBC;
import models.entities.dao.impl.DadosTesteDaoJDBC;
import models.entities.dao.impl.JogoDaoJDBC;
import models.entities.dao.impl.PlacaDeVideoDaoJDBC;
import models.entities.dao.impl.ProcessadorDaoJDBC;
import models.entities.tables.Configuracoes;

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
	
	public static JogoDao createJogoDao() {
		return new JogoDaoJDBC(DB.getConnection());
	}
	
	public static ConfiguracoesDao createConfiguracoesDao() {
		return new ConfiguracoesDaoJDBC(DB.getConnection());
	}
	
	public static ConfiguracoesJogosDao createConfiguracoesJogosDao() {
		return new ConfiguracoesJogosDaoJDBC(DB.getConnection());
	}
}
