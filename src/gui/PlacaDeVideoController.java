package gui;

import java.net.URL;
import java.util.Date;
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
import models.entities.services.PlacaDeVideoService;
import models.entities.views.PlacaDeVideo;

public class PlacaDeVideoController implements Initializable {

	private PlacaDeVideoService service;
	
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
		iniciarNodes();
		
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<PlacaDeVideo> lista = service.findAll();
		tvPlacaDeVideo.setItems(FXCollections.observableArrayList(lista));
	}


}
