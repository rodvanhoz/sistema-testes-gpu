package models.entities.services;

import java.util.List;

import models.entities.dao.DaoFactory;
import models.entities.dao.PlacaDeVideoDao;
import models.entities.tables.Gpus;
import models.entities.views.PlacaDeVideo;

public class PlacaDeVideoService {

	private PlacaDeVideoDao dao = DaoFactory.createPlacaDeVideoDao();
	
	public List<PlacaDeVideo> findAll() {
		return dao.findAll();
	}
	
	public List<PlacaDeVideo> findByModeloGpu(String nomeModelo) {
		return dao.findByModeloGpu(nomeModelo);
	}
	
	public List<PlacaDeVideo> findByArquitetura(String arquitetura) {
		return dao.findByArquitetura(arquitetura);
	}
	
	public List<PlacaDeVideo> findByTpMemoria(String tpMemoria) {
		return dao.findByTpMemoria(tpMemoria);
	}
	
	public List<PlacaDeVideo> findByFabricante(String nomeFabricante) {
		return dao.findByFabricante(nomeFabricante);
	}
	
	public List<PlacaDeVideo> findByBusInterface(String BusInterface) {
		return dao.findByBusInterface(BusInterface);
	}
	
	public PlacaDeVideo findById(int idGpu) {
		return dao.findById(idGpu);
	}
	
	public Gpus findByIdGpu(int idGpu) {
		return dao.findByIdGpu(idGpu);
	}
	
	public void inserir(Gpus gpu) {
		dao.inserir(gpu);
	}
	
	public void atualizar(Gpus gpu) {
		dao.atualizar(gpu);
	}
	
	public void remover(Gpus gpu) {
		dao.remover(gpu);
	}
}
