package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.ComboBoxAutoComplete;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.ConfiguracoesJogosService;
import models.entities.services.ConfiguracoesService;
import models.entities.services.JogoService;
import models.entities.tables.Configuracoes;
import models.entities.tables.ConfiguracoesJogos;
import models.entities.tables.Jogos;
import models.entities.views.ConfiguracoesJogosW;

public class ConfiguracoesJogosController implements Initializable {

	private ConfiguracoesJogosService service;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private ConfiguracoesJogosW configuracaoJogosSelected;
	private char newOrEdit;

	
	public void setConfiguracoesJogosService(ConfiguracoesJogosService service) {
		this.service = service;
	}
	
	@FXML
	private TableView<ConfiguracoesJogosW> tvConfiguracoesJogos;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcNomeJogo;

	@FXML
	private TableColumn<ConfiguracoesJogosW, Date> tcDtLancto;

	@FXML
	private TableColumn<ConfiguracoesJogosW, Integer> tcResolucaoAbrev;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcResolucaoDetalhe;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcApi;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcQualidadeGrafica;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcSsao;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcFxaa;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcTaa;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcRt;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcAa;

	@FXML
	private TableColumn<ConfiguracoesJogosW, String> tcNVidiaTec;

	@FXML
	private TableColumn<ConfiguracoesJogosW, Integer> tcIdJogo;

	@FXML
	private TableColumn<ConfiguracoesJogosW, Integer> tcIdConfiguracao;

	@FXML
	private TableColumn<ConfiguracoesJogosW, Integer> tcIdConfiguracaoJogo;
	
	@FXML
	private Button btNovo;
	
	@FXML
	private Button btEditar;
	
	@FXML
	private Button btAtualizar;
	
	@FXML
	private Button btExcluir;
	
	// edit
	
	@FXML
	private ComboBox<Jogos> cboxJogos;
	
	@FXML
	private ComboBox<Configuracoes> cboxConfiguracoes;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("configuracoesjogosview.fxml")) {
			iniciarNodes();
		}
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<ConfiguracoesJogosW> lista = service.findAll();
		tvConfiguracoesJogos.setItems(FXCollections.observableArrayList(lista));
	}

	
	private void iniciarNodes() {
		tcNomeJogo.setCellValueFactory(new PropertyValueFactory<>("NomeJogo"));
		tcDtLancto.setCellValueFactory(new PropertyValueFactory<>("DtLancto"));
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
		tcIdConfiguracao.setCellValueFactory(new PropertyValueFactory<>("IdConfiguracao"));
		tcIdJogo.setCellValueFactory(new PropertyValueFactory<>("IdJogo"));
		tcIdConfiguracaoJogo.setCellValueFactory(new PropertyValueFactory<>("IdConfiguracaoJogo"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvConfiguracoesJogos.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void onBtNovoAction() {
		ConfiguracoesService configuracaoService = new ConfiguracoesService();
		JogoService jogoService = new JogoService();
		
		LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesJogosEdit.fxml", 384, 130, "Inserir Nova Relação Configuração / Jogo",
				(ConfiguracoesJogosController controller) -> {
					controller.cboxConfiguracoes.setItems(FXCollections.observableArrayList(configuracaoService.findAll()));
					controller.cboxJogos.setItems(FXCollections.observableArrayList(jogoService.findAll()));
					
					controller.setNewOrEdit('N');
				});
	}
	
	
	public void onBtSalvarAction() {
		service = new ConfiguracoesJogosService();
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}

		ConfiguracoesJogos c = new ConfiguracoesJogos(null, cboxJogos.getValue(), 
				cboxConfiguracoes.getValue());
		
		System.out.println(c.toString());
		service.inserir(c);
		
		Stage stage = (Stage) btSalvar.getScene().getWindow();
		stage.close();
	}
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}
	
	public void onCBoxJogosKeyPressedAction() {
		ComboBoxAutoComplete.getComboBoxValue(cboxJogos);
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxJogos, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	public void onCBoxConfiguracoesKeyPressesAction() {
		ComboBoxAutoComplete.getComboBoxValue(cboxConfiguracoes);
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxConfiguracoes, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}

	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	
	public ConfiguracoesJogosW getConfiguracaoJogosSelected() {
		return configuracaoJogosSelected;
	}

	public void setConfiguracaoJogoSelected(ConfiguracoesJogosW configuracaoJogosSelected) {
		this.configuracaoJogosSelected = configuracaoJogosSelected;
	}

	public void onBtAtualizarAction() {
		this.updateTableView();
	}

}
