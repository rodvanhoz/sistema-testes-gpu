package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.entities.services.DadosProcessadorService;
import models.entities.tables.DadosProcessador;

public class ProcessadorDadosController implements Initializable {
	
	private DadosProcessadorService dadosProcessadorService = new DadosProcessadorService();
	private DadosProcessador dadosProcessadorSelected;
	private char newOrEdit;

	@FXML
	protected TextField txtSocket;

	@FXML
	protected TextField txtFoundry;

	@FXML
	protected TextField txtTamanhoChip;

	@FXML
	protected TextField txtTransistors;

	@FXML
	protected TextField txtPackage;

	@FXML
	protected TextField txtTCaseMax;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button btCancelar;
	
	public void onBtCancelarAction() {
		Stage stage = (Stage) btCancelar.getScene().getWindow();
		stage.close();
	}
	
	public void onBtSalvarAction() {
		
		DadosProcessador dadosProcessador = new DadosProcessador(null, 
				txtSocket.getText(), 
				txtFoundry.getText(), 
				Integer.parseInt(txtTamanhoChip.getText()), 
				Double.parseDouble(txtTransistors.getText()), 
				txtPackage.getText(), 
				Double.parseDouble(txtTCaseMax.getText()));
		
		if (dadosProcessadorSelected != null) {
			dadosProcessador.setIdDadosProcessador(dadosProcessadorSelected.getIdDadosProcessador());
			System.out.println(dadosProcessador.toString());
			dadosProcessadorService.atualizar(dadosProcessador);
		}
		else {
			System.out.println(dadosProcessador.toString());
			dadosProcessadorService.inserir(dadosProcessador);
		}
	}
	
	public DadosProcessador getDadosProcessadorSelected() {
		return dadosProcessadorSelected;
	}

	public void setDadosProcessadorSelected(DadosProcessador dadosProcessadorSelected) {
		this.dadosProcessadorSelected = dadosProcessadorSelected;
	}

	public char getNewOrEdit() {
		return newOrEdit;
	}

	public void setNewOrEdit(char newOrEdit) {
		this.newOrEdit = newOrEdit;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
