package models.entities.services;

import java.util.List;

import db.DbException;
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
		dao.inserir(checaCamposRenderConfig(renderConfig));
	}
	
	public void atualizar(RenderConfig renderConfig) {
		if (renderConfig.getIdRenderConfig() == null || renderConfig.getIdRenderConfig() == 0) {
			throw new DbException("ERRO: IdRenderConfig nao informado para o update");
		}
		dao.atualizar(checaCamposRenderConfig(renderConfig));
	}
	
	public void remover(RenderConfig renderConfig) {
		dao.remover(renderConfig);
	}
	
	private RenderConfig checaCamposRenderConfig(RenderConfig render) {
		
		RenderConfig rc = render;
		
		if (render.getL1Cache() == null) {
			rc.setL1Cache(0);
		}
		if (render.getL2Cache() == null) {
			rc.setL2Cache(0);
		}
		if (render.getShadingUnits() == null || render.getShadingUnits() == 0) {
			throw new DbException("Shading Units é obrigatório");
		}
		if (render.getTmus() == null || render.getTmus() == 0) {
			throw new DbException("TMUs é obrigatório");
		}
		if (render.getRops() == null || render.getRops() == 0) {
			throw new DbException("ROPs é obrigatório");
		}
		if (render.getSmCount() == null) {
			rc.setSmCount(0);
		}
		if (render.getTensorCores() == null) {
			rc.setTensorCores(0);
		}
		if (render.getRtCores() == null) {
			rc.setRtCores(0);
		}
		
		return rc;
	}

}
