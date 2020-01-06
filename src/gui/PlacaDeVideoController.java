package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.ComboBoxAutoComplete;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.CaracteristicasGraficasService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorGraficoService;
import models.entities.services.RenderConfigService;
import models.entities.tables.CaracteristicasGraficas;
import models.entities.tables.Gpus;
import models.entities.tables.ProcessadorGrafico;
import models.entities.tables.RenderConfig;
import models.entities.views.PlacaDeVideo;

public class PlacaDeVideoController implements Initializable {

	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private char newOrEdit;
	
	private ProcessadorGraficoService procGraficoService = new ProcessadorGraficoService();
	private CaracteristicasGraficasService caracGraficasService = new CaracteristicasGraficasService();
	private RenderConfigService renderConfigService = new RenderConfigService();
	private PlacaDeVideoService service = new PlacaDeVideoService();
	
	private ObservableList<ProcessadorGrafico> listaProcGrafico = FXCollections.observableArrayList(procGraficoService.findAll());
	private ObservableList<CaracteristicasGraficas> listaCaracGraficas = FXCollections.observableArrayList(caracGraficasService.findAll());
	private ObservableList<RenderConfig> listaRenderConfig = FXCollections.observableArrayList(renderConfigService.findAll());
	
	private CaracteristicasGraficas caracGraficasSelected;
	private ProcessadorGrafico procGraficoSelected;
	private RenderConfig renderConfigSelected;
	private Gpus gpuSelected;
	
	@FXML
	private TableView<PlacaDeVideo> tvPlacaDeVideo;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcIdGpu;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcNomeFabricante;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcNomeModelo;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcNomeGpu;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcArquitetura;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcShadingUnits;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcRops;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcTmus;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcTamMemoriaKB;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcTpMemoria;
	
	@FXML 
	private TableColumn<PlacaDeVideo, Double> tcGpuClock;
	
	@FXML
	private TableColumn<PlacaDeVideo, Double> tcBoostClock;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcDirectX;
	
	@FXML
	private TableColumn<PlacaDeVideo, Double> tcMemClock;
	
	@FXML
	private TableColumn<PlacaDeVideo, Double> tcMemClockEfetivo;
	
	@FXML
	private TableColumn<PlacaDeVideo, Integer> tcTamBanda;
	
	@FXML
	private TableColumn<PlacaDeVideo, Double> tcTpd;
	
	@FXML
	private TableColumn<PlacaDeVideo, String> tcBusInterface;
	
	@FXML
	private TableColumn<PlacaDeVideo, Date> tcDtLancto;
	
	@FXML
	private Button btNovo;
	
	@FXML
	private Button btEditar;
	
	@FXML
	private Button btCopiar;
	
	@FXML
	private Button btAtualizar;
	
	@FXML
	private Button btExcluir;
	
	
	// Caracteristicas Graficas
	
	@FXML
	private ComboBox<CaracteristicasGraficas> cboxCaracGraficas;
	
	@FXML
	private TextField txtDirectX;

	@FXML
	private TextField txtOpenGL;

	@FXML
	private TextField txtOpenCL;

	@FXML
	private TextField txtVulkan;

	@FXML
	private TextField txtCudaCores;

	@FXML
	private TextField txtShaderModel;
	
	@FXML
	private Button btNovoCaracGrafica;

	@FXML
	private Button btEditarCaracGrafica;
	
	@FXML
	private Button btCopiarCaracGrafica;

	@FXML
	private Button btExcluirCaracGrafica;
	
	
	// Render Config
	
	@FXML
	private ComboBox<RenderConfig> cboxRenderConfig;
	
	@FXML
	private TextField txtShadingUnits;

	@FXML
	private TextField txtTMUs;

	@FXML
	private TextField txtROPs;

	@FXML
	private TextField txtSmCount;

	@FXML
	private TextField txtL1Cache;

	@FXML
	private TextField txtL2Cache;

	@FXML
	private TextField txtTensorCores;

	@FXML
	private TextField txtRtCores;

	@FXML
	private Button btNovoRenderConfig;

	@FXML
	private Button btEditarRenderConfig;
	
	@FXML
	private Button btCopiarRenderConfig;
	
	@FXML
	private Button btExcluirRenderConfig;
	

	// Processador Gráfico
	
	@FXML
	private ComboBox<ProcessadorGrafico> cboxProcessadorGrafico;

	@FXML
	private TextField txtNomeGpu;

	@FXML
	private TextField txtVariantGpu;

	@FXML
	private TextField txtArquitetura;

	@FXML
	private TextField txtFundicao;

	@FXML
	private TextField txtLitografia;

	@FXML
	private TextField txtNroTransistores;

	@FXML
	private TextField txtTamanhoChip;
	
	@FXML
	private Button btNovoProcessadorGrafico;

	@FXML
	private Button btEditarProcessadorGrafico;
	
	@FXML
	private Button btCopiarProcessadorGrafico;

	@FXML
	private Button btExcluirProcessadorGrafico;
	
	
	// GPU
	
	@FXML
	private ComboBox<Gpus> cboxGpus;
	
	@FXML
	private TextField txtNomeFabricante;

	@FXML
	private TextField txtDescricaoModelo;

	@FXML
	private TextField txtTamanhoMemoria;

	@FXML
	private TextField txtTipoMemoria;

	@FXML
	private TextField txtTamanhoBanda;

	@FXML
	private TextField txtTDP;

	@FXML
	private TextField txtGpuClock;

	@FXML
	private TextField txtGpuBoostClock;

	@FXML
	private TextField txtMemoryClock;

	@FXML
	private TextField txtMemoryClockEfective;

	@FXML
	private TextField txtBusInterface;

	@FXML
	private TextField txtDtLancto;

	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;


	public void setPlacaDeVideoService(PlacaDeVideoService service) {
		this.service = service;
	}
	
	private void iniciarNodes() {
		tcIdGpu.setCellValueFactory(new PropertyValueFactory<>("IdGpu"));
		tcNomeFabricante.setCellValueFactory(new PropertyValueFactory<>("NomeFabricante"));
		tcNomeModelo.setCellValueFactory(new PropertyValueFactory<>("NomeModelo"));
		tcNomeGpu.setCellValueFactory(new PropertyValueFactory<>("NomeGpu"));
		tcArquitetura.setCellValueFactory(new PropertyValueFactory<>("Arquitetura"));
		tcShadingUnits.setCellValueFactory(new PropertyValueFactory<>("ShadingUnits"));
		tcRops.setCellValueFactory(new PropertyValueFactory<>("Rops"));
		tcTmus.setCellValueFactory(new PropertyValueFactory<>("Tmus"));
		tcTamMemoriaKB.setCellValueFactory(new PropertyValueFactory<>("TamMemoriaKB"));
		tcTpMemoria.setCellValueFactory(new PropertyValueFactory<>("TpMemoria"));
		tcGpuClock.setCellValueFactory(new PropertyValueFactory<>("GpuClock"));
		tcBoostClock.setCellValueFactory(new PropertyValueFactory<>("BoostClock"));
		tcDirectX.setCellValueFactory(new PropertyValueFactory<>("DirectX"));
		tcMemClock.setCellValueFactory(new PropertyValueFactory<>("MemClock"));
		tcMemClockEfetivo.setCellValueFactory(new PropertyValueFactory<>("MemClockEfetivo"));
		tcTamBanda.setCellValueFactory(new PropertyValueFactory<>("TamBanda"));
		tcTpd.setCellValueFactory(new PropertyValueFactory<>("Tdp"));
		tcBusInterface.setCellValueFactory(new PropertyValueFactory<>("BusInterface"));
		tcDtLancto.setCellValueFactory(new PropertyValueFactory<>("DtLancto"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvPlacaDeVideo.prefHeightProperty().bind(stage.heightProperty());
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("placasdevideoview.fxml")) {
			iniciarNodes();
		}
		
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("placasdevideoedit.fxml")) {
			Constraints.setTextFieldInteger(txtTamanhoMemoria);
			Constraints.setTextFieldInteger(txtTamanhoBanda);
			Constraints.setTextFieldDouble(txtTDP);
			Constraints.setTextFieldDouble(txtGpuClock);
			Constraints.setTextFieldDouble(txtGpuBoostClock);
			Constraints.setTextFieldDouble(txtMemoryClock);
			Constraints.setTextFieldDouble(txtMemoryClockEfective);
		}
	}
	
	@FXML
	public void onBtNovoAction() { 
		LoadSeparatedScenne.loadSeparatedView("/gui/PlacasDeVideoEdit.fxml", 814, 650, "Inserir Nova Placa de Vídeo",
				(PlacaDeVideoController controller) -> {
					controller.cboxProcessadorGrafico.setItems(listaProcGrafico);
					controller.cboxCaracGraficas.setItems(listaCaracGraficas);
					controller.cboxRenderConfig.setItems(listaRenderConfig);
					
					controller.setNewOrEdit('N');
				});
	}
	
	@FXML
	public void onBtEditarAction() {
		PlacaDeVideo placa = tvPlacaDeVideo.getSelectionModel().getSelectedItem();
		
		if (placa == null) {
			return;
		}
		
		gpuSelected = service.findByIdGpu(placa.getIdGpu());
		
		if (gpuSelected == null) {
			throw new IllegalStateException("gpuSelected está null");
		}
		
		caracGraficasSelected = caracGraficasService.findById(gpuSelected.getCaracteristicasGraficas().getIdCaracGrafica());
		procGraficoSelected = procGraficoService.findById(gpuSelected.getProcessadorGrafico().getIdProcGrafico());
		renderConfigSelected = renderConfigService.findById(gpuSelected.getRenderConfig().getIdRenderConfig());
		
		LoadSeparatedScenne.loadSeparatedView("/gui/PlacasDeVideoEdit.fxml", 814, 650, "Inserir Nova Placa de Vídeo",
				(PlacaDeVideoController controller) -> {
					controller.cboxProcessadorGrafico.setItems(listaProcGrafico);
					controller.cboxCaracGraficas.setItems(listaCaracGraficas);
					controller.cboxRenderConfig.setItems(listaRenderConfig);
					
					controller.txtDirectX.setText(procGraficoSelected.getNomeGpu());
					controller.txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
					controller.txtArquitetura.setText(procGraficoSelected.getArquitetura());
					controller.txtFundicao.setText(procGraficoSelected.getFundicao());
					controller.txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
					controller.txtNroTransistores.setText(procGraficoSelected.getNroTransistors().toString());
					controller.txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
					controller.cboxProcessadorGrafico.getSelectionModel().select(procGraficoSelected);
					controller.setProcGraficoSelected(procGraficoSelected);
					
					controller.txtDirectX.setText(caracGraficasSelected.getDirectX());
					controller.txtOpenGL.setText(caracGraficasSelected.getOpenGL());
					controller.txtOpenCL.setText(caracGraficasSelected.getOpenCL());
					controller.txtVulkan.setText(caracGraficasSelected.getVulkan());
					controller.txtCudaCores.setText(caracGraficasSelected.getCuda());
					controller.txtTensorCores.setText(caracGraficasSelected.getShaderModel());
					controller.cboxCaracGraficas.getSelectionModel().select(caracGraficasSelected);
					controller.setCaracGraficasSelected(caracGraficasSelected);
					
					controller.txtShadingUnits.setText(renderConfigSelected.getShadingUnits().toString());
					controller.txtTMUs.setText(renderConfigSelected.getTmus().toString());
					controller.txtROPs.setText(renderConfigSelected.getRops().toString());
					controller.txtSmCount.setText(renderConfigSelected.getSmCount().toString());
					controller.txtL1Cache.setText(renderConfigSelected.getL1Cache().toString());
					controller.txtL2Cache.setText(renderConfigSelected.getL1Cache().toString());
					controller.txtTensorCores.setText(renderConfigSelected.getTensorCores().toString());
					controller.txtRtCores.setText(renderConfigSelected.getRtCores().toString());
					controller.cboxRenderConfig.getSelectionModel().select(renderConfigSelected);
					controller.setRenderConfigSelected(renderConfigSelected);
					
					controller.txtNomeFabricante.setText(gpuSelected.getNomeFabricante());
					controller.txtDescricaoModelo.setText(gpuSelected.getNomeModelo());
					controller.txtTamanhoMemoria.setText(gpuSelected.getTamMemoriaKB().toString());
					controller.txtTipoMemoria.setText(gpuSelected.getTpMemoria());
					controller.txtTamanhoBanda.setText(gpuSelected.getTamBanda().toString());
					controller.txtTDP.setText(gpuSelected.getTdp().toString());
					controller.txtGpuClock.setText(gpuSelected.getGpuClock().toString());
					controller.txtGpuBoostClock.setText(gpuSelected.getBoostClock().toString());
					controller.txtMemoryClock.setText(gpuSelected.getMemClock().toString());
					controller.txtMemoryClockEfective.setText(gpuSelected.getMemClockEfetivo().toString());
					controller.txtBusInterface.setText(gpuSelected.getBusInterface());
					controller.txtDtLancto.setText(sdf.format(gpuSelected.getDtLancto()));
					controller.setGpuSelected(gpuSelected);
					
					controller.setNewOrEdit('E');
				});
	}
	
	@FXML
	public void onBtCopiarAction() {
		gpuSelected = service.findByIdGpu(tvPlacaDeVideo.getSelectionModel().getSelectedItem().getIdGpu());
		
		caracGraficasSelected = caracGraficasService.findById(gpuSelected.getCaracteristicasGraficas().getIdCaracGrafica());
		procGraficoSelected = procGraficoService.findById(gpuSelected.getProcessadorGrafico().getIdProcGrafico());
		renderConfigSelected = renderConfigService.findById(gpuSelected.getRenderConfig().getIdRenderConfig());
		
		LoadSeparatedScenne.loadSeparatedView("/gui/PlacasDeVideoEdit.fxml", 814, 650, "Copiar Nova Placa de Vídeo",
				(PlacaDeVideoController controller) -> {
					controller.cboxProcessadorGrafico.setItems(listaProcGrafico);
					controller.cboxCaracGraficas.setItems(listaCaracGraficas);
					controller.cboxRenderConfig.setItems(listaRenderConfig);
					
					controller.txtDirectX.setText(procGraficoSelected.getNomeGpu());
					controller.txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
					controller.txtArquitetura.setText(procGraficoSelected.getArquitetura());
					controller.txtFundicao.setText(procGraficoSelected.getFundicao());
					controller.txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
					controller.txtNroTransistores.setText(procGraficoSelected.getNroTransistors().toString());
					controller.txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
					controller.cboxProcessadorGrafico.getSelectionModel().select(procGraficoSelected);
					controller.setProcGraficoSelected(procGraficoSelected);
					
					controller.txtDirectX.setText(caracGraficasSelected.getDirectX());
					controller.txtOpenGL.setText(caracGraficasSelected.getOpenGL());
					controller.txtOpenCL.setText(caracGraficasSelected.getOpenCL());
					controller.txtVulkan.setText(caracGraficasSelected.getVulkan());
					controller.txtCudaCores.setText(caracGraficasSelected.getCuda());
					controller.txtTensorCores.setText(caracGraficasSelected.getShaderModel());
					controller.cboxCaracGraficas.getSelectionModel().select(caracGraficasSelected);
					controller.setCaracGraficasSelected(caracGraficasSelected);
					
					controller.txtShadingUnits.setText(renderConfigSelected.getShadingUnits().toString());
					controller.txtTMUs.setText(renderConfigSelected.getTmus().toString());
					controller.txtROPs.setText(renderConfigSelected.getRops().toString());
					controller.txtSmCount.setText(renderConfigSelected.getSmCount().toString());
					controller.txtL1Cache.setText(renderConfigSelected.getL1Cache().toString());
					controller.txtL2Cache.setText(renderConfigSelected.getL1Cache().toString());
					controller.txtTensorCores.setText(renderConfigSelected.getTensorCores().toString());
					controller.txtRtCores.setText(renderConfigSelected.getRtCores().toString());
					controller.cboxRenderConfig.getSelectionModel().select(renderConfigSelected);
					controller.setRenderConfigSelected(renderConfigSelected);
					
					controller.txtNomeFabricante.setText(gpuSelected.getNomeFabricante());
					controller.txtDescricaoModelo.setText(gpuSelected.getNomeModelo());
					controller.txtTamanhoMemoria.setText(gpuSelected.getTamMemoriaKB().toString());
					controller.txtTipoMemoria.setText(gpuSelected.getTpMemoria());
					controller.txtTamanhoBanda.setText(gpuSelected.getTamBanda().toString());
					controller.txtTDP.setText(gpuSelected.getTdp().toString());
					controller.txtGpuClock.setText(gpuSelected.getGpuClock().toString());
					controller.txtGpuBoostClock.setText(gpuSelected.getBoostClock().toString());
					controller.txtMemoryClock.setText(gpuSelected.getMemClock().toString());
					controller.txtMemoryClockEfective.setText(gpuSelected.getMemClockEfetivo().toString());
					controller.txtBusInterface.setText(gpuSelected.getBusInterface());
					controller.txtDtLancto.setText(sdf.format(gpuSelected.getDtLancto()));
					controller.setGpuSelected(gpuSelected);
					
					controller.setNewOrEdit('C');
				});
	}
	
	@FXML
	public void onBtAtualizarAction() {
		System.out.println("Atualizando Grid...");
		this.updateTableView();
	}
	
	@FXML
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onBtSalvarAction() throws NumberFormatException, ParseException {
		
		if (procGraficoSelected == null || caracGraficasSelected == null || renderConfigSelected == null) {
			Alerts.showAlert("IOException", null, "Necessário definir Processador Grafico / Carac. Gráficas / Render Config", 
					AlertType.ERROR);
		}
		else {
			Gpus gpu = new Gpus(null, 
					procGraficoSelected, 
					caracGraficasSelected, 
					renderConfigSelected, 
					txtNomeFabricante.getText(), 
					txtDescricaoModelo.getText(), 
					Integer.parseInt(txtTamanhoMemoria.getText()), 
					txtTipoMemoria.getText(), 
					Integer.parseInt(txtTamanhoBanda.getText()), 
					Double.parseDouble(txtTDP.getText()), 
					Double.parseDouble(txtGpuClock.getText()), 
					Double.parseDouble(txtGpuBoostClock.getText()), 
					Double.parseDouble(txtMemoryClock.getText()), 
					Double.parseDouble(txtMemoryClockEfective.getText()), 
					txtBusInterface.getText(), 
					sdf.parse(txtDtLancto.getText()));

			if (newOrEdit == 'N' || this.newOrEdit == 'C') {
				System.out.println(gpu.toString());
				service.inserir(gpu);
			}
			else if (newOrEdit == 'E') {
				gpu.setIdGpu(gpuSelected.getIdGpu());;
				System.out.println(gpu.toString());
				service.atualizar(gpu);
			}
			else {
				throw new IllegalStateException("Variavel newOrEdit está null");
			}

			
			Stage stage = (Stage) btCancelar.getScene().getWindow();
			stage.close();
		}
		
	}
	
	@FXML
	public void onBtExcluirAction() {
		gpuSelected = service.findByIdGpu(tvPlacaDeVideo.getSelectionModel().getSelectedItem().getIdGpu());
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir a Placa de Vídeo " + gpuSelected.getIdGpu() + ": " 
		                     + gpuSelected.getNomeFabricante() + " - " 
		                     + gpuSelected.getNomeModelo() + "???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(gpuSelected);
		} 

	}

	
	// edit

	@FXML
	public void onCboxCaracGraficasAction() {
		//caracGraficasSelected = cboxCaracGraficas.getSelectionModel().getSelectedItem();
		if (cboxCaracGraficas.getEditor().getText().split(":")[0].equals("")) {
			caracGraficasSelected = null;
		}
		else {
			caracGraficasSelected = caracGraficasService.findById(Integer.parseInt(cboxCaracGraficas.getEditor().getText().split(":")[0].trim()));
		}
		
		if (caracGraficasSelected != null) {
			txtDirectX.setText(caracGraficasSelected.getDirectX());
			txtOpenGL.setText(caracGraficasSelected.getOpenGL());
			txtOpenCL.setText(caracGraficasSelected.getOpenCL());
			txtVulkan.setText(caracGraficasSelected.getVulkan());
			txtCudaCores.setText(caracGraficasSelected.getCuda());
			txtShaderModel.setText(caracGraficasSelected.getShaderModel());
		}
		else {
			txtDirectX.setText(null);
			txtOpenGL.setText(null);
			txtOpenCL.setText(null);
			txtVulkan.setText(null);
			txtCudaCores.setText(null);
			txtShaderModel.setText(null);
		}
		
		listaCaracGraficas = FXCollections.observableArrayList(caracGraficasService.findAll());
	}
	
	@FXML
	public void onCboxProcessadorGraficoAction() {
		Locale.setDefault(Locale.US);
//		procGraficoSelected = cboxProcessadorGrafico.getSelectionModel().getSelectedItem();
		if (cboxProcessadorGrafico.getEditor().getText().split(":")[0].equals("")) {
			procGraficoSelected = null;
		}
		else {
			procGraficoSelected = procGraficoService.findById(Integer.parseInt(cboxProcessadorGrafico.getEditor().getText().split(":")[0].trim()));
		}
		
		if (procGraficoSelected != null) {
			txtNomeGpu.setText(procGraficoSelected.getNomeGpu());
			txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
			txtArquitetura.setText(procGraficoSelected.getArquitetura());
			txtFundicao.setText(procGraficoSelected.getFundicao());
			txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
			txtNroTransistores.setText(String.format("%.02f", procGraficoSelected.getNroTransistors()));
			txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
		}
		else {
			txtNomeGpu.setText(null);
			txtVariantGpu.setText(null);
			txtArquitetura.setText(null);
			txtFundicao.setText(null);
			txtLitografia.setText(null);
			txtNroTransistores.setText(null);
			txtTamanhoChip.setText(null);
		}
		
		listaProcGrafico = FXCollections.observableArrayList(procGraficoService.findAll());
	}
	
	@FXML
	public void onCboxRenderConfigAction() {
//		renderConfigSelected = cboxRenderConfig.getSelectionModel().getSelectedItem();
		
		if (cboxRenderConfig.getEditor().getText().split(":")[0].equals("")) {
			renderConfigSelected = null;
		}
		else {
			renderConfigSelected = renderConfigService.findById(Integer.parseInt(cboxRenderConfig.getEditor().getText().split(":")[0].trim()));
		}
		
		if (renderConfigSelected != null) {
			txtShadingUnits.setText(renderConfigSelected.getShadingUnits().toString());
			txtTMUs.setText(renderConfigSelected.getTmus().toString());
			txtROPs.setText(renderConfigSelected.getRops().toString());
			txtSmCount.setText(renderConfigSelected.getSmCount().toString());
			txtL1Cache.setText(renderConfigSelected.getL1Cache().toString());
			txtL2Cache.setText(renderConfigSelected.getL2Cache().toString());
			txtTensorCores.setText(renderConfigSelected.getTensorCores().toString());
			txtRtCores.setText(renderConfigSelected.getRtCores().toString());
		}
		else {
			txtShadingUnits.setText(null);
			txtTMUs.setText(null);
			txtROPs.setText(null);
			txtSmCount.setText(null);
			txtL1Cache.setText(null);
			txtL2Cache.setText(null);
			txtTensorCores.setText(null);
			txtRtCores.setText(null);
		}
		listaRenderConfig = FXCollections.observableArrayList(renderConfigService.findAll());

	}
	
	@FXML
	public void onCboxCaracGraficasKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxCaracGraficas, listaCaracGraficas, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}

	@FXML
	public void onCboxProcessadorGraficoKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxProcessadorGrafico, listaProcGrafico, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}

	@FXML
	public void onCboxCboxRenderConfigKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxRenderConfig, listaRenderConfig, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	@FXML
	public void onBtNovoCaracGraficaAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/CaracteristicasGraficasEdit.fxml", 375, 149, "Inserir Nova Característica Gráfica",
				(PlacaDeVideoCaracsController controller) -> {
					controller.setNewOrEdit('N');
				});
	}

	@FXML
	public void onBtEditarCaracGraficaAction() {
		if (caracGraficasSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/CaracteristicasGraficasEdit.fxml", 375, 149, "Editar Característica Gráfica",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtDirectX.setText(caracGraficasSelected.getDirectX());
						controller.txtOpenGL.setText(caracGraficasSelected.getOpenGL());
						controller.txtOpenCL.setText(caracGraficasSelected.getOpenCL());
						controller.txtVulkan.setText(caracGraficasSelected.getVulkan());
						controller.txtCudaCores.setText(caracGraficasSelected.getCuda());
						controller.txtShaderModel.setText(caracGraficasSelected.getShaderModel());
						controller.setCaracGraficasSelected(caracGraficasSelected);
						controller.setNewOrEdit('E');
					});
		}
	}

	@FXML
	public void onBtCopiarCaracGraficaAction() {
		if (caracGraficasSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/CaracteristicasGraficasEdit.fxml", 375, 149, "Copiar Característica Gráfica",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtDirectX.setText(caracGraficasSelected.getDirectX());
						controller.txtOpenGL.setText(caracGraficasSelected.getOpenGL());
						controller.txtOpenCL.setText(caracGraficasSelected.getOpenCL());
						controller.txtVulkan.setText(caracGraficasSelected.getVulkan());
						controller.txtCudaCores.setText(caracGraficasSelected.getCuda());
						controller.txtShaderModel.setText(caracGraficasSelected.getShaderModel());
						controller.setCaracGraficasSelected(caracGraficasSelected);
						controller.setNewOrEdit('C');
					});
		}
	}
	
	@FXML
	public void onBtNovoProcessadorGraficoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadorGraficoEdit.fxml", 782, 140, "Inserir Novo Processador Gráfico",
				(PlacaDeVideoCaracsController controller) -> {
					controller.setNewOrEdit('N');
				});
	}

	@FXML
	public void onBtEditarProcessadorGraficoAction() {
		if (procGraficoSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadorGraficoEdit.fxml", 782, 140, "Editar Processador Gráfico",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtNomeGpu.setText(procGraficoSelected.getNomeGpu());
						controller.txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
						controller.txtArquitetura.setText(procGraficoSelected.getArquitetura());
						controller.txtFundicao.setText(procGraficoSelected.getFundicao());
						controller.txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
						controller.txtNroTransistores.setText(procGraficoSelected.getNroTransistors().toString());
						controller.txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
						controller.setProcGraficoSelected(procGraficoSelected);
						controller.setNewOrEdit('E');
					});
		}
	}

	@FXML
	public void onBtCopiarProcessadorGraficoAction() {
		if (procGraficoSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadorGraficoEdit.fxml", 782, 140, "Copiar Processador Gráfico",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtNomeGpu.setText(procGraficoSelected.getNomeGpu());
						controller.txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
						controller.txtArquitetura.setText(procGraficoSelected.getArquitetura());
						controller.txtFundicao.setText(procGraficoSelected.getFundicao());
						controller.txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
						controller.txtNroTransistores.setText(procGraficoSelected.getNroTransistors().toString());
						controller.txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
						controller.setProcGraficoSelected(procGraficoSelected);
						controller.setNewOrEdit('C');
					});
		}
	}

	@FXML
	public void onBtNovoRenderConfigAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/RenderConfigEdit.fxml", 375, 140, "Inserir Novo Render Config",
				(PlacaDeVideoCaracsController controller) -> {
					controller.setNewOrEdit('N');
				});
		
		listaRenderConfig = FXCollections.observableArrayList(renderConfigService.findAll());
		cboxRenderConfig.setItems(listaRenderConfig);;
	}

	@FXML
	public void onBtEditarRenderConfigAction() {
		if (renderConfigSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/RenderConfigEdit.fxml", 375, 140, "Editar Render Config",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtShadingUnits.setText(renderConfigSelected.getShadingUnits().toString());
						controller.txtTMUs.setText(renderConfigSelected.getTmus().toString());
						controller.txtROPs.setText(renderConfigSelected.getRops().toString());
						controller.txtSmCount.setText(renderConfigSelected.getSmCount().toString());
						controller.txtL1Cache.setText(renderConfigSelected.getL1Cache().toString());
						controller.txtL2Cache.setText(renderConfigSelected.getL2Cache().toString());
						controller.txtTensorCores.setText(renderConfigSelected.getTensorCores().toString());
						controller.txtRtCores.setText(renderConfigSelected.getRtCores().toString());
						controller.setRenderConfigSelected(renderConfigSelected);
						controller.setNewOrEdit('E');
					});
		}
	}

	@FXML
	public void onBtCopiarRenderConfigAction() {
		if (renderConfigSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/RenderConfigEdit.fxml", 375, 140, "Copiar Render Config",
					(PlacaDeVideoCaracsController controller) -> {
						controller.txtShadingUnits.setText(renderConfigSelected.getShadingUnits().toString());
						controller.txtTMUs.setText(renderConfigSelected.getTmus().toString());
						controller.txtROPs.setText(renderConfigSelected.getRops().toString());
						controller.txtSmCount.setText(renderConfigSelected.getSmCount().toString());
						controller.txtL1Cache.setText(renderConfigSelected.getL1Cache().toString());
						controller.txtL2Cache.setText(renderConfigSelected.getL2Cache().toString());
						controller.txtTensorCores.setText(renderConfigSelected.getTensorCores().toString());
						controller.txtRtCores.setText(renderConfigSelected.getRtCores().toString());
						controller.setRenderConfigSelected(renderConfigSelected);
						controller.setNewOrEdit('C');
					});
		}
	}

	// getters / setters
	
	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
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
	
	public Gpus getGpuSelected() {
		return gpuSelected;
	}

	public void setGpuSelected(Gpus gpuSelected) {
		this.gpuSelected = gpuSelected;
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<PlacaDeVideo> lista = service.findAll();
		tvPlacaDeVideo.setItems(FXCollections.observableArrayList(lista));
	}

}
	