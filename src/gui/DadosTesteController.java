package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.sun.prism.paint.Paint;

import application.Main;
import gui.util.ComboBoxAutoComplete;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.ConfiguracoesJogosService;
import models.entities.services.DadosTesteService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorService;
import models.entities.tables.TestesGpu;
import models.entities.views.ConfiguracoesJogosW;
import models.entities.views.DadosTeste;
import models.entities.views.PlacaDeVideo;
import models.entities.views.Processador;

public class DadosTesteController implements Initializable {

	private DadosTesteService service;
	private char NewOrEdit;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private PlacaDeVideoService placaDeVideoService = new PlacaDeVideoService();
	private ProcessadorService processadorService = new ProcessadorService();
	private ConfiguracoesJogosService configuracoesJogosService = new ConfiguracoesJogosService(); 
	
	private ConfiguracoesJogosW configuracoesJogosSelected;
	private PlacaDeVideo placaDeVideoSelected;
	private Processador processadorSelected;
	private DadosTeste dadosTesteSelected;
	
	private ObservableList<PlacaDeVideo> placasDeVideoLista;
	private ObservableList<Processador> processadoresLista;
	private ObservableList<ConfiguracoesJogosW> configuracoesJogosLista;

	@FXML
	private TableView<DadosTeste> tvDadosTeste;

	@FXML
	private TableColumn<DadosTeste, String> tcNomeModeloGpu;

	@FXML
	private TableColumn<DadosTeste, String> tcNomeModeloProcessador;

	@FXML
	private TableColumn<DadosTeste, Integer> tcResolucaoAbrev;

	@FXML
	private TableColumn<DadosTeste, String> tcQualidadeGrafica;

	@FXML
	private TableColumn<DadosTeste, String> tcApi;

	@FXML
	private TableColumn<DadosTeste, String> tcFxaa;

	@FXML
	private TableColumn<DadosTeste, String> tcSsao;

	@FXML
	private TableColumn<DadosTeste, String> tcAa;

	@FXML
	private TableColumn<DadosTeste, String> tcRt;

	@FXML
	private TableColumn<DadosTeste, String> tcTaa;

	@FXML
	private TableColumn<DadosTeste, String> tcNVidiaTec;

	@FXML
	private TableColumn<DadosTeste, Double> tcAvgFps;

	@FXML
	private TableColumn<DadosTeste, Double> tcMinFps;

	@FXML
	private TableColumn<DadosTeste, String> tcNomeTester;

	@FXML
	private TableColumn<DadosTeste, Date> tcDtTeste;

	@FXML
	private TableColumn<DadosTeste, String> tcNomeDriverGpu;

	@FXML
	private TableColumn<DadosTeste, String> tcNomeJogo;
	
	@FXML
	private Button btNovo;
	
	@FXML
	private Button btEditar;
	
	@FXML
	private Button btAtualizar;
	
	@FXML
	private Button btExcluir;
	
	@FXML
	private Label lbTitulo;
	
	// edit
	
	@FXML
	ComboBox<PlacaDeVideo> cboxPlacaDeVideo;
	
	@FXML
	TextField txtGpuFabricante;

	@FXML
	TextField txtGpuModelo;

	@FXML
	TextField txtDirectX;

	@FXML
	TextField txtOpenGL;

	@FXML
	TextField txtOpenCL;

	@FXML
	TextField txtVulkan;

	@FXML
	TextField txtBusInterface;

	@FXML
	TextField txtGpuTdp;

	@FXML
	TextField txtTamanhoMemoria;

	@FXML
	TextField txtTipoMemoria;

	@FXML
	TextField txtGpuClock;

	@FXML
	TextField txtGpuBoostClock;

	@FXML
	TextField txtMemoryGpuClock;

	@FXML
	TextField txtMemoryGpuClockEfective;

	@FXML
	TextField txtGpuDtLancto;
	
	
	@FXML
	ComboBox<Processador> cboxProcessador;
	
	@FXML
	TextField txtCpuFabricante;

	@FXML
	TextField txtCpuModelo;

	@FXML
	TextField txtNroCores;

	@FXML
	TextField txtNroThreads;

	@FXML
	TextField txtCpuFrequencia;

	@FXML
	TextField txtCpuTurboFrequencia;

	@FXML
	TextField txtSocket;

	@FXML
	TextField txtCpuTdp;
	
	
	@FXML
	ComboBox<ConfiguracoesJogosW> cboxConfiguracoesJogos;
	
	@FXML
	TextField txtNomeJogo;

	@FXML
	private TextField txtResolucaoDetalhe;

	@FXML
	private TextField txtResolucaoAbrev;

	@FXML
	private TextField txtApi;

	@FXML
	private TextField txtQualidadeGrafica;
	
	@FXML
	private TextField txtAaliasing;
	
	@FXML
	private CheckBox cbSsao;

	@FXML
	private CheckBox cbFxaa;

	@FXML
	private CheckBox cbTaa;

	@FXML
	private CheckBox cbRt;

	@FXML
	private TextField txtNVidiaTec;
	
	
	// dados teste
	
	
	@FXML
	TextField txtNomeTester;

	@FXML
	TextField txtDriverGpu;

	@FXML
	TextField txtAvgFps;

	@FXML
	TextField txtMinFps;

	@FXML
	TextField txtDtTeste;

	@FXML
	Button btSalvar;
	
	@FXML
	Button btCancelar;


	public void setDadosTesteService(DadosTesteService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		if (Constraints.getArqFXML(url.getFile()).toLowerCase().equals("testesview.fxml")) {
			iniciarNodes();
		}
		atualiazarComboBox();
	}

	private void iniciarNodes() {
		tcNomeModeloGpu.setCellValueFactory(new PropertyValueFactory<>("NomeModeloGpu"));
		tcNomeModeloProcessador.setCellValueFactory(new PropertyValueFactory<>("nomeModeloProcessador"));
		tcResolucaoAbrev.setCellValueFactory(new PropertyValueFactory<>("ResolucaoAbrev"));
		tcQualidadeGrafica.setCellValueFactory(new PropertyValueFactory<>("QualidadeGrafica"));
		tcApi.setCellValueFactory(new PropertyValueFactory<>("Api"));
		tcFxaa.setCellValueFactory(new PropertyValueFactory<>("Fxaa"));
		tcSsao.setCellValueFactory(new PropertyValueFactory<>("Ssao"));
		tcAa.setCellValueFactory(new PropertyValueFactory<>("Aa"));
		tcRt.setCellValueFactory(new PropertyValueFactory<>("Rt"));
		tcTaa.setCellValueFactory(new PropertyValueFactory<>("Taa"));
		tcNVidiaTec.setCellValueFactory(new PropertyValueFactory<>("NVidiaTec"));
		tcAvgFps.setCellValueFactory(new PropertyValueFactory<>("AvgFps"));
		tcMinFps.setCellValueFactory(new PropertyValueFactory<>("MinFps"));
		tcNomeTester.setCellValueFactory(new PropertyValueFactory<>("NomeTester"));
		tcDtTeste.setCellValueFactory(new PropertyValueFactory<>("DtTeste"));
		tcNomeDriverGpu.setCellValueFactory(new PropertyValueFactory<>("NomeDriverGpu"));
		tcNomeJogo.setCellValueFactory(new PropertyValueFactory<>("NomeJogo"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvDadosTeste.prefHeightProperty().bind(stage.heightProperty());
	}
	
	// navigator da view
	
	public void onBtNovoAction() { 
		LoadSeparatedScenne.loadSeparatedView("/gui/TestesEdit.fxml", 750, 650, "Inserir Novo Teste",
				(DadosTesteController controller) -> {
					controller.cboxConfiguracoesJogos.setItems(configuracoesJogosLista);
					controller.cboxPlacaDeVideo.setItems(placasDeVideoLista);
					controller.cboxProcessador.setItems(processadoresLista);
					
					controller.setNewOrEdit('N');
				});
	}
	
	public void onBtEditarAction() {
		
		dadosTesteSelected = tvDadosTeste.getSelectionModel().getSelectedItem();
		configuracoesJogosSelected = configuracoesJogosService.findById(dadosTesteSelected.getIdConfiguracaoJogo());
		placaDeVideoSelected = placaDeVideoService.findById(dadosTesteSelected.getIdGpu());
		processadorSelected = processadorService.findById(dadosTesteSelected.getIdProcessador());
		
		LoadSeparatedScenne.loadSeparatedView("/gui/TestesEdit.fxml", 750, 650, "Editar Teste",
				(DadosTesteController controller) -> {
					controller.cboxConfiguracoesJogos.setItems(configuracoesJogosLista);
					controller.cboxPlacaDeVideo.setItems(placasDeVideoLista);
					controller.cboxProcessador.setItems(processadoresLista);
					
					controller.setDadosTesteSelected(dadosTesteSelected);
					controller.setConfiguracoesJogosSelected(configuracoesJogosSelected);
					controller.setPlacaDeVideoSelected(placaDeVideoSelected);
					controller.setProcessadorSelected(processadorSelected);
					
					controller.txtNomeTester.setText(dadosTesteSelected.getNomeJogo());
					controller.txtDriverGpu.setText(dadosTesteSelected.getNomeDriverGpu());
					controller.txtAvgFps.setText(dadosTesteSelected.getAvgFps().toString());
					controller.txtMinFps.setText(dadosTesteSelected.getMinFps().toString());
					controller.txtDtTeste.setText(sdf.format(dadosTesteSelected.getDtTeste()));
					
					controller.cboxConfiguracoesJogos.getSelectionModel().select(configuracoesJogosSelected);
					controller.cboxPlacaDeVideo.getSelectionModel().select(placaDeVideoSelected);
					controller.cboxProcessador.getSelectionModel().select(processadorSelected);
					
					controller.cboxConfiguracoesJogos.getEditor().setText(configuracoesJogosSelected.toString());
					controller.cboxPlacaDeVideo.getEditor().setText(placaDeVideoSelected.toString());
					controller.cboxProcessador.getEditor().setText(processadorSelected.toString());
					
					controller.onCBoxConfiguracoesJogosAction();
					controller.onCBoxPlacaDeVideoAction();
					controller.onCBoxProcessadorAction();
					
					controller.setNewOrEdit('E');
				});
	}
	
	public void onBtAtualizarAction() {
		this.updateTableView();
	}
	
	public void onBtExcluirAction() {
		dadosTesteSelected = tvDadosTeste.getSelectionModel().getSelectedItem();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir o jogo " + dadosTesteSelected.getNomeModeloGpu() + " - " 
		                     + dadosTesteSelected.getNomeJogo() + "???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(service.findByIdTesteGpu(dadosTesteSelected.getIdTesteGpu()));
		} 

	}
	
	public void onCBoxConfiguracoesJogosPressed() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxConfiguracoesJogos, configuracoesJogosLista, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}

	public void onCBoxPlacaDeVideoPressed() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxPlacaDeVideo, placasDeVideoLista, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	public void onCBoxProcessadorPressed() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxProcessador, processadoresLista, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	public void onCBoxConfiguracoesJogosAction() {
		if (cboxConfiguracoesJogos.getEditor().getText().split(":")[0].equals("")) {
			configuracoesJogosSelected = null;
		}
		else {
			configuracoesJogosSelected = configuracoesJogosService.findById(Integer.parseInt(cboxConfiguracoesJogos.getEditor().getText().split(":")[0].trim()));
		}
		
		if (configuracoesJogosSelected != null) {
			txtNomeJogo.setText(configuracoesJogosSelected.getNomeJogo());
			txtQualidadeGrafica.setText(configuracoesJogosSelected.getQualidadeGrafica());
			txtResolucaoDetalhe.setText(configuracoesJogosSelected.getResolucaoDetalhe());
			txtResolucaoAbrev.setText(configuracoesJogosSelected.getResolucaoAbrev().toString());
			txtApi.setText(configuracoesJogosSelected.getApi());
			txtAaliasing.setText(configuracoesJogosSelected.getAa());
			cbSsao.setSelected(Constraints.isChecked(configuracoesJogosSelected.getSsao()));
			cbFxaa.setSelected(Constraints.isChecked(configuracoesJogosSelected.getFxaa()));
			cbTaa.setSelected(Constraints.isChecked(configuracoesJogosSelected.getTaa()));
			cbRt.setSelected(Constraints.isChecked(configuracoesJogosSelected.getRt()));
			txtNVidiaTec.setText(configuracoesJogosSelected.getNVidiaTec());
		}
		else {
			txtNomeJogo.setText(null);
			txtQualidadeGrafica.setText(null);
			txtResolucaoDetalhe.setText(null);
			txtResolucaoAbrev.setText(null);
			txtApi.setText(null);
			txtAaliasing.setText(null);
			cbSsao.setSelected(false);
			cbFxaa.setSelected(false);
			cbTaa.setSelected(false);
			cbRt.setSelected(false);
			txtNVidiaTec.setText(null);
		}
		
		atualiazarComboBox();
	}

	public void onCBoxProcessadorAction() {
		if (cboxProcessador.getEditor().getText().split(":")[0].equals("")) {
			processadorSelected = null;
		}
		else {
			processadorSelected = processadorService.findById(Integer.parseInt(cboxProcessador.getEditor().getText().split(":")[0].trim()));
		}
		
		if (processadorSelected != null) {
			txtCpuFabricante.setText(processadorSelected.getNomeFabricante());
			txtCpuModelo.setText(processadorSelected.getNomeModelo());
			txtNroCores.setText(processadorSelected.getNroCores().toString());
			txtNroThreads.setText(processadorSelected.getNroThreads().toString());
			txtCpuFrequencia.setText(processadorSelected.getFrequencia().toString());
			txtCpuTurboFrequencia.setText(processadorSelected.getTurboFrequencia().toString());
			txtSocket.setText(processadorSelected.getSocket());
			txtCpuTdp.setText(processadorSelected.getTdp().toString());
		}
		else {
			txtCpuFabricante.setText(null);
			txtCpuModelo.setText(null);
			txtNroCores.setText(null);
			txtNroThreads.setText(null);
			txtCpuFrequencia.setText(null);
			txtCpuTurboFrequencia.setText(null);
			txtSocket.setText(null);
			txtCpuTdp.setText(null);
		}
		
		atualiazarComboBox();

	}

	public void onCBoxPlacaDeVideoAction() {
		if (cboxPlacaDeVideo.getEditor().getText().split(":")[0].equals("")) {
			placaDeVideoSelected = null;
		}
		else {
			placaDeVideoSelected = placaDeVideoService.findById(Integer.parseInt(cboxPlacaDeVideo.getEditor().getText().split(":")[0].trim()));
		}
		
		if (placaDeVideoSelected != null) {
			txtGpuFabricante.setText(placaDeVideoSelected.getNomeFabricante());
			txtGpuModelo.setText(placaDeVideoSelected.getNomeModelo());
			txtDirectX.setText(placaDeVideoSelected.getDirectX());
			txtOpenGL.setText(placaDeVideoSelected.getOpenGL());
			txtOpenCL.setText(placaDeVideoSelected.getOpenCL());
			txtVulkan.setText(placaDeVideoSelected.getVulkan());
			txtBusInterface.setText(placaDeVideoSelected.getBusInterface());
			txtGpuTdp.setText(placaDeVideoSelected.getTdp().toString());
			txtTamanhoMemoria.setText(placaDeVideoSelected.getTamMemoriaKB().toString());
			txtTipoMemoria.setText(placaDeVideoSelected.getTpMemoria());
			txtGpuClock.setText(placaDeVideoSelected.getGpuClock().toString());
			txtGpuBoostClock.setText(placaDeVideoSelected.getBoostClock().toString());
			txtMemoryGpuClock.setText(placaDeVideoSelected.getMemClock().toString());
			txtMemoryGpuClockEfective.setText(placaDeVideoSelected.getMemClockEfetivo().toString());
			txtGpuDtLancto.setText(sdf.format(placaDeVideoSelected.getDtLancto().getTime()));
		}
		else {
			txtGpuFabricante.setText(null);
			txtGpuModelo.setText(null);
			txtDirectX.setText(null);
			txtOpenGL.setText(null);
			txtOpenCL.setText(null);
			txtVulkan.setText(null);
			txtBusInterface.setText(null);
			txtGpuTdp.setText(null);
			txtTamanhoMemoria.setText(null);
			txtTipoMemoria.setText(null);
			txtGpuClock.setText(null);
			txtGpuBoostClock.setText(null);
			txtMemoryGpuClock.setText(null);
			txtMemoryGpuClockEfective.setText(null);
			txtGpuDtLancto.setText(null);
		}
		
		atualiazarComboBox();
		
//		cboxPlacaDeVideo.getEditor().textProperty().addListener(new ChangeListener<String>() {
//		    
//		    }
//		});
//
	}
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}
	
	public void onBtSalvarAction() throws NumberFormatException, ParseException {
		service = new DadosTesteService();
		
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		TestesGpu teste = new TestesGpu(null, 
				configuracoesJogosService.findByConfiguracaoJogos(configuracoesJogosSelected.getIdConfiguracaoJogo()), 
				placaDeVideoService.findByIdGpu(placaDeVideoSelected.getIdGpu()), 
				processadorService.findByIdProcessadores(processadorSelected.getIdProcessador()), 
			    txtDriverGpu.getText(), 
			    Double.parseDouble(txtAvgFps.getText()), 
			    Double.parseDouble(txtMinFps.getText()), 
			    sdf.parse(txtDtTeste.getText()), 
			    txtNomeTester.getText());
	
		if (this.NewOrEdit == 'N') {
			service.inserir(teste);
		}
		else {
			teste.setIdTesteGpu(dadosTesteSelected.getIdTesteGpu());
			System.out.println(teste.toString());
			service.atualizar(teste);
		}
		
//		lbTitulo.setStyle("-fx-background-color: green;");
//		lbTitulo.setText("Novo Teste - <<Salvo>>");
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<DadosTeste> lista = service.findAll();
		tvDadosTeste.setItems(FXCollections.observableArrayList(lista));
	}
	
	private void atualiazarComboBox() {
		configuracoesJogosLista = FXCollections.observableArrayList(configuracoesJogosService.findAll());
		placasDeVideoLista = FXCollections.observableArrayList(placaDeVideoService.findAll());
		processadoresLista = FXCollections.observableArrayList(processadorService.findAll());
	}

	public char getNewOrEdit() {
		return NewOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		NewOrEdit = newOrEdit;
	}

	public ConfiguracoesJogosW getConfiguracoesJogosSelected() {
		return configuracoesJogosSelected;
	}

	public void setConfiguracoesJogosSelected(ConfiguracoesJogosW configuracoesJogosSelected) {
		this.configuracoesJogosSelected = configuracoesJogosSelected;
	}

	public PlacaDeVideo getPlacaDeVideoSelected() {
		return placaDeVideoSelected;
	}

	public void setPlacaDeVideoSelected(PlacaDeVideo placaDeVideoSelected) {
		this.placaDeVideoSelected = placaDeVideoSelected;
	}

	public Processador getProcessadorSelected() {
		return processadorSelected;
	}

	public void setProcessadorSelected(Processador processadorSelected) {
		this.processadorSelected = processadorSelected;
	}
	
	public DadosTeste getDadosTesteSelected() {
		return dadosTesteSelected;
	}

	public void setDadosTesteSelected(DadosTeste dadosTesteSelected) {
		this.dadosTesteSelected = dadosTesteSelected;
	}

	
}
