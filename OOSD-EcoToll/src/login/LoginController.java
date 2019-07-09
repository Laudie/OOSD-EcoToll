package login;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class LoginController {

	public LoginModel loginModel = new LoginModel();
	
	@FXML
	private Label isConnected;
	
	@FXML
	private Label registrato;
	
	
	@FXML
	private TextField txtUsername;
	
	
	@FXML
	private TextField txtPassword;
	
	@FXML
	private TextField txtRUsername;
	
	
	@FXML
	private TextField txtRPassword;
	
	
	@FXML
	private TextField txtRNome;
	
	
	@FXML
	private TextField txtRCognome;
	
	
	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(loginModel.IsConnected()) {
			isConnected.setText("Connesso");
		}else {
			isConnected.setText("Non Connesso");
		}
	}*/
	
	public void Login (ActionEvent event) {
		try {
		if (loginModel.isLogin(txtUsername.getText(), txtPassword.getText())) {
			isConnected.setText("utente loggato");
		}else { isConnected.setText("utente errato");}
		} catch (SQLException e) {
			 isConnected.setText("utente errato");
			 e.printStackTrace();
		}
	}
	
	public void Registrati(ActionEvent event) {
		try {
			((Node)event.getSource()).getScene().getWindow().hide();
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/Register.fxml").openStream());
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		}catch(IOException e) {
			e.printStackTrace();;
		}
	}

	public void isRegistered(ActionEvent event) {
		try {
			loginModel.isRegistered(txtRNome.getText(),txtRCognome.getText(),txtRUsername.getText(),txtRPassword.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			if (loginModel.isRegistered(txtRNome.getText(),txtRCognome.getText(),txtRUsername.getText(),txtRPassword.getText())) {
				registrato.setText("utente registrato con successo");
			}else { registrato.setText("utente non registrato");}
			} catch (SQLException e) {
				 registrato.setText("Errore");
				 e.printStackTrace();
			}
	
	}*/
}
}
