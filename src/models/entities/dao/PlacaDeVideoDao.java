package models.entities.dao;

import java.util.List;

import models.entities.views.PlacaDeVideo;

public interface PlacaDeVideoDao {

	List<PlacaDeVideo> findAll();
	List<PlacaDeVideo> findByModeloGpu();
	List<PlacaDeVideo> findByArquitetura();
	List<PlacaDeVideo> findByTpMemoria();
	List<PlacaDeVideo> findByFabricante();
	
}
