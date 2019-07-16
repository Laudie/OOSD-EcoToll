package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class AbstractPercorso implements Initializable, Pedaggio{

	public AbstractPercorso() {
		// TODO Auto-generated constructor stub
	}
	@FXML private Label lblUser;
	@FXML private Label lblComboDa;
	@FXML private Label lblComboA;
	@FXML private Label lblClasseV;

	@FXML private ComboBox<String> comboDa;
	@FXML private ComboBox<String> comboA;
	@FXML private ComboBox<String> comboTipoV;
	
	@FXML private RadioButton rbv1;
	@FXML private RadioButton rbv2;
	@FXML private RadioButton rbv3;
	@FXML private RadioButton rbv4;
	@FXML private RadioButton rbv5;

	@FXML private TextField txtPedaggio;
	
	@FXML private Button btnPedaggioIT;
	
	@FXML private ToggleGroup classeVeicolo;
	
//metodo per inizializzare i componenti
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			comboDa.setItems(FXCollections.observableArrayList(fillComboCasello()));
			comboA.setItems(FXCollections.observableArrayList(fillComboCasello()));		
		} catch (SQLException e) {			
			e.printStackTrace();
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
		Pane root=loader.load(getClass().getResource("/application/Login.fxml").openStream());
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();		
	}catch(Exception e){
		}
	}
	
	public abstract void formPercorsoITEU (ActionEvent evt);

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
	
	public void getComboDa(ActionEvent event) {
		System.out.println(comboDa.getValue());
		String casello=comboDa.getValue();		
		getLblComboDa().setText(casello);
	}
	
	public void getComboA(ActionEvent event) {
		System.out.println(comboA.getValue());
		String casello=comboA.getValue();		
		getLblComboA().setText(casello);
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

	public Label getLblClasseV() {
		return lblClasseV;
	}

	public void setLblClasseV(Label lblClasseV) {
		this.lblClasseV = lblClasseV;
	}
	
	public Label getLblComboDa() {
		return lblComboDa;
	}

	public void setLblComboDa(Label lblComboDa) {
		this.lblComboDa = lblComboDa;
	}

	public Label getLblComboA() {
		return lblComboA;
	}

	public void setLblComboA(Label lblComboA) {
		this.lblComboA = lblComboA;
	}

	public TextField getTxtPedaggio() {
		return txtPedaggio;
	}

	public void setTxtPedaggio(TextField txtPedaggio) {
		this.txtPedaggio = txtPedaggio;
	}

}
