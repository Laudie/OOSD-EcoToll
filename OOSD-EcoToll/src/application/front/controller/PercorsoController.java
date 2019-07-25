package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.CaselloManager;
import application.controller.NormativaManager;
import application.controller.PercorsoManager;
import application.model.Casello;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PercorsoController implements Initializable{
	
	@FXML private Label lblNormativa;

	@FXML private ComboBox<Casello> comboDa;
	@FXML private ComboBox<Casello> comboA;
	

	@FXML private TextField txtPedaggio;
	@FXML private TextField txtTarga;
	
	@FXML private Button btnPedaggioIT;
	
		
	private NormativaManager nrmmgr = new NormativaManager();	
	
	private ObservableList<Casello> elencoCaselli = FXCollections.observableArrayList();
		
	public PercorsoController() {
		elencoCaselli.sorted();
		elencoCaselli.setAll(CaselloManager.getInstance().getAllCas());
	}
	
	
//metodo per inizializzare i componenti
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblNormativa.setText("Normativa vigente: "+ nrmmgr.getNormativa());
		comboDa.setItems(this.elencoCaselli);	
		comboA.setItems(this.elencoCaselli);		
	}
	
	public void logOut (ActionEvent evt){
	try {
		((Node)evt.getSource()).getScene().getWindow().hide(); 
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root=loader.load(getClass().getResource("/application/front/fxml/Login.fxml").openStream());
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}catch(Exception e){
		}
	}

	
	public void calcolaPedaggio() {
		
		txtPedaggio.setText(PercorsoManager.getInstance().calcolaPedaggio(txtTarga.getText(),comboDa.getValue(),comboA.getValue()));
	}
}
