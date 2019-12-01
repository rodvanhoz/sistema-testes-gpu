package gui.util;

import java.io.IOException;
import java.util.function.Consumer;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoadSeparatedScenne {
	
	public synchronized static <T> void loadSeparatedView(String absoluteName, int width, int height, String title, Consumer<T> initializingAction) {

		try {

			FXMLLoader tet = new FXMLLoader(Main.class.getResource(absoluteName));
//			Parent loader = FXMLLoader.load(Main.class.getResource(absoluteName));
			Parent loader = tet.load();
			Stage stage = new Stage();
			Scene scene = new Scene(loader, width, height);
			stage.setScene(scene);
			//stage.setAlwaysOnTop(true);
			stage.initStyle(StageStyle.UTILITY);
			stage.setTitle(title);
			stage.show();
			
			
			T controller = tet.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
