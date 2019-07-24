package application.front.controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import application.controller.LoginManager;
import application.model.Login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrazioneController {
	
	@FXML private TextField txtNome;
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	
	@FXML private Button btnRegistrati;
	@FXML private Button btnAnnulla;	
	
	private Login login = new Login();
	
	public void registrazioneUtente(ActionEvent event) throws IOException {
		
		login.setPassword(txtPassword.getText());
		login.setUsername(txtUserName.getText());
		
		if (LoginManager.getInstance().addLogin(login)) {
			JOptionPane.showMessageDialog(null, "Benvenuto " + txtUserName.getText() +"! Registrazione effettuata");
		}else {
			JOptionPane.showMessageDialog(null, "Ops! Qualcosa è andato storto!");
			}
		((Node)event.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();	
	}	

	public void annulla (ActionEvent evt) throws IOException{
		
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();		
		
		}
	
}
