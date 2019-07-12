package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RegistrazioneController implements Initializable{
	
	@FXML private TextField txtNome;
	@FXML private TextField txtCognome;
	@FXML private TextField txtUserName;
	@FXML private TextField txtPassword;
	
	
	@FXML private Button btnRegistrati;
	@FXML private Button btnAnnulla;
	
	@FXML private Label lblStatus;
	public AppModel regModel = new AppModel();
	
	public void registrazioneUtente(ActionEvent event) throws SQLException {
		System.out.println(txtUserName.getText());
		boolean esiste=regModel.isUserName(txtUserName.getText());
		System.out.print(esiste);
		if  (regModel.isUserName(txtUserName.getText())) {
			System.out.println(" esiste");
			lblStatus.setText("Utente presente");				
		}else{
			lblStatus.setText("Utente non presente");
			System.out.println(" NON esiste");
			boolean aggiungi=regModel.isRegistered(txtUserName.getText(), txtCognome.getText(), txtUserName.getText(), txtPassword.getText());
			if (aggiungi)
				lblStatus.setText("Utente aggiunto");
			    JOptionPane.showMessageDialog(null, "Benvenuto! Registrazione effettuata");
		}
		try {
			((Node)event.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/Login.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();		
		}catch(Exception e){
			
		}
	}	

	public void annulla (ActionEvent evt){
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/Login.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();		
		}catch(Exception e){
			}
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(regModel.isDbConnected()) {
			lblStatus.setText("Connesso");
		}else {
			lblStatus.setText("Non Connesso");
		}
		
	}
}
