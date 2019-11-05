package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.ProcessadorService;
import models.entities.views.Processador;

public class ProcessadorController implements Initializable {
	
	private ProcessadorService service;
	
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
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<Processador> lista = service.findAll();
		tvProcessador.setItems(FXCollections.observableArrayList(lista));
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciarNodes();		
	}

}
