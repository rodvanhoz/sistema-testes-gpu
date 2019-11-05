package gui;

import java.io.IOException;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import models.entities.services.DadosTesteService;
import models.entities.services.PlacaDeVideoService;
import models.entities.services.ProcessadorService;
import models.entities.tables.DadosProcessador;

public class MainViewController {

	@FXML
	private MenuItem menuItemProcessadores;

	@FXML
	private MenuItem menuItemPlacasDeVideo;

	@FXML
	private MenuItem menuItemTestes;

	@FXML
	private MenuItem menuItemJogos;

	@FXML
	private MenuItem menuItemConfiguracoes;

	@FXML
	private MenuItem menuItemSobre;

	@FXML
	public void onMenuItemProcessadoresAction() {
		loadView("/gui/ProcessadoresView.fxml", (ProcessadorController controller) -> {
			controller.setProcessadorService(new ProcessadorService());
			controller.updateTableView();
		});
	}

	@FXML
	public void onMenuItemPlacasDeVideoAction() {
		loadView("/gui/PlacasDeVideoView.fxml", (PlacaDeVideoController controller) -> {
			controller.setPlacaDeVideoService(new PlacaDeVideoService());
			controller.updateTableView();
		});

	}

	@FXML
	public void onMenuItemTestesAction() {
		loadView("/gui/TestesView.fxml", (DadosTesteController controller) -> {
			controller.setDadosTesteService(new DadosTesteService());
			controller.updateTableView();
		});
	}

	@FXML
	public void onMenuItemJogosAction() {

	}

	@FXML
	public void onMenuItemConfiguracoesAction() {

	}

	@FXML
	public void onMenuItemSobreAction() {

	}

	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
		} catch (IOException e) {
			Alerts.showAlert("IOException", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
