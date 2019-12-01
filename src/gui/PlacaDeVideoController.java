package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

	private PlacaDeVideoService service;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private char newOrEdit;
	
	private ProcessadorGraficoService procGraficoService = new ProcessadorGraficoService();
	private CaracteristicasGraficasService caracGraficasService = new CaracteristicasGraficasService();
	private RenderConfigService renderConfigService = new RenderConfigService();

	private ObservableList<ProcessadorGrafico> listaProcGrafico = FXCollections.observableArrayList(procGraficoService.findAll());
	private ObservableList<CaracteristicasGraficas> listaCaracGraficas = FXCollections.observableArrayList(caracGraficasService.findAll());
	private ObservableList<RenderConfig> listaRenderConfig = FXCollections.observableArrayList(renderConfigService.findAll());
	
	private CaracteristicasGraficas caracGraficasSelected;
	private ProcessadorGrafico procGraficoSelected;
	private RenderConfig renderConfigSelected;
	
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
		
	}
	
	
	public void onBtNovoAction() { 
		LoadSeparatedScenne.loadSeparatedView("/gui/PlacasDeVideoEdit.fxml", 814, 600, "Inserir Nova Placa de Vídeo",
				(PlacaDeVideoController controller) -> {
					controller.cboxProcessadorGrafico.setItems(listaProcGrafico);
					controller.cboxCaracGraficas.setItems(listaCaracGraficas);
					controller.cboxRenderConfig.setItems(listaRenderConfig);
					
					controller.setNewOrEdit('N');
				});
	}

	public void onCboxCaracGraficasAction() {
		caracGraficasSelected = cboxCaracGraficas.getSelectionModel().getSelectedItem();
		
		if (caracGraficasSelected != null) {
			txtDirectX.setText(caracGraficasSelected.getDirectX());
			txtOpenGL.setText(caracGraficasSelected.getOpenGL());
			txtOpenCL.setText(caracGraficasSelected.getOpenCL());
			txtVulkan.setText(caracGraficasSelected.getVulkan());
			txtCudaCores.setText(caracGraficasSelected.getCuda());
			txtShaderModel.setText(caracGraficasSelected.getShaderModel());
		}
		
	}
	
	public void onCboxProcessadorGraficoAction() {
		Locale.setDefault(Locale.US);
		procGraficoSelected = cboxProcessadorGrafico.getSelectionModel().getSelectedItem();
		
		if (procGraficoSelected != null) {
			txtNomeGpu.setText(procGraficoSelected.getNomeGpu());
			txtVariantGpu.setText(procGraficoSelected.getVariantGpu());
			txtArquitetura.setText(procGraficoSelected.getArquitetura());
			txtFundicao.setText(procGraficoSelected.getFundicao());
			txtLitografia.setText(procGraficoSelected.getNnProcessador().toString());
			txtNroTransistores.setText(String.format("%.02f", procGraficoSelected.getNroTransistors()));
			txtTamanhoChip.setText(procGraficoSelected.getMmProcessador().toString());
		}
	}
	
	public void onCboxRenderConfigAction() {
		renderConfigSelected = cboxRenderConfig.getSelectionModel().getSelectedItem();
		
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
	}

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

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<PlacaDeVideo> lista = service.findAll();
		tvPlacaDeVideo.setItems(FXCollections.observableArrayList(lista));
	}


}
