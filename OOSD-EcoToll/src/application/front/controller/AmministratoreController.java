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

	@FXML private ComboBox<String> comboCasello;
	@FXML private Label lblUser;
	@FXML private Label lblsuccesso;
	@FXML private Label lblNormativa;
	@FXML private ComboBox<String> comboNormativa;
	
	
	public AppModel caselloModel = new AppModel();
	ObservableList<String> normative = FXCollections.observableArrayList("Italiana", "Europea");
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			comboCasello.setItems(FXCollections.observableArrayList(fillComboCasello()));
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		//prenderà la normativa sul db e la inserisce nella label
		lblNormativa.setText("Italiana");
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
	
	public void eliminaCasello(ActionEvent event) throws SQLException {		
		String casello=comboCasello.getValue();
		if(caselloModel.eliminaCasello(casello)) {
			lblsuccesso.setText("Casello eliminato con successo");
			try {
				comboCasello.setItems(FXCollections.observableArrayList(fillComboCasello()));
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog(null, "Casello eliminato con successo");			 
		} else {
		lblsuccesso.setText("Impossibile eliminare il casello");
		 JOptionPane.showMessageDialog(null, "Impossibile eliminare il casello");			
		}
	}
	
	
	public List<String> fillComboCasello() throws SQLException {		
		PreparedStatement pst =null;
		ResultSet rst =null;		
		String qry="select casello from EcoToll.casello;";		
		List<String> lista = new ArrayList<String>();
		try {
			pst =AppModel.connessione.prepareStatement(qry);
			rst = pst.executeQuery();
			while (rst.next()) {
				lista.add(rst.getString("casello"));						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			rst.close();
		}
		return lista;		
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
	PercorsoController percorsoCtrl = (PercorsoController)loader.getController();
	percorsoCtrl.getUserdata(lblUser.getText());
	Scene scene = new Scene(root);
	//scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
	primaryStage.setScene(scene);
	primaryStage.show();
	}
	
	public void aggiornaNormativa(ActionEvent evt) {
		//CAMBIA NORMATIVA
		System.out.println("aggiorna la normativa");
		
	}
}
