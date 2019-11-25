package gui;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import gui.util.LoadSeparatedScenne;
import javafx.collections.FXCollections;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
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
		if (getArqFXML(url.getFile()).toLowerCase().equals("jogosview.fxml")) {
			iniciarNodes();
		}
		if (getArqFXML(url.getFile()).toLowerCase().equals("jogosedit.fxml")) {
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
		//tcIdJogo.setCellValueFactory(new PropertyValueFactory<>("IdJogo"));
		tcNomeJogo.setCellValueFactory(new PropertyValueFactory<>("NomeJogo"));
		tcDtLancto.setCellValueFactory(new PropertyValueFactory<>("DtLancto"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tvJogo.prefHeightProperty().bind(stage.heightProperty());

	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		List<Jogos> lista = service.findAll();
		tvJogo.setItems(FXCollections.observableArrayList(lista));

	}
	
	public void onBtNovoAction() {
		LoadSeparatedScenne.loadSeparatedView("/gui/JogosEdit.fxml", 400, 130, "Inserir Novo Jogo", 
			(JogoController controller) -> {
		});
	}
	
	public void onBtAtualizarAction() {
		this.updateTableView();
	}
	
	public void onBtEditarAction() {
		jogoSelected = tvJogo.getSelectionModel().getSelectedItem();
		
		if (jogoSelected != null) {
			System.out.println(jogoSelected.toString());
			
			LoadSeparatedScenne.loadSeparatedView("/gui/JogosEdit.fxml", 400, 130, "Editar Jogo", 
					(JogoController controller) -> {
					controller.setJogoService(new JogoService());
					controller.txtNomeJogo.setText(jogoSelected.getNomeJogo());
					controller.txtDtLancto.setText(sdf.format(jogoSelected.getDtLancto()));
				});
		}
	}
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
	    stage.close();
	}
	
	public void onBtSalvarAction() {
		service = new JogoService();
		if (service == null) {
			throw new IllegalStateException("Service está null");
		}
		
		try {
			System.out.println("Nome: " + txtNomeJogo.getText() + " - Data Lancto: " + sdf.parse(txtDtLancto.getText()));
			Jogos jogo = new Jogos(null, txtNomeJogo.getText(), sdf.parse(txtDtLancto.getText()));
			service.inserir(jogo);
			
			Stage stage = (Stage) btSalvar.getScene().getWindow();
		    stage.close();
		} 
		catch (ParseException e) {
			 Alerts.showAlert("IOException", "Erro no insert", e.getMessage(),
			 AlertType.ERROR);
			 //e.printStackTrace();
		}
	}

	private String getArqFXML(String path) {
		String[] p = path.split("/");
		return p[p.length - 1];
	}

}
