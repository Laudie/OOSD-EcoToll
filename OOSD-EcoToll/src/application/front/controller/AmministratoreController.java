package application.front.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.controller.CaselloManager;
import application.controller.NormativaManager;
import application.model.Casello;
import application.modelold.AppModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AmministratoreController implements Initializable {

	@FXML private ComboBox<Casello> comboCasello;
	@FXML private Label lblUser;
	@FXML private Label lblsuccesso;
	@FXML private Label lblNormativa;
	@FXML private ComboBox<String> comboNormativa;
	
	private ObservableList<Casello> elencoCaselli = FXCollections.observableArrayList();
	private ObservableList<String> normative = FXCollections.observableArrayList("Italiana", "Europea");

	private Casello casellodaeliminare;
	

	public AmministratoreController() {
		elencoCaselli.setAll(CaselloManager.getInstance().getAllCas());
	}

	@Override

	public void initialize(URL location, ResourceBundle resources) {	
		comboCasello.setItems(this.elencoCaselli);		
		//prenderà la normativa sul db e la inserisce nella label
		String normativa=NormativaManager.getInstance().getNormativa();
		lblNormativa.setText(normativa);
		comboNormativa.setItems(normative);
	}


	public void aggiungiCasello(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Casello.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();		
		}catch(Exception e){
			}
	}
	
	public void eliminaCasello(ActionEvent event) {
		casellodaeliminare=comboCasello.getValue();
		if (CaselloManager.getInstance().delete(casellodaeliminare)) {
			lblsuccesso.setText("Casello eliminato con successo");
			elencoCaselli.setAll(CaselloManager.getInstance().getAllCas());
		}else {
			lblsuccesso.setText("Impossibile eliminare il casello");
		}
	}

	
	public void getUserdata (String user) {	
		lblUser.setText(user);
		}	
	
	public void logOut (ActionEvent evt){
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();		
		}catch(Exception e){
			}
		}
		
	public void percorso(ActionEvent evt) throws IOException {
	((Node)evt.getSource()).getScene().getWindow().hide(); 
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader();
	Pane root=loader.load(getClass().getResource("/application/front/fxml/Percorso.fxml").openStream());
//Dichiaro la classe PercorsoController e la istanzio facendo cast con loader per passare l'utente registrato
	/*PercorsoController percorsoCtrl = (PercorsoController)loader.getController();
	percorsoCtrl.getUserdata(lblUser.getText());*/
	Scene scene = new Scene(root);
	//scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public void aggiornaNormativa(ActionEvent evt) {
		//CAMBIA NORMATIVA
		String normativa=comboNormativa.getValue();
		if(normativa.equals(NormativaManager.getInstance().getNormativa())) {			 
		} else {
			NormativaManager.getInstance().setNormativa(normativa);
		lblNormativa.setText(normativa);
		 JOptionPane.showMessageDialog(null, "Normativa Aggiornata");			
		}
		
	}
}
