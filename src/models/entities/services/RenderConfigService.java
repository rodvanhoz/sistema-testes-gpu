package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.RenderConfigDao;
import models.entities.tables.RenderConfig;

public class RenderConfigService {
	
	private RenderConfigDao dao = DaoFactory.createRenderConfigDao();
	
	public List<RenderConfig> findAll() {
		return dao.findAll();
	}
	
	public RenderConfig findById(int idRenderConfig) {
		return dao.findById(idRenderConfig);
	}
	
	public void inserir(RenderConfig renderConfig) {
		dao.inserir(renderConfig);
	}
	
	public void atualizar(RenderConfig renderConfig) {
		dao.atualizar(renderConfig);
	}
	
	public void remover(RenderConfig renderConfig) {
		dao.remover(renderConfig);
	}

}
