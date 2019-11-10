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
import models.entities.services.JogoService;
import models.entities.tables.Jogos;

public class JogoController implements Initializable {

	private JogoService service;
	
	@FXML
	private TableView<Jogos> tvJogo;

	@FXML
	private TableColumn<Jogos, Integer> tcIdJogo;
	
	@FXML
	private TableColumn<Jogos, String> tcNomeJogo;
	
	@FXML
	private TableColumn<Jogos, Date> tcDtLancto;
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		iniciarNodes();
	}
	
	public void setJogoService(JogoService service) {
		this.service = service;
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


}
