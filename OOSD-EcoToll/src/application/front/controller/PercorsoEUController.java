package application.front.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import application.model.PercorsoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class PercorsoEUController extends PercorsoController {
	@FXML   private Label lblTipoV;
	@FXML   private Label lblFasciaO;	
	@FXML	private ComboBox<String> comboTipoV;
	@FXML	private Label lblUser;
	@FXML	private Button btnPedaggioEU;
	@FXML	private ToggleGroup fasciaOraria;
	@FXML	private RadioButton rbfo1;
	@FXML	private RadioButton rbfo2;
	@FXML	private RadioButton rbfo3;

//un altro modo per popolare la combobox, va bene se i dati non variano
	ObservableList<String> listaVeicoli= FXCollections.observableArrayList("Benzina", "Metano", "GPL", "Elettrica", "Ibrida");
	
	public void fillComboTipoV() {
		if (comboTipoV.getItems().isEmpty())
			comboTipoV.setItems(listaVeicoli);
	}

	public void getComboTipoV(ActionEvent event) {
		String a=comboTipoV.getValue();		
		lblTipoV.setText(a);
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
	
	public void percorsoIT (ActionEvent evt){
		try {
			((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/Percorso.fxml").openStream());
			//Dichiaro la classe PercorsoController e la istanzio facendo cast con loader per passare l'utente registrato
			PercorsoController percorsoCtrl = (PercorsoController)loader.getController();
			percorsoCtrl.getUserdata(lblUser.getText());
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		}catch(Exception e){
			}
		}
	
	@Override
	public void calcolaPedaggio() {
		String classeV=this.getLblClasseV().getText();
		String caselloDA=this.getLblComboDa().getText();
		String caselloA=this.getLblComboA().getText();
		String fasciaO=this.lblFasciaO.getText();
		String tipoV=this.lblTipoV.getText();
		if (classeV.isEmpty()||caselloDA.isEmpty()||caselloA.isEmpty()||tipoV.isEmpty()){
			PercorsoModel.infoBox("Devono essere scelti tutti i valori","OOSD - Laura Fabio Marco", "Impossibile calcolare il pedaggio", "WARNING");
		}else{
			double totale = perModel.pedaggioTotale(caselloDA,caselloA, getLblClasseV().getText().substring(7, 8), lblFasciaO.getText().substring(0, 2), lblTipoV.getText());
			String pedaggio="il costo per andare da " + caselloDA + " a " + caselloA + " con un veicolo di " + classeV + " nella fascia oraria " + fasciaO + " con un veicolo a " + tipoV + " è di " + totale +" euro";		
			this.getTxtPedaggio().setText(pedaggio);
		}
		
	}
	
	public void testTarga (ActionEvent evt){
		try {
			//((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/front/fxml/LetturaTarga.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		}catch(Exception e){
			}
		}
	
}
