package application;


//import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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
	
	public AppModel loginModel = new AppModel();

// Label Status usata per verificare lo stato della connessione nel form Login  (fx id=LblConnected)	
	@FXML private Label LblConnected;
	@FXML private TextField txtUsername;	
	@FXML private TextField txtPassword;
	@FXML private Button bntAnnulla;
	
		@Override
	public void initialize(URL location, ResourceBundle resources) {
		if(loginModel.isDbConnected()) {
			LblConnected.setText("Connesso");
		}else {
			LblConnected.setText("Non Connesso");
		}
		
	}
//Metodo collegato al bottone Login del form login.fxml
		public void Login (ActionEvent evt) {
			try {
				
				if ( (loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) && (txtUsername.getText()!=null) && (!txtUsername.getText().isEmpty()))
				{
				
					
					if (loginModel.amministratore(txtUsername.getText())) {
						
						try {
							System.out.println("Sono qui");
							((Node)evt.getSource()).getScene().getWindow().hide(); 
							Stage primaryStage = new Stage();
							FXMLLoader loader = new FXMLLoader();
							Pane root=loader.load(getClass().getResource("/application/Amministratore.fxml").openStream());
							AmministratoreController ammCtrl = (AmministratoreController)loader.getController();
							ammCtrl.getUserdata(txtUsername.getText());
							Scene scene = new Scene(root);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.show();	
						}catch(Exception e){
							e.printStackTrace();
						}
						
					}
				
					else {
					System.out.println("txtUsername.getText(): " + txtUsername.getText());
					LblConnected.setText("User: " + txtUsername.getText() + " login ok!");				
					((Node)evt.getSource()).getScene().getWindow().hide(); 
					Stage primaryStage = new Stage();
					FXMLLoader loader = new FXMLLoader();
					Pane root=loader.load(getClass().getResource("/application/Percorso.fxml").openStream());
//Dichiaro la classe PercorsoController e la istanzio facendo cast con loader per passare l'utente registrato
					PercorsoController percorsoCtrl = (PercorsoController)loader.getController();
					percorsoCtrl.getUserdata(txtUsername.getText());
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
					}
					
				} else {
					LblConnected.setText("utente o password errati");
				}
			} catch (SQLException e) {
				LblConnected.setText("utente o password errati");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		
 		public void Registrazione(ActionEvent evt) 
	    {			
			try {
				((Node)evt.getSource()).getScene().getWindow().hide(); 
				Stage primaryStage = new Stage();
				FXMLLoader loader = new FXMLLoader();
				Pane root=loader.load(getClass().getResource("/application/Registrazione.fxml").openStream());
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();		
			}catch(Exception e){
				}
		}
 		
}
