package models.entities.dao;

import db.DB;
import models.entities.dao.impl.CaracteristicasGraficasDaoJDBC;
import models.entities.dao.impl.ConfiguracoesDaoJDBC;
import models.entities.dao.impl.ConfiguracoesJogosDaoJDBC;
import models.entities.dao.impl.DadosTesteDaoJDBC;
import models.entities.dao.impl.JogoDaoJDBC;
import models.entities.dao.impl.PlacaDeVideoDaoJDBC;
import models.entities.dao.impl.ProcessadorDaoJDBC;
import models.entities.dao.impl.ProcessadorGraficoDaoJDBC;
import models.entities.dao.impl.RenderConfigDaoJDBC;

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
	
	public static ProcessadorGraficoDao createProcessadorGraficoDao() {
		return new ProcessadorGraficoDaoJDBC(DB.getConnection());
	}
	
	public static CaracteristicasGraficasDao createCaracteristicasGraficasDao() {
		return new CaracteristicasGraficasDaoJDBC(DB.getConnection());
	}
	
	public static RenderConfigDao createRenderConfigDao() {
		return new RenderConfigDaoJDBC(DB.getConnection());
	}
}
