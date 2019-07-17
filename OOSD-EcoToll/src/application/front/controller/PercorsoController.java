package application.front.controller;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import application.model.PercorsoModel;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;

public class PercorsoController implements Initializable, Pedaggio{
	
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
	
	
	public PercorsoModel perModel = new PercorsoModel();
	
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
		Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();		
	}catch(Exception e){
		}
	}
	
	public void pedaggioEU (ActionEvent evt){		
		try {
			System.out.println("Pedaggio EU fxml");
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/PercorsoEU.fxml").openStream());
			//Dichiaro la classe PercorsoController e la istanzio facendo cast con loader per passare l'utente registrato
			PercorsoEUController percorsoEUCtrl = (PercorsoEUController)loader.getController();
			percorsoEUCtrl.getUserdata(lblUser.getText());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		}catch(Exception e){};		
	}

	public List<String> fillComboCasello() throws SQLException {		
		PreparedStatement pst =null;
		ResultSet rst =null;		
		String qry="select casello from EcoToll.casello;";		
		List<String> lista = new ArrayList<String>();
		try {
			pst =PercorsoModel.connessione.prepareStatement(qry);
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
	
	public void getCombodataDa(ActionEvent event) {
		System.out.println(comboDa.getValue());
		String da=comboDa.getValue();		
		getLblComboDa().setText(da);
	}
	
	public void getCombodataA(ActionEvent event) {
		System.out.println(comboA.getValue());
		String a=comboA.getValue();		
		getLblComboA().setText(a);
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
	

	@Override
	public void calcolaPedaggio() {
		String classeV=this.lblClasseV.getText();
		String caselloDA=this.getLblComboDa().getText();
		String caselloA=this.getLblComboA().getText();
		if (classeV.isEmpty()||caselloDA.isEmpty()||caselloA.isEmpty()){
			PercorsoModel.infoBox("Devono essere scelti tutti i valori","OOSD - Laura Fabio Marco", "Errore di compilazione", "WARNING");
		}else{
			
			
		/*chiama il DB: 
			1) se i caselli sono nella stessa autostrada
			 	calcola la distanza e la moliplica per la tariffa autostradale
				ritorna il pedaggio=dist*tariffa
				
			2) se i caselli sono in autostrada diverse, simula la distanza minima
				calcola la distanza (dist1) tra l'autostrada in ingresso (autIn) e lo svincolo con l'autostrada in uscita (autOut)
				ped1=dist1*tariffa1
				calcola la distanza tra lo svincolo aut1 con l'autostrada in uscita (autOut)
				ped2=dist2*tariffa2
				return pedaggio=ped1+ped2				
		*/
			System.out.println("Test: " + lblClasseV.getText().substring(7, 8));
			double totale = perModel.pedaggioTotale(caselloDA,caselloA, lblClasseV.getText().substring(7, 8));
			
			String txtPedaggio="il costo per andare da " + caselloDA + " a " + caselloA + " con un veicolo di " + classeV + " è di " + totale +" euro" ;		
			this.getTxtPedaggio().setText(txtPedaggio);
		}	
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
