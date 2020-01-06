package models.entities.services;

import java.util.List;

import db.DbException;
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
		dao.inserir(checaCamposGpu(gpu));
	}
	
	public void atualizar(Gpus gpu) {
		if (gpu.getIdGpu() == null || gpu.getIdGpu() == 0) {
			throw new DbException("ERRO: IdGpu não foi informado para o update.");
		}
		
		dao.atualizar(checaCamposGpu(gpu));
	}
	
	public void remover(Gpus gpu) {
		dao.remover(gpu);
	}
	
	private Gpus checaCamposGpu(Gpus gpu) {
		
		Gpus g = gpu;
		
		if (gpu.getNomeFabricante() == "" || gpu.getNomeFabricante() == null) {
			throw new DbException("Nome do Fabricante é obrigatório");
		}
		if (gpu.getNomeModelo() == "" || gpu.getNomeModelo() == null) {
			throw new DbException("Descrição do modelo é obrigatório");
		}
		if (gpu.getGpuClock() == null || gpu.getGpuClock() == 0) {
			throw new DbException("Gpu clock é obrigatório");
		}
		if (gpu.getBoostClock() == null || gpu.getBoostClock() == 0) {
			g.setBoostClock(gpu.getBoostClock());
		}
		if (gpu.getMemClock() == null || gpu.getMemClock() == 0) {
			throw new DbException("Memory Clock é obrigatório");
		}
		if (gpu.getMemClockEfetivo() == null || gpu.getMemClockEfetivo() == 0) {
			g.setMemClockEfetivo(gpu.getMemClock());
		}
		if (gpu.getTamMemoriaKB() == null) {
			throw new DbException("Tamanho da VRam é obrigatório (Caso for Integrada informar 0");
		}
		if (gpu.getTamBanda() == null) {
			throw new DbException("Tamanho da Banda de memória é obrigatório (Caso for integrada informar 0)");
		}
		if (gpu.getTdp() == null) {
			throw new DbException("Quantidade de TDP é obrigatório (Caso for integrada informar 0)");
		}
		if (gpu.getTpMemoria() == null) {
			throw new DbException("Tipo de memória é obrigatório");
		}
		if (gpu.getDtLancto() == null) {
			throw new DbException("Data de Lancto. é obrigatório");
		}
		if (gpu.getCaracteristicasGraficas() == null) {
			throw new DbException("Características Gráficas não foi informado");
		}
		if (gpu.getRenderConfig() == null) {
			throw new DbException("Render Config não foi informado");
		}
		if (gpu.getProcessadorGrafico() == null) {
			throw new DbException("Processador Gráfico não foi informado");
		}
		
		return g;
	}
}
