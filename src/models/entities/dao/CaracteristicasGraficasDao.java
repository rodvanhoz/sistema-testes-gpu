package models.entities.dao;

import java.util.List;

import models.entities.tables.CaracteristicasGraficas;

public interface CaracteristicasGraficasDao {
	
	List<CaracteristicasGraficas> findAll();
	CaracteristicasGraficas findById(int idCaracGrafica);
	List<CaracteristicasGraficas> findByDirectX(String directX);
	List<CaracteristicasGraficas> findByOpenGL(String openGL);
	List<CaracteristicasGraficas> findByOpenCL(String openCL);
	List<CaracteristicasGraficas> findByVulkan(String vulkan);
	List<CaracteristicasGraficas> findByCuda(String cuda);
	List<CaracteristicasGraficas> findByShaderModel(String shaderModel);
	void inserir(CaracteristicasGraficas caracGrafica);
	void atualizar(CaracteristicasGraficas caracGrafica);
	void remover(CaracteristicasGraficas caracGrafica);

}
