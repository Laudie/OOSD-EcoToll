package application.front.controller;

//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.LoginManager;
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
import javafx.event.ActionEvent;


//Codice per la parte Controller della classe Login
public class LoginController implements Initializable  {
	
	// Label Status usata per verificare lo stato della connessione nel form Login  (fx id=LblConnected)	
	@FXML private Label LblConnected;
	@FXML private TextField txtUsername;	
	@FXML private TextField txtPassword;
	@FXML private Button bntAnnulla;
	
	private LoginManager lgnmgr = new LoginManager();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
	
	
//Metodo collegato al bottone Login del form login.fxml
		public void Login (ActionEvent evt) throws IOException {
			
		System.out.println("user: " + txtUsername.getText() + "-" + txtPassword.getText());
		if (lgnmgr.isLogin(txtUsername.getText(), txtPassword.getText())) {					
			System.out.println("VEDIAMO CHE SUCCEDE");			
			if (lgnmgr.get(txtUsername.getText(), txtPassword.getText()).getRuolo()==1) {
					System.out.println("Sono qui amministratore");
					((Node)evt.getSource()).getScene().getWindow().hide(); 
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root=loader.load(getClass().getResource("/application/front/fxml/Amministratore.fxml").openStream());
					/*AmministratoreController ammCtrl = (AmministratoreController)loader.getController();
					ammCtrl.getUserdata(txtUsername.getText());*/
					Scene scene = new Scene(root);							
					primaryStage.setScene(scene);
					primaryStage.show();					
			}else{
					System.out.println("Sono qui user");
					//LblConnected.setText("User: " + txtUsername.getText() + " login ok!");				
					((Node)evt.getSource()).getScene().getWindow().hide(); 
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root=loader.load(getClass().getResource("/application/front/fxml/Percorso.fxml").openStream());
					PercorsoController percorsoCtrl = (PercorsoController)loader.getController();
					percorsoCtrl.getUserdata(txtUsername.getText());
					Scene scene = new Scene(root);					
					primaryStage.setScene(scene);
					primaryStage.show();
			}
			
		}else{	LblConnected.setText("User o password errati");		
		}
	}
		
 		public void Registrazione(ActionEvent evt) throws IOException 
	    {			
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/front/fxml/Registrazione.fxml").openStream());
				Scene scene = new Scene(root);				
				primaryStage.setScene(scene);
				primaryStage.show();		
		}
 		
}
