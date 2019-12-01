package models.entities.dao;

import java.util.List;

import models.entities.tables.RenderConfig;

public interface RenderConfigDao {

	List<RenderConfig> findAll();
	RenderConfig findById(int idRenderConfig);
	void inserir(RenderConfig renderConfig);
	void atualizar(RenderConfig renderConfig);
	void remover(RenderConfig renderConfig);
}
