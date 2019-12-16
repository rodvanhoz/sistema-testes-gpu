package gui;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.ConfiguracoesService;
import models.entities.tables.Configuracoes;

public class ConfiguracoesController implements Initializable {
	
	private ConfiguracoesService service;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Configuracoes configuracaoSelected;
	private char newOrEdit;

	
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
	
	@FXML
	private ToolBar tbNavigtor;

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
	private TextField txtResolucao;

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
	private CheckBox cbNVidiaTec;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Constraints.getArqFXML(location.getFile()).toLowerCase().equals("configuracoesview.fxml")) {
			iniciarNodes();
		}
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
			throw new IllegalStateException("Service est� null");
		}
		
		List<Configuracoes> lista = service.findAll();
		tvConfiguracoes.setItems(FXCollections.observableArrayList(lista));
	}
	
	public void onBtNovoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesEdit.fxml", 384, 229, "Inserir Nova Configuração",
				(ConfiguracoesController controller) -> {
					controller.setNewOrEdit('N');
				});
	}

	public void onBtEditarAction() {
		configuracaoSelected = tvConfiguracoes.getSelectionModel().getSelectedItem();

		if (configuracaoSelected != null) {
			System.out.println(configuracaoSelected.toString());

			LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesEdit.fxml", 384, 229, "Editar Nova Configuração",
					(ConfiguracoesController controller) -> {
						controller.setConfiguracoesService(new ConfiguracoesService());
						controller.txtResolucao.setText(configuracaoSelected.getResolucaoDetalhe());
						controller.txtResolucaoAbrev.setText(configuracaoSelected.getResolucaoAbrev().toString());
						controller.txtApi.setText(configuracaoSelected.getApi());
						controller.txtQualidadeGrafica.setText(configuracaoSelected.getQualidadeGrafica());
						controller.txtAaliasing.setText(configuracaoSelected.getAa());
						controller.cbSsao.setSelected(Constraints.isChecked(configuracaoSelected.getSsao()));
						controller.cbFxaa.setSelected(Constraints.isChecked(configuracaoSelected.getFxaa()));
						controller.cbTaa.setSelected(Constraints.isChecked(configuracaoSelected.getTaa()));
						controller.cbRt.setSelected(Constraints.isChecked(configuracaoSelected.getRt()));
						controller.cbNVidiaTec.setSelected(Constraints.isChecked(configuracaoSelected.getNVidiaTec()));
						controller.setConfiguracaoSelected(this.configuracaoSelected);
						controller.setNewOrEdit('E');
					});
		}
	}
	
	public void onBtCopiarAction() {
		configuracaoSelected = tvConfiguracoes.getSelectionModel().getSelectedItem();

		if (configuracaoSelected != null) {
			System.out.println(configuracaoSelected.toString());

			LoadSeparatedScenne.loadSeparatedView("/gui/ConfiguracoesEdit.fxml", 384, 229, "Copiar Nova Configuração",
					(ConfiguracoesController controller) -> {
						controller.setConfiguracoesService(new ConfiguracoesService());
						controller.txtResolucao.setText(configuracaoSelected.getResolucaoDetalhe());
						controller.txtResolucaoAbrev.setText(configuracaoSelected.getResolucaoAbrev().toString());
						controller.txtApi.setText(configuracaoSelected.getApi());
						controller.txtQualidadeGrafica.setText(configuracaoSelected.getQualidadeGrafica());
						controller.txtAaliasing.setText(configuracaoSelected.getAa());
						controller.cbSsao.setSelected(Constraints.isChecked(configuracaoSelected.getSsao()));
						controller.cbFxaa.setSelected(Constraints.isChecked(configuracaoSelected.getFxaa()));
						controller.cbTaa.setSelected(Constraints.isChecked(configuracaoSelected.getTaa()));
						controller.cbRt.setSelected(Constraints.isChecked(configuracaoSelected.getRt()));
						controller.cbNVidiaTec.setSelected(Constraints.isChecked(configuracaoSelected.getNVidiaTec()));
						controller.setConfiguracaoSelected(this.configuracaoSelected);
						controller.setNewOrEdit('C');
					});
		}
	}

	public void onBtExcluirAction() {
		configuracaoSelected = tvConfiguracoes.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Configuração de Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir a configuração de jogo " + configuracaoSelected.getResolucaoAbrev().toString() + "p - "
				+ configuracaoSelected.getQualidadeGrafica() + " ???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(configuracaoSelected);
		} 
	}
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	public void onBtSalvarAction() {
		service = new ConfiguracoesService();
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}

		System.out.println("ResolucaoAbrev: " + txtResolucaoAbrev.getText() + " - Q. Grafica: " + txtQualidadeGrafica.getText());
		
		Configuracoes configuracao = new Configuracoes(null, 
				Integer.parseInt(txtResolucaoAbrev.getText()), 
				txtResolucao.getText(), 
				txtApi.getText(), 
				txtQualidadeGrafica.getText(), 
				Constraints.isSelected(cbSsao.isSelected()), 
				Constraints.isSelected(cbFxaa.isSelected()), 
				Constraints.isSelected(cbTaa.isSelected()),
				Constraints.isSelected(cbRt.isSelected()), 
				txtAaliasing.getText(), 
				Constraints.isSelected(cbNVidiaTec.isSelected()));
		
		if (this.newOrEdit == 'N' || this.newOrEdit == 'C') {
			service.inserir(configuracao);
		} else if (this.newOrEdit == 'E') {
			configuracao.setIdConfiguracao(this.configuracaoSelected.getIdConfiguracao());
			service.atualizar(configuracao);
		} else {
			throw new IllegalStateException("Variavel newOrEdit está null");
		}

		Stage stage = (Stage) btSalvar.getScene().getWindow();
		stage.close();
	}


	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	
	public Configuracoes getConfiguracaoSelected() {
		return configuracaoSelected;
	}

	public void setConfiguracaoSelected(Configuracoes configuracaoSelected) {
		this.configuracaoSelected = configuracaoSelected;
	}

	public void onBtAtualizarAction() {
		this.updateTableView();
	}
}
