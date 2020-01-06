package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.entities.services.ConfiguracoesService;
import models.entities.services.JogoService;
import models.entities.tables.Jogos;

public class JogoController implements Initializable {

	private JogoService service;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Jogos jogoSelected;
	private char newOrEdit;

	@FXML
	private TableView<Jogos> tvJogo;

	@FXML
	private TableColumn<Jogos, Integer> tcIdJogo;

	@FXML
	private TableColumn<Jogos, String> tcNomeJogo;

	@FXML
	private TableColumn<Jogos, Date> tcDtLancto;

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
	private TextField txtNomeJogo;

	@FXML
	private TextField txtDtLancto;

	@FXML
	private Button btSalvar;

	@FXML
	private Button btCancelar;

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		if (Constraints.getArqFXML(url.getFile()).toLowerCase().equals("jogosview.fxml")) {
			iniciarNodes();
		}
	}

	public void setJogoService(JogoService service) {
		this.service = service;
	}

	public Jogos getJogoSelected() {
		return jogoSelected;
	}

	public void setJogoSelected(Jogos jogoSelected) {
		this.jogoSelected = jogoSelected;
	}

	private void iniciarNodes() {
		// tcIdJogo.setCellValueFactory(new PropertyValueFactory<>("IdJogo"));
		tcNomeJogo.setCellValueFactory(new PropertyValueFactory<>("NomeJogo"));
		tcDtLancto.setCellValueFactory(new PropertyValueFactory<>("DtLancto"));

		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvJogo.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service est� null");
		}

		List<Jogos> lista = service.findAll();
		tvJogo.setItems(FXCollections.observableArrayList(lista));

	}

	@FXML
	public void onBtNovoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/JogosEdit.fxml", 400, 130, "Inserir Novo Jogo",
				(JogoController controller) -> {
					controller.setNewOrEdit('N');
				});
	}

	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	@FXML
	public void onBtAtualizarAction() {
		this.updateTableView();
	}

	@FXML
	public void onBtEditarAction() {
		jogoSelected = tvJogo.getSelectionModel().getSelectedItem();

		if (jogoSelected != null) {
			System.out.println(jogoSelected.toString());

			LoadSeparatedScenne.loadSeparatedView("/gui/JogosEdit.fxml", 400, 130, "Editar Jogo",
					(JogoController controller) -> {
						controller.setJogoService(new JogoService());
						controller.txtNomeJogo.setText(jogoSelected.getNomeJogo());
						controller.txtDtLancto.setText(sdf.format(jogoSelected.getDtLancto()));
						controller.setJogoSelected(this.jogoSelected);
						controller.setNewOrEdit('E');
					});
		}
	}

	@FXML
	public void onBtCopiarAction() {
		jogoSelected = tvJogo.getSelectionModel().getSelectedItem();

		if (jogoSelected != null) {
			System.out.println(jogoSelected.toString());

			LoadSeparatedScenne.loadSeparatedView("/gui/JogosEdit.fxml", 400, 130, "Copiar Jogo",
					(JogoController controller) -> {
						controller.setJogoService(new JogoService());
						controller.txtNomeJogo.setText(jogoSelected.getNomeJogo());
						controller.txtDtLancto.setText(sdf.format(jogoSelected.getDtLancto()));
						controller.setJogoSelected(this.jogoSelected);
						controller.setNewOrEdit('C');
					});
		}
	}
	
	@FXML
	public void onBtExcluirAction() {
		jogoSelected = tvJogo.getSelectionModel().getSelectedItem();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Deletar Jogo");
		alert.setHeaderText(null);
		alert.setContentText("Deseja realmente excluir o jogo " + jogoSelected.getNomeJogo() + "???");
		
		ButtonType btSim = new ButtonType("Sim");
		ButtonType btNao = new ButtonType("Não");
		alert.getButtonTypes().setAll(btSim, btNao);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == btSim){
		    service.remover(jogoSelected);
		} 
	}

	@FXML
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}

	@FXML
	public void onBtSalvarAction() {
		service = new JogoService();
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}

		try {
			System.out
					.println("Nome: " + txtNomeJogo.getText() + " - Data Lancto: " + sdf.parse(txtDtLancto.getText()));
			Jogos jogo = new Jogos(null, txtNomeJogo.getText(), sdf.parse(txtDtLancto.getText()));

			if (this.newOrEdit == 'N' || this.newOrEdit == 'C') {
				service.inserir(jogo);
			} else if (this.newOrEdit == 'E') {
				jogo.setIdJogo(this.jogoSelected.getIdJogo());
				service.atualizar(jogo);
			} else {
				throw new IllegalStateException("Variavel newOrEdit está null");
			}

			Stage stage = (Stage) btSalvar.getScene().getWindow();
			stage.close();
		} catch (ParseException e) {
			Alerts.showAlert("IOException", "Erro no insert", e.getMessage(), AlertType.ERROR);
			// e.printStackTrace();
		}
	}
	

}
