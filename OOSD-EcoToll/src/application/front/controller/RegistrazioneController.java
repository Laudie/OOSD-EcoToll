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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrazioneController {
	
	@FXML private TextField txtNome;
	@FXML private TextField txtCognome;
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	@FXML private TextField txtRuolo;	
	
	@FXML private Button btnRegistrati;
	@FXML private Button btnAnnulla;	
	@FXML private Label lblStatus;
	
	private LoginManager lgnmgr = new LoginManager();
	private Login login = new Login();
	
	public void registrazioneUtente(ActionEvent event) {
		
		login.setPassword(txtPassword.getText());
		login.setUsername(txtUserName.getText());
		login.setRuolo(Integer.parseInt(txtRuolo.getText()));
		
		if (lgnmgr.addLogin(login)) {
			lblStatus.setText("Utente aggiunto");
	// JOptionPane.showMessageDialog(null, "Benvenuto " + txtUserName.getText() +"! Registrazione effettuata");
		}else {
			lblStatus.setText("ERRORE!");
			}			
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
