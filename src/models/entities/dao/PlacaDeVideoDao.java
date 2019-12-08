package models.entities.dao;

import java.util.List;

import models.entities.tables.Gpus;
import models.entities.views.PlacaDeVideo;

public interface PlacaDeVideoDao {

	List<PlacaDeVideo> findAll();
	List<PlacaDeVideo> findByModeloGpu(String nomeModelo);
	List<PlacaDeVideo> findByArquitetura(String arquitetura);
	List<PlacaDeVideo> findByTpMemoria(String tpMemoria);
	List<PlacaDeVideo> findByFabricante(String nomeFabricante);
	List<PlacaDeVideo> findByBusInterface(String BusInterface);
	PlacaDeVideo findById(int idGpu);
	Gpus findByIdGpu(int idGpu);
	void inserir(Gpus gpu);
	void atualizar(Gpus gpu);
	void remover(Gpus gpu);
	
}
