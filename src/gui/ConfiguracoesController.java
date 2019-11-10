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
import models.entities.services.ConfiguracoesService;
import models.entities.tables.Configuracoes;

public class ConfiguracoesController implements Initializable {
	private ConfiguracoesService service;
	
	public void setConfiguracoesService(ConfiguracoesService service) {
		this.service = service;
	}

	@FXML
	private TableView<Configuracoes> tvConfiguracoes;

	@FXML
	private TableColumn<Configuracoes, Integer> tcIdConfiguracao;
	
	@FXML
	private TableColumn<Configuracoes, Integer> tcResolucaoAbrev;
	
	@FXML
	private TableColumn<Configuracoes, String> tcResolucaoDetalhe;
	
	@FXML
	private TableColumn<Configuracoes, String> tcApi;
	
	@FXML
	private TableColumn<Configuracoes, String> tcQualidadeGrafica;
	
	@FXML
	private TableColumn<Configuracoes, String> tcSsao;

	@FXML
	private TableColumn<Configuracoes, String> tcFxaa;

	@FXML
	private TableColumn<Configuracoes, String> tcTaa;

	@FXML
	private TableColumn<Configuracoes, String> tcRt;

	@FXML
	private TableColumn<Configuracoes, String> tcAa;
	
	@FXML
	private TableColumn<Configuracoes, String> tcNVidiaTec;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciarNodes();
	}

	private void iniciarNodes() {
		tcIdConfiguracao.setCellValueFactory(new PropertyValueFactory<>("IdConfiguracao"));
		tcResolucaoAbrev.setCellValueFactory(new PropertyValueFactory<>("ResolucaoAbrev"));
		tcResolucaoDetalhe.setCellValueFactory(new PropertyValueFactory<>("ResolucaoDetalhe"));
		tcApi.setCellValueFactory(new PropertyValueFactory<>("Api"));
		tcQualidadeGrafica.setCellValueFactory(new PropertyValueFactory<>("QualidadeGrafica"));
		tcSsao.setCellValueFactory(new PropertyValueFactory<>("Ssao"));
		tcFxaa.setCellValueFactory(new PropertyValueFactory<>("Fxaa"));
		tcTaa.setCellValueFactory(new PropertyValueFactory<>("Taa"));
		tcAa.setCellValueFactory(new PropertyValueFactory<>("Aa"));
		tcRt.setCellValueFactory(new PropertyValueFactory<>("Rt"));
		tcNVidiaTec.setCellValueFactory(new PropertyValueFactory<>("NVidiaTec"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvConfiguracoes.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<Configuracoes> lista = service.findAll();
		tvConfiguracoes.setItems(FXCollections.observableArrayList(lista));
	}
}
