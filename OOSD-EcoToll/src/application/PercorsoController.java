package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class PercorsoController implements Initializable {
	
	@FXML private Label lblUser;
	@FXML private Label lblUserEU;
	@FXML private Label lblComboDa;
	@FXML private Label lblComboA;
	@FXML private Label lblClasseV;
	@FXML private Label lblTipoV;
	@FXML private Label lblFasciaO;
	
	@FXML private ComboBox<String> comboDa;
	@FXML private ComboBox<String> comboA;
	@FXML private ComboBox<String> comboTipoV;
	
	@FXML private RadioButton rbv1;
	@FXML private RadioButton rbv2;
	@FXML private RadioButton rbv3;
	@FXML private RadioButton rbv4;
	@FXML private RadioButton rbv5;
	
	@FXML private RadioButton rbfo1;
	@FXML private RadioButton rbfo2;
	@FXML private RadioButton rbfo3;
	
	@FXML private TextField txtPedaggioEU;
	@FXML private TextField txtPedaggioIT;
	
	@FXML private Button btnPedaggioIT;
	@FXML private Button btnPedaggioEU;
	
	
	
	
	//ObservableList<String> listaDaA= FXCollections.observableArrayList(fillCombo());
//metodo per inizializzare i componenti		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			comboDa.setItems(FXCollections.observableArrayList(fillComboCasello()));
			comboA.setItems(FXCollections.observableArrayList(fillComboCasello()));
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		//comboA.setItems(listaDaA);
	}
	
	
	public void getUserdata (String user) {	
	lblUser.setText("Ciao " + user);
		
	}
	
	 public void setUser (String user) {
		lblUser.setText(user);
		System.out.println("utente: " + user);
		
		}	
	
	public void logOut (ActionEvent evt){
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
	
	public void pedaggioEU (ActionEvent evt){
		String userloggedIn= lblUser.getText();
		System.out.println("stringa da label user: " + userloggedIn);
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/PercorsoEU.fxml").openStream());			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		}catch(Exception e){}	
		;			
		setUser(userloggedIn); //NON FUNZIONA!!!!!!
	}
	
	public void pedaggioIT (ActionEvent evt){
		String aaa= lblUser.getText();
		System.out.println("mlmlml: " + aaa);
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/Percorso.fxml").openStream());	
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();	
			setUser(aaa);
		}catch(Exception e){
			}
		}
	
	public List<String> fillComboCasello() throws SQLException {		
		PreparedStatement pst =null;
		ResultSet rst =null;		
		String qry="select casello from EcoToll.casello limit 15;";		
		List<String> lista = new ArrayList<String>();
		try {
			pst =AppModel.conection.prepareStatement(qry);
			rst = pst.executeQuery();
			while (rst.next()) {
				//System.out.println(rst.getString(1));
				//comboDa.getItems().addAll(rst.getString(1));				
				//comboDa.getItems().addAll(rst.getString("casello"));
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
	
	public void getCombodataDa(ActionEvent event) {
		System.out.println(comboDa.getValue());
		String da=comboDa.getValue();		
		lblComboDa.setText(da);
	}
	
	public void getCombodataA(ActionEvent event) {
		System.out.println(comboA.getValue());
		String a=comboA.getValue();		
		lblComboA.setText(a);
	}
	
	public void radioSelectVeicolo(ActionEvent event) {
		String msg="";
		if (rbv1.isSelected())
			msg+=rbv1.getText() + "\n";
		if (rbv2.isSelected())
			msg+=rbv2.getText() + "\n";
		if (rbv3.isSelected())
			msg+=rbv3.getText() + "\n";
		if (rbv4.isSelected())
			msg+=rbv4.getText() + "\n";
		if (rbv5.isSelected())
			msg+=rbv5.getText() + "\n";		
		lblClasseV.setText(msg);		
	}
	
	public void radioSelectFasciaO(ActionEvent event) {
		String msg="";
		if (rbfo1.isSelected())
			msg+=rbfo1.getText() + "\n";
		if (rbfo2.isSelected())
			msg+=rbfo2.getText() + "\n";
		if (rbfo3.isSelected())
			msg+=rbfo3.getText() + "\n";		
		lblFasciaO.setText(msg);		
	}
	
	public void calcolaPedaggioEU() {
		String classev=this.lblClasseV.getText();
		String caselloDA=this.lblComboDa.getText();
		String caselloA=this.lblComboA.getText();
		String fasciaO=this.lblFasciaO.getText();
		
		String pedaggioEU="il costo per andare da " + caselloDA + " a " + caselloA + " con un veicolo di " + classev + " nella fascia oraria " + fasciaO + " è di 10€";
		
		this.txtPedaggioEU.setText(pedaggioEU);		
		
	}
	
	public void calcolaPedaggioIT() {
		String classev=this.lblClasseV.getText();
		String caselloDA=this.lblComboDa.getText();
		String caselloA=this.lblComboA.getText();		
		
		String pedaggioIT="il costo per andare da " + caselloDA + " a " + caselloA + " con un veicolo di " + classev +  " è di 20€";
		
		this.txtPedaggioIT.setText(pedaggioIT);		
		
	}
}
