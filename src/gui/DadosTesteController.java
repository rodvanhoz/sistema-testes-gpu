package gui;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.DadosTesteService;
import models.entities.views.DadosTeste;

public class DadosTesteController implements Initializable {

	private DadosTesteService service;

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

	private ObservableList<DadosTeste> lista;
	
	public void setDadosTesteService(DadosTesteService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		iniciarNodes();
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

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<DadosTeste> lista = service.findAll();
		tvDadosTeste.setItems(FXCollections.observableArrayList(lista));
	}
}
