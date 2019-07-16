package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
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
			Pane root=loader.load(getClass().getResource("/application/Percorso.fxml").openStream());
			//Dichiaro la classe PercorsoController e la istanzio facendo cast con loader per passare l'utente registrato
			PercorsoController percorsoEUCtrl = (PercorsoController)loader.getController();
			percorsoEUCtrl.getUserdata(lblUser.getText());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
			AppModel.infoBox("Devono essere scelti tutti i valori","OOSD - Laura Fabio Marco", "Impossibile calcolare il pedaggio");
		}else{
			String pedaggio="il costo per andare da " + caselloDA + " a " + caselloA + " con un veicolo di " + classeV + " nella fascia oraria " + fasciaO + " con un veicolo a " + tipoV + " è di 10€";		
			this.getTxtPedaggio().setText(pedaggio);
		}
		
	}
	
	public void testTarga (ActionEvent evt){
		try {
			//((Node)evt.getSource()).getScene().getWindow().hide(); 
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root=loader.load(getClass().getResource("/application/LetturaTarga.fxml").openStream());
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();			
		}catch(Exception e){
			}
		}


}
