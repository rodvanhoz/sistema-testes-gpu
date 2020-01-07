package models.entities.services;

import java.util.List;

import db.DbException;
import models.entities.dao.CaracteristicasGraficasDao;
import models.entities.dao.DaoFactory;
import models.entities.tables.CaracteristicasGraficas;

public class CaracteristicasGraficasService {
	
	private CaracteristicasGraficasDao dao = DaoFactory.createCaracteristicasGraficasDao();
	
	public List<CaracteristicasGraficas> findAll() {
		return dao.findAll();
	}
	
	public CaracteristicasGraficas findById(int idCaracGrafica) {
		return dao.findById(idCaracGrafica);
	}
	
	public List<CaracteristicasGraficas> findByDirectX(String directX) {
		return dao.findByDirectX(directX);
	}
	
	public List<CaracteristicasGraficas> findByOpenGL(String openGL) {
		return dao.findByOpenGL(openGL);
	}

	public List<CaracteristicasGraficas> findByOpenCL(String openCL) {
		return dao.findByOpenCL(openCL);
	}
	
	public List<CaracteristicasGraficas> findByVulkan(String vulkan) {
		return dao.findByVulkan(vulkan);
	}
	
	public List<CaracteristicasGraficas> findByCuda(String cuda) {
		return dao.findByCuda(cuda);
	}
	
	public List<CaracteristicasGraficas> findByShaderModel(String shaderModel) {
		return dao.findByShaderModel(shaderModel);
	}
	
	public void inserir(CaracteristicasGraficas caracGrafica) {
		checaCamposCaracteristicasGraficas(caracGrafica);
		dao.inserir(caracGrafica);
	}
	
	public void atualizar(CaracteristicasGraficas caracGrafica) {
		if (caracGrafica.getIdCaracGrafica() == null || caracGrafica.getIdCaracGrafica() == 0) {
			throw new DbException("ERRO: IdCaracGrafica não informado para o update");
		}
		
		checaCamposCaracteristicasGraficas(caracGrafica);
		dao.atualizar(caracGrafica);
	}
	
	public void remover(CaracteristicasGraficas caracGrafica) {
		dao.remover(caracGrafica);
	}
	
	private void checaCamposCaracteristicasGraficas(CaracteristicasGraficas caracs) {
		if (caracs.getDirectX() == null || caracs.getDirectX().compareTo("") == 0) {
			throw new DbException("Versão do DirectX é obrigatório");
		}
		if (caracs.getOpenCL() == null || caracs.getOpenCL().compareTo("") == 0) {
			throw new DbException("Versão do OpenCL é obrigatório");
		}
		if (caracs.getOpenGL() == null || caracs.getOpenGL().compareTo("") == 0) {
			throw new DbException("Versão do OpenGL é obrigatório");
		}
		if (caracs.getShaderModel() == null || caracs.getShaderModel().compareTo("") == 0) {
			throw new DbException("Versão do Shader Model é obrigatório");
		}
	}
}
