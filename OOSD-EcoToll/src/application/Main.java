package application;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Progetto EcoTool per l'easame di Object Oriented Software
 * @author Laura Fabio Marco
 * 
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {			
			Parent root=FXMLLoader.load(getClass().getResource("/application/front/fxml/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
