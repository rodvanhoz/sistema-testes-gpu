package models.entities.tables;

import java.io.Serializable;

public class CaracteristicasGraficas implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idCaracGrafica;
	private String directX;
	private String openGL;
	private String openCL;
	private String vulkan;
	private String cuda;
	private String shaderModel;
	
	public CaracteristicasGraficas(Integer idCaracGrafica, String directX, String openGL, String openCL, String vulkan,
			String cuda, String shaderModel) {
		this.idCaracGrafica = idCaracGrafica;
		this.directX = directX;
		this.openGL = openGL;
		this.openCL = openCL;
		this.vulkan = vulkan;
		this.cuda = cuda;
		this.shaderModel = shaderModel;
	}

	public Integer getIdCaracGrafica() {
		return idCaracGrafica;
	}

	public void setIdCaracGrafica(Integer idCaracGrafica) {
		this.idCaracGrafica = idCaracGrafica;
	}

	public String getDirectX() {
		return directX;
	}

	public void setDirectX(String directX) {
		this.directX = directX;
	}

	public String getOpenGL() {
		return openGL;
	}

	public void setOpenGL(String openGL) {
		this.openGL = openGL;
	}

	public String getOpenCL() {
		return openCL;
	}

	public void setOpenCL(String openCL) {
		this.openCL = openCL;
	}

	public String getVulkan() {
		return vulkan;
	}

	public void setVulkan(String vulkan) {
		this.vulkan = vulkan;
	}

	public String getCuda() {
		return cuda;
	}

	public void setCuda(String cuda) {
		this.cuda = cuda;
	}

	public String getShaderModel() {
		return shaderModel;
	}

	public void setShaderModel(String shaderModel) {
		this.shaderModel = shaderModel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	@Override
	public String toString() {
		return idCaracGrafica + ": Dx " + directX + " / openGL " + openGL + " / vulkan " + vulkan + " / cuda " + cuda
				+ " / shaderModel " + shaderModel;
	}
	
}
