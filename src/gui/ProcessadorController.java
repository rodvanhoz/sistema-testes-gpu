package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
import models.entities.services.DadosProcessadorService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorService;
import models.entities.tables.DadosProcessador;
import models.entities.tables.Gpus;
import models.entities.tables.Processadores;
import models.entities.views.PlacaDeVideo;
import models.entities.views.Processador;

public class ProcessadorController implements Initializable {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private char newOrEdit;
	
	private ProcessadorService service;
	private DadosProcessadorService dadosProcessadorService = new DadosProcessadorService();
	private PlacaDeVideoService gpuService = new PlacaDeVideoService();
	
	private ObservableList<DadosProcessador> listaDadosProcessador = FXCollections.observableArrayList(dadosProcessadorService.findAll());
	private ObservableList<PlacaDeVideo> listaGpus = FXCollections.observableArrayList(gpuService.findAll());
	
	private DadosProcessador dadosProcessadorSelected;
	private PlacaDeVideo gpuSelected;
	private Processador processadorSelected;
	
	@FXML
	private TableView<Processador> tvProcessador;
	
	@FXML
	private TableColumn<Processador, Integer> tcIdProcessador;

	@FXML
	private TableColumn<Processador, String> tcNomeFabricante;
	
	@FXML
	private TableColumn<Processador, String> tcNomeModelo;

	@FXML
	private TableColumn<Processador, Integer> tcNroCores;

	@FXML
	private TableColumn<Processador, Integer> tcNroThreads;

	@FXML
	private TableColumn<Processador, Double> tcTdp;

	@FXML
	private TableColumn<Processador, Double> tcFrequencia;

	@FXML
	private TableColumn<Processador, Double> tcTurbofrequencia;
	
	@FXML
	private TableColumn<Processador, String> tcCodename;

	@FXML
	private TableColumn<Processador, String> tcSocket;

	@FXML
	private TableColumn<Processador, String> tcGraficoIntegrado;
	
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
	
	
	// EDIT
	
	
	// dados processador
	
	@FXML
	private ComboBox<DadosProcessador> cboxDadosProcessador;
	
	@FXML
	private TextField txtSocket;

	@FXML
	private TextField txtFoundry;

	@FXML
	private TextField txtTamanhoChip;

	@FXML
	private TextField txtTransistors;

	@FXML
	private TextField txtPackage;

	@FXML
	private TextField txtTCaseMax;
	
	@FXML
	private Button btDadosNovo;
	
	@FXML
	private Button btDadosEditar;
	
	@FXML
	private Button btDadosCopiar;

	// processador

	@FXML
	private TextField txtNomeFabricante;

	@FXML
	private TextField txtDescrModelo;

	@FXML
	private TextField txtMarket;

	@FXML
	private TextField txtReleased;

	@FXML
	private TextField txtCodename;

	@FXML
	private TextField txtGeneration;

	@FXML
	private TextField txtMemorySupport;

	@FXML
	private TextField txtFrequencia;

	@FXML
	private TextField txtTurboFrequencia;

	@FXML
	private TextField txtBaseClock;

	@FXML
	private TextField txtMultiplicador;

	@FXML
	private TextField txtEhDesbloqueado;

	@FXML
	private TextField txtCores;

	@FXML
	private TextField txtThreads;

	@FXML
	private TextField txtSMP;

	@FXML
	private TextField txtTDP;

	@FXML
	private ComboBox<PlacaDeVideo> cboxGraficoIntegrado;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	public void setProcessadorService(ProcessadorService service) {
		this.service = service;
	}
	
	private void iniciarNodes() {
		tcIdProcessador.setCellValueFactory(new PropertyValueFactory<>("IdProcessador"));
		tcNomeFabricante.setCellValueFactory(new PropertyValueFactory<>("NomeFabricante"));
		tcNomeModelo.setCellValueFactory(new PropertyValueFactory<>("NomeModelo"));
		tcNroCores.setCellValueFactory(new PropertyValueFactory<>("NroCores"));
		tcNroThreads.setCellValueFactory(new PropertyValueFactory<>("NroThreads"));
		tcTdp.setCellValueFactory(new PropertyValueFactory<>("Tdp"));
		tcFrequencia.setCellValueFactory(new PropertyValueFactory<>("Frequencia"));
		tcTurbofrequencia.setCellValueFactory(new PropertyValueFactory<>("Turbofrequencia"));
		tcCodename.setCellValueFactory(new PropertyValueFactory<>("Codename"));
		tcSocket.setCellValueFactory(new PropertyValueFactory<>("Socket"));
		tcGraficoIntegrado.setCellValueFactory(new PropertyValueFactory<>("GraficoIntegrado"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvProcessador.prefHeightProperty().bind(stage.heightProperty());
	}
	
	@FXML
	public void onBtNovoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadoresEdit.fxml", 660, 460, "Inserir Novo Processador",
				(ProcessadorController controller) -> {
					controller.cboxDadosProcessador.setItems(listaDadosProcessador);
					controller.cboxGraficoIntegrado.setItems(listaGpus);
					
					controller.setNewOrEdit('N');
				});
	}

	@FXML
	public void onBtEditarAction() {
		
		processadorSelected = tvProcessador.getSelectionModel().getSelectedItem();
		
		if (processadorSelected == null) {
			return;
		}
		
		dadosProcessadorSelected = dadosProcessadorService.findById(processadorSelected.getIdDadosProcessador());
		
		Processadores proc = service.findByIdProcessadores(processadorSelected.getIdProcessador());
		
		Gpus graficoIntegrado = null;
		if (proc.getGpu() != null) {
			graficoIntegrado = proc.getGpu(); 
			gpuSelected = gpuService.findById(graficoIntegrado.getIdGpu());
		}
		else {
			gpuSelected = null;
		}
		
		LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadoresEdit.fxml", 660, 460, "Editar Processador",
				(ProcessadorController controller) -> {
					controller.cboxDadosProcessador.setItems(listaDadosProcessador);
					controller.cboxGraficoIntegrado.setItems(listaGpus);
					
					controller.setProcessadorSelected(processadorSelected);
					controller.setDadosProcessadorSelected(dadosProcessadorSelected);
					
					controller.cboxDadosProcessador.getSelectionModel().select(dadosProcessadorSelected);
					controller.cboxDadosProcessador.getEditor().setText(dadosProcessadorSelected.toString());
					controller.cboxGraficoIntegrado.getSelectionModel().select(gpuSelected);
					controller.cboxGraficoIntegrado.getEditor().setText((gpuSelected != null) ? gpuSelected.toString() : "");
					
					controller.txtSocket.setText(dadosProcessadorSelected.getSocket());
					controller.txtFoundry.setText(dadosProcessadorSelected.getFoundry());
					controller.txtTamanhoChip.setText(dadosProcessadorSelected.getProcessSize().toString());
					controller.txtTransistors.setText(dadosProcessadorSelected.getTransistors().toString());
					controller.txtPackage.setText(dadosProcessadorSelected.getPackag());
					controller.txtTCaseMax.setText(dadosProcessadorSelected.gettCaseMax().toString());
					
					controller.txtNomeFabricante.setText(proc.getNomeFabricante());
					controller.txtDescrModelo.setText(proc.getNomeModelo());
					controller.txtMarket.setText(proc.getMarket());
					controller.txtReleased.setText(sdf.format(proc.getReleased()));
					controller.txtCodename.setText(proc.getCodename());
					controller.txtGeneration.setText(proc.getGeneration());
					controller.txtMemorySupport.setText(proc.getMemorySupport());
					controller.txtFrequencia.setText(proc.getFrequencia().toString());
					controller.txtTurboFrequencia.setText(proc.getTurbofrequencia().toString());
					controller.txtBaseClock.setText(proc.getBaseClock().toString());
					controller.txtMultiplicador.setText(proc.getMultiplicador().toString());
					controller.txtEhDesbloqueado.setText(proc.getMultiplDesbloqueado());
					controller.txtCores.setText(proc.getNroCores().toString());
					controller.txtThreads.setText(proc.getNroThreads().toString());
					controller.txtSMP.setText(proc.getSmp().toString());
					controller.txtTDP.setText(proc.getTdp().toString());
					
					controller.setNewOrEdit('E');
				});
	}
	
	
	@FXML
	public void onBtCopiarAction() {
		
		processadorSelected = tvProcessador.getSelectionModel().getSelectedItem();
		dadosProcessadorSelected = dadosProcessadorService.findById(processadorSelected.getIdDadosProcessador());
		
		Processadores proc = service.findByIdProcessadores(processadorSelected.getIdProcessador());
		Gpus graficoIntegrado = (proc.getGpu() != null) ? proc.getGpu() : null; 
		
		gpuSelected = gpuService.findById(graficoIntegrado.getIdGpu());
		
		LoadSeparatedScenne.loadSeparatedView("/gui/ProcessadoresEdit.fxml", 660, 460, "Editar Processador",
				(ProcessadorController controller) -> {
					controller.cboxDadosProcessador.setItems(listaDadosProcessador);
					controller.cboxGraficoIntegrado.setItems(listaGpus);
					
					controller.setProcessadorSelected(processadorSelected);
					controller.setDadosProcessadorSelected(dadosProcessadorSelected);
					
					controller.cboxDadosProcessador.getSelectionModel().select(dadosProcessadorSelected);
					controller.cboxDadosProcessador.getEditor().setText(dadosProcessadorSelected.toString());
					controller.cboxGraficoIntegrado.getSelectionModel().select(gpuSelected);
					controller.cboxGraficoIntegrado.getEditor().setText(gpuSelected.toString());
					
					controller.txtSocket.setText(dadosProcessadorSelected.getSocket());
					controller.txtFoundry.setText(dadosProcessadorSelected.getFoundry());
					controller.txtTamanhoChip.setText(dadosProcessadorSelected.getProcessSize().toString());
					controller.txtTransistors.setText(dadosProcessadorSelected.getTransistors().toString());
					controller.txtPackage.setText(dadosProcessadorSelected.getPackag());
					controller.txtTCaseMax.setText(dadosProcessadorSelected.gettCaseMax().toString());
					
					controller.txtNomeFabricante.setText(proc.getNomeFabricante());
					controller.txtDescrModelo.setText(proc.getNomeModelo());
					controller.txtMarket.setText(proc.getMarket());
					controller.txtReleased.setText(sdf.format(proc.getReleased()));
					controller.txtCodename.setText(proc.getCodename());
					controller.txtGeneration.setText(proc.getGeneration());
					controller.txtMemorySupport.setText(proc.getMemorySupport());
					controller.txtFrequencia.setText(proc.getFrequencia().toString());
					controller.txtTurboFrequencia.setText(proc.getTurbofrequencia().toString());
					controller.txtBaseClock.setText(proc.getBaseClock().toString());
					controller.txtMultiplicador.setText(proc.getMultiplicador().toString());
					controller.txtEhDesbloqueado.setText(proc.getMultiplDesbloqueado());
					controller.txtCores.setText(proc.getNroCores().toString());
					controller.txtThreads.setText(proc.getNroThreads().toString());
					controller.txtSMP.setText(proc.getSmp().toString());
					controller.txtTDP.setText(proc.getTdp().toString());
					
					controller.setNewOrEdit('C');
				});
	}
	
	@FXML
	public void onBtAtualizarAction() {
		System.out.println("Atualizando Grid...");
		this.updateTableView();
	}
	
	@FXML
	public void onBtExcluirAction() {
		processadorSelected = tvProcessador.getSelectionModel().getSelectedItem();
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir o jogo " + processadorSelected.getIdProcessador() + ": " 
		                     + processadorSelected.getNomeFabricante() + " - " 
		                     + processadorSelected.getNomeModelo() + "???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(service.findByIdProcessadores(processadorSelected.getIdProcessador()));
		} 

	}

	@FXML
	public void onBtSalvarAction() throws NumberFormatException, ParseException {
		service = new ProcessadorService();
		
		if (dadosProcessadorSelected == null ) {
			Alerts.showAlert("IOException", null, "Necessário definir Dados Processador", 
					AlertType.ERROR);
		}
		else {
			Processadores proc = new Processadores(null, 
					dadosProcessadorSelected, 
					txtNomeFabricante.getText(), 
					txtDescrModelo.getText(), 
					txtMarket.getText(), 
					sdf.parse(txtReleased.getText()), 
					txtCodename.getText(), 
					txtGeneration.getText(), 
					txtMemorySupport.getText(), 
					Double.parseDouble(txtFrequencia.getText()), 
					Double.parseDouble(txtTurboFrequencia.getText()), 
					Double.parseDouble(txtBaseClock.getText()), 
					Double.parseDouble(txtMultiplicador.getText()), 
					txtEhDesbloqueado.getText(), 
					Integer.parseInt(txtCores.getText()), 
					Integer.parseInt(txtThreads.getText()), 
					Integer.parseInt(txtSMP.getText()), 
					(gpuSelected != null) ? gpuService.findByIdGpu(gpuSelected.getIdGpu()) : null, 
					Double.parseDouble(txtTDP.getText()));
			
			if (newOrEdit == 'N' || this.newOrEdit == 'C') {
				System.out.println(proc.toString());
				service.inserir(proc);
			}
			else if (newOrEdit == 'E') {
				proc.setIdProcessador(processadorSelected.getIdProcessador());
				System.out.println(proc.toString());
				service.atualizar(proc);
			}
			else {
				throw new IllegalStateException("Variavel newOrEdit está null");
			}
			
			Stage stage = (Stage) btSalvar.getScene().getWindow();
			stage.close();
		}
	}
	
	@FXML
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}
	
	@FXML
	public void onCboxDadosProcessadorAction() {
		if (cboxDadosProcessador.getEditor().getText().split(":")[0].equals("")) {
			dadosProcessadorSelected = null;
		}
		else {
			dadosProcessadorSelected = dadosProcessadorService.findById(Integer.parseInt(cboxDadosProcessador.getEditor().getText().split(":")[0].trim()));
		}
		
		if (dadosProcessadorSelected != null) {
			txtSocket.setText(dadosProcessadorSelected.getSocket());
			txtFoundry.setText(dadosProcessadorSelected.getFoundry());
			txtTamanhoChip.setText(dadosProcessadorSelected.getProcessSize().toString());
			txtTransistors.setText(dadosProcessadorSelected.getTransistors().toString());
			txtPackage.setText(dadosProcessadorSelected.getPackag());
			txtTCaseMax.setText(dadosProcessadorSelected.gettCaseMax().toString());
		}
		else {
			txtSocket.setText(null);
			txtFoundry.setText(null);
			txtTamanhoChip.setText(null);
			txtTransistors.setText(null);
			txtPackage.setText(null);
			txtTCaseMax.setText(null);
		}
		
		listaDadosProcessador = FXCollections.observableArrayList(dadosProcessadorService.findAll());
	}
	
	@FXML
	public void onCboxGraficoIntegradoAction() {
		if (cboxGraficoIntegrado.getEditor().getText().split(":")[0].equals("")) {
			gpuSelected = null;
		}
		else {
			gpuSelected = gpuService.findById(Integer.parseInt(cboxGraficoIntegrado.getEditor().getText().split(":")[0].trim()));
		}
	}
	
	@FXML
	public void onCboxDadosProcessadorKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxDadosProcessador, listaDadosProcessador, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}

	@FXML
	public void onCboxGraficoIntegradoKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxGraficoIntegrado, listaGpus, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	// dados processador
	
	@FXML
	public void onBtDadosNovoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/DadosProcessadorEdit.fxml", 440, 149, "Editar Dados Processador",
				(ProcessadorDadosController controller) -> {
					controller.setNewOrEdit('E');
				});
		
	}
	
	@FXML
	public void onBtDadosEditarAction() {
		if (dadosProcessadorSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/DadosProcessadorEdit.fxml", 440, 150, "Editar Dados Processador",
					(ProcessadorDadosController controller) -> {
						controller.setDadosProcessadorSelected(dadosProcessadorSelected);
						controller.txtSocket.setText(dadosProcessadorSelected.getSocket());
						controller.txtFoundry.setText(dadosProcessadorSelected.getFoundry());
						controller.txtTamanhoChip.setText(dadosProcessadorSelected.getProcessSize().toString());
						controller.txtTransistors.setText(dadosProcessadorSelected.getTransistors().toString());
						controller.txtPackage.setText(dadosProcessadorSelected.getPackag());
						controller.txtTCaseMax.setText(dadosProcessadorSelected.gettCaseMax().toString());
						controller.setNewOrEdit('E');
					});
		}
	}
	
	@FXML
	public void onBtDadosCopiarAction() {
		if (dadosProcessadorSelected != null) {
			LoadSeparatedScenne.loadSeparatedView("/gui/DadosProcessadorEdit.fxml", 440, 150, "Copiar Dados Processador",
					(ProcessadorDadosController controller) -> {
						controller.setDadosProcessadorSelected(dadosProcessadorSelected);
						controller.txtSocket.setText(dadosProcessadorSelected.getSocket());
						controller.txtFoundry.setText(dadosProcessadorSelected.getFoundry());
						controller.txtTamanhoChip.setText(dadosProcessadorSelected.getProcessSize().toString());
						controller.txtTransistors.setText(dadosProcessadorSelected.getTransistors().toString());
						controller.txtPackage.setText(dadosProcessadorSelected.getPackag());
						controller.txtTCaseMax.setText(dadosProcessadorSelected.gettCaseMax().toString());
						controller.setNewOrEdit('C');
					});
		}
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<Processador> lista = service.findAll();
		tvProcessador.setItems(FXCollections.observableArrayList(lista));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("processadoresview.fxml")) {
			iniciarNodes();		
		}
		
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("processadoresedit.fxml")) {
			Constraints.setTextFieldInteger(txtCores);
			Constraints.setTextFieldInteger(txtThreads);
			Constraints.setTextFieldInteger(txtSMP);
			Constraints.setTextFieldDouble(txtFrequencia);
			Constraints.setTextFieldDouble(txtTurboFrequencia);
			Constraints.setTextFieldDouble(txtBaseClock);
			Constraints.setTextFieldDouble(txtMultiplicador);
			Constraints.setTextFieldDouble(txtCores);
		}
	}

	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	public DadosProcessador getDadosProcessadorSelected() {
		return dadosProcessadorSelected;
	}

	public void setDadosProcessadorSelected(DadosProcessador dadosProcessadorSelected) {
		this.dadosProcessadorSelected = dadosProcessadorSelected;
	}

	public PlacaDeVideo getGpuSelected() {
		return gpuSelected;
	}

	public void setGpuSelected(PlacaDeVideo gpuSelected) {
		this.gpuSelected = gpuSelected;
	}

	public Processador getProcessadorSelected() {
		return processadorSelected;
	}

	public void setProcessadorSelected(Processador processadorSelected) {
		this.processadorSelected = processadorSelected;
	}
	
}
