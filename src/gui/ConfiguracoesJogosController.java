package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import gui.util.ComboBoxAutoComplete;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

	private ConfiguracoesService configuracaoService = new ConfiguracoesService();
	private JogoService jogoService = new JogoService();

	private ObservableList<Jogos> jogosList = FXCollections.observableArrayList(jogoService.findAll());
	private ObservableList<Configuracoes> configuracoesList = FXCollections.observableArrayList(configuracaoService.findAll());
	
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
	private Button btCopiar;
	
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
			throw new IllegalStateException("Service est� null");
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
		LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesJogosEdit.fxml", 384, 130, "Inserir Nova Relação Configuração / Jogo",
				(ConfiguracoesJogosController controller) -> {
					controller.cboxConfiguracoes.setItems(configuracoesList);
					controller.cboxJogos.setItems(jogosList);
					
					controller.setNewOrEdit('N');
				});
	}
	
	public void onBtEditarAction() {
		configuracaoJogosSelected = tvConfiguracoesJogos.getSelectionModel().getSelectedItem();
		
		if (configuracaoJogosSelected != null) {
			System.out.println(configuracaoJogosSelected.toString());
			
			LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesJogosEdit.fxml", 384, 130, "Editar Relação Configuração / Jogo",
					(ConfiguracoesJogosController controller) -> {
						controller.setConfiguracaoJogoSelected(configuracaoJogosSelected);
						controller.cboxJogos.setItems(jogosList);
						controller.cboxJogos.getSelectionModel().select(jogoService.findById(configuracaoJogosSelected.getIdJogo()));
						controller.cboxJogos.getSelectionModel().select(jogosList.indexOf(jogoService.findById(configuracaoJogosSelected.getIdJogo())));
						controller.cboxConfiguracoes.getSelectionModel().select(configuracaoService.findById(configuracaoJogosSelected.getIdConfiguracao()));
						controller.cboxConfiguracoes.setItems(configuracoesList);
						controller.cboxConfiguracoes.getSelectionModel().select(configuracoesList.indexOf(configuracaoService.findById(configuracaoJogosSelected.getIdConfiguracaoJogo())));
						controller.setNewOrEdit('E');
					});
		}
	}
	
	public void onBtCopiarAction() {
		configuracaoJogosSelected = tvConfiguracoesJogos.getSelectionModel().getSelectedItem();
		
		if (configuracaoJogosSelected != null) {
			System.out.println(configuracaoJogosSelected.toString());
			
			LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesJogosEdit.fxml", 384, 130, "Copiar Relação Configuração / Jogo",
					(ConfiguracoesJogosController controller) -> {
						controller.setConfiguracaoJogoSelected(configuracaoJogosSelected);
						controller.cboxJogos.setItems(jogosList);
						controller.cboxJogos.getSelectionModel().select(jogoService.findById(configuracaoJogosSelected.getIdJogo()));
						controller.cboxJogos.getSelectionModel().select(jogosList.indexOf(jogoService.findById(configuracaoJogosSelected.getIdJogo())));
						controller.cboxConfiguracoes.getSelectionModel().select(configuracaoService.findById(configuracaoJogosSelected.getIdConfiguracao()));
						controller.cboxConfiguracoes.setItems(configuracoesList);
						controller.cboxConfiguracoes.getSelectionModel().select(configuracoesList.indexOf(configuracaoService.findById(configuracaoJogosSelected.getIdConfiguracaoJogo())));
						controller.setNewOrEdit('C');
					});
		}
	}
	
	public void onBtAtualizarAction() {
		System.out.println("Atualizando Grid...");
		this.updateTableView();
	}
	
	public void onBtExcluirAction() {
		configuracaoJogosSelected = tvConfiguracoesJogos.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Configuração de Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir a Relação Jogo / Configuração de jogo " 
		        + configuracaoJogosSelected.getNomeJogo() + " - " 
		        + configuracaoJogosSelected.getResolucaoAbrev().toString() + "p - "
				+ configuracaoJogosSelected.getQualidadeGrafica() + " ???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(new ConfiguracoesJogos(configuracaoJogosSelected.getIdConfiguracaoJogo(), null, null));
		} 
	}

	
	public void onBtSalvarAction() {
		service = new ConfiguracoesJogosService();
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		Jogos j = jogoService.findById(Integer.parseInt(cboxJogos.getEditor().getText().split("-")[0].trim()));
		Configuracoes conf = configuracaoService.findById(Integer.parseInt(cboxConfiguracoes.getEditor().getText().split("-")[0].trim()));

		ConfiguracoesJogos c = new ConfiguracoesJogos(null, j, conf);
		
		if (this.newOrEdit == 'N' || this.newOrEdit == 'C') {
			System.out.println(c.toString());
			service.inserir(c);
		} else if (this.newOrEdit == 'E') {
			c.setIdConfiguracaoJogo(this.configuracaoJogosSelected.getIdConfiguracaoJogo());
			System.out.println(c.toString());
			service.atualizar(c);
		} else {
			throw new IllegalStateException("Variavel newOrEdit esta null");
		}
		
		
		Stage stage = (Stage) btSalvar.getScene().getWindow();
		stage.close();
	}
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}
	
	public void onCBoxJogosKeyPressedAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxJogos, jogosList, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
	}
	
	public void onCBoxConfiguracoesKeyPressesAction() {
		ComboBoxAutoComplete.autoCompleteComboBoxPlus(cboxConfiguracoes, configuracoesList, (typedText, itemToCompare) -> itemToCompare.toString().toLowerCase().contains(typedText.toLowerCase()));
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
	
}
