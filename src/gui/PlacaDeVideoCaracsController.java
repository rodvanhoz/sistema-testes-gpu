package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.entities.services.CaracteristicasGraficasService;
import models.entities.services.ProcessadorGraficoService;
import models.entities.services.RenderConfigService;
import models.entities.tables.CaracteristicasGraficas;
import models.entities.tables.ProcessadorGrafico;
import models.entities.tables.RenderConfig;

public class PlacaDeVideoCaracsController implements Initializable {

	private ProcessadorGraficoService procGraficoService = new ProcessadorGraficoService();
	private CaracteristicasGraficasService caracGraficasService = new CaracteristicasGraficasService();
	private RenderConfigService renderConfigService = new RenderConfigService();
	
	private CaracteristicasGraficas caracGraficasSelected;
	private ProcessadorGrafico procGraficoSelected;
	private RenderConfig renderConfigSelected;
	
	private char newOrEdit;
	
	// Caracteristicas Graficas
	
	@FXML
	protected TextField txtDirectX;

	@FXML
	protected TextField txtOpenGL;

	@FXML
	protected TextField txtOpenCL;

	@FXML
	protected TextField txtVulkan;

	@FXML
	protected TextField txtCudaCores;

	@FXML
	protected TextField txtShaderModel;
	
	@FXML
	private Button btSalvarCaracGrafica;
	
	@FXML
	private Button btCancelarCaracGrafica;
	
	
	// Render Config
	
	@FXML
	protected TextField txtShadingUnits;

	@FXML
	protected TextField txtTMUs;

	@FXML
	protected TextField txtROPs;

	@FXML
	protected TextField txtSmCount;

	@FXML
	protected TextField txtL1Cache;

	@FXML
	protected TextField txtL2Cache;

	@FXML
	protected TextField txtTensorCores;

	@FXML
	protected TextField txtRtCores;

	@FXML
	private Button btSalvarRenderConfig;
	
	@FXML
	private Button btCancelarRenderConfig;
	

	// Processador Gráfico
	
	@FXML
	protected TextField txtNomeGpu;

	@FXML
	protected TextField txtVariantGpu;

	@FXML
	protected TextField txtArquitetura;

	@FXML
	protected TextField txtFundicao;

	@FXML
	protected TextField txtLitografia;

	@FXML
	protected TextField txtNroTransistores;

	@FXML
	protected TextField txtTamanhoChip;
	
	@FXML
	private Button btSalvarProcessadorGrafico;
	
	@FXML
	private Button btCancelarProcessadorGrafico;
	
	@Override
	public void initialize(URL uri, ResourceBundle resources) {
		
		// render config
		Constraints.setTextFieldInteger(txtShadingUnits);
		Constraints.setTextFieldInteger(txtTMUs);
		Constraints.setTextFieldInteger(txtROPs);
		Constraints.setTextFieldInteger(txtSmCount);
		Constraints.setTextFieldInteger(txtL1Cache);
		Constraints.setTextFieldInteger(txtL2Cache);
		Constraints.setTextFieldInteger(txtTensorCores);
		Constraints.setTextFieldInteger(txtRtCores);
		
		// Processador Gráfico
		Constraints.setTextFieldInteger(txtLitografia);
		Constraints.setTextFieldDouble(txtNroTransistores);
		Constraints.setTextFieldInteger(txtTamanhoChip);

	}
	
	@FXML
	public void onBtCancelarCaracGraficaAction() {
		Stage stage = (Stage) btCancelarCaracGrafica.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onBtCancelarProcessadorGraficoAction() {
		Stage stage = (Stage) btCancelarProcessadorGrafico.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onBtCancelarRenderConfigAction() {
		Stage stage = (Stage) btCancelarRenderConfig.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onBtSalvarCaracGraficaAction() {
	
		if (caracGraficasSelected != null) {
			throw new IllegalStateException("caracGraficasSelected está null");
		}
		
		CaracteristicasGraficas caracGraficas = new CaracteristicasGraficas(null, 
				txtDirectX.getText(), 
				txtOpenGL.getText(), 
				txtOpenCL.getText(), 
				txtVulkan.getText(), 
				txtCudaCores.getText(), 
				txtShaderModel.getText());
		
		if (this.newOrEdit == 'E') {
			caracGraficas.setIdCaracGrafica(caracGraficasSelected.getIdCaracGrafica());
			System.out.println(caracGraficasSelected);
			caracGraficasService.atualizar(caracGraficas);
		}
		else if (this.newOrEdit == 'N' || this.newOrEdit == 'C') {
			System.out.println(caracGraficasSelected);
			caracGraficasService.inserir(caracGraficas);
		}
		else {
			throw new IllegalStateException("Variavel newOrEdit está null");
		}
		

		Stage stage = (Stage) btSalvarCaracGrafica.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void onBtSalvarRenderConfigAction() {

		if (renderConfigSelected != null) {
			throw new IllegalStateException("renderConfigSelected está null");
		}

		RenderConfig renderConfig = new RenderConfig(null, 
				Integer.parseInt(txtShadingUnits.getText()), 
				Integer.parseInt(txtTMUs.getText()), 
				Integer.parseInt(txtROPs.getText()), 
				Integer.parseInt(txtSmCount.getText()), 
				Integer.parseInt((txtL1Cache.getText() == "" || txtL1Cache.getText() == null) ? "0" : txtL1Cache.getText()), 
				Integer.parseInt((txtL2Cache.getText() == "" || txtL2Cache.getText() == null) ? "0" : txtL2Cache.getText()), 
				Integer.parseInt((txtTensorCores.getText() == "" || txtTensorCores.getText() == null) ? "0" : txtTensorCores.getText()), 
				Integer.parseInt((txtRtCores.getText() == "" || txtRtCores.getText() == null) ? "0" : txtRtCores.getText()));
		
		if (this.getNewOrEdit() == 'E') {
			renderConfig.setIdRenderConfig(renderConfigSelected.getIdRenderConfig());
			System.out.println(renderConfigSelected);
			renderConfigService.atualizar(renderConfig);
		}
		else if (this.getNewOrEdit() == 'N' || this.newOrEdit == 'E') {
			System.out.println(renderConfigSelected);
			renderConfigService.inserir(renderConfig);
		}
		else {
			throw new IllegalStateException("Variavel newOrEdit está null");
		}

		Stage stage = (Stage) btSalvarRenderConfig.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void onBtSalvarProcessadorGraficoAction() {
		
		if (procGraficoSelected != null) {
			throw new IllegalStateException("procGraficoSelected está null");
		}
		
		ProcessadorGrafico procGrafico = new ProcessadorGrafico(null, 
				txtNomeGpu.getText(), 
				txtVariantGpu.getText(), 
				txtArquitetura.getText(), 
				txtFundicao.getText(), 
				Integer.parseInt(txtLitografia.getText()), 
				Double.parseDouble(txtNroTransistores.getText()), 
				Integer.parseInt(txtTamanhoChip.getText()));
		
		if (this.getNewOrEdit() == 'E') {
			procGrafico.setIdProcGrafico(procGraficoSelected.getIdProcGrafico());
			System.out.println(procGraficoSelected);
			procGraficoService.atualizar(procGrafico);
		}
		else if (this.getNewOrEdit() == 'N' || this.newOrEdit == 'E') {
			System.out.println(procGraficoSelected);
			procGraficoService.inserir(procGrafico);
		}
		else {
			throw new IllegalStateException("Variavel newOrEdit está null");
		}
		
		Stage stage = (Stage) btSalvarProcessadorGrafico.getScene().getWindow();
		stage.close();
	}

	public ProcessadorGraficoService getProcGraficoService() {
		return procGraficoService;
	}

	public void setProcGraficoService(ProcessadorGraficoService procGraficoService) {
		this.procGraficoService = procGraficoService;
	}

	public CaracteristicasGraficasService getCaracGraficasService() {
		return caracGraficasService;
	}

	public void setCaracGraficasService(CaracteristicasGraficasService caracGraficasService) {
		this.caracGraficasService = caracGraficasService;
	}

	public RenderConfigService getRenderConfigService() {
		return renderConfigService;
	}

	public void setRenderConfigService(RenderConfigService renderConfigService) {
		this.renderConfigService = renderConfigService;
	}

	public CaracteristicasGraficas getCaracGraficasSelected() {
		return caracGraficasSelected;
	}

	public void setCaracGraficasSelected(CaracteristicasGraficas caracGraficasSelected) {
		this.caracGraficasSelected = caracGraficasSelected;
	}

	public ProcessadorGrafico getProcGraficoSelected() {
		return procGraficoSelected;
	}

	public void setProcGraficoSelected(ProcessadorGrafico procGraficoSelected) {
		this.procGraficoSelected = procGraficoSelected;
	}

	public RenderConfig getRenderConfigSelected() {
		return renderConfigSelected;
	}

	public void setRenderConfigSelected(RenderConfig renderConfigSelected) {
		this.renderConfigSelected = renderConfigSelected;
	}

	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}
}
