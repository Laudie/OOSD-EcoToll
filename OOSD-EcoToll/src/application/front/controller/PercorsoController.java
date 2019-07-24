package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.CaselloManager;
import application.controller.NormativaManager;
import application.controller.PercorsoManager;
import application.model.Autostrada;
import application.model.Casello;
import application.model.Veicolo;
import javafx.beans.value.ObservableStringValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;

public class PercorsoController implements Initializable{
	
	@FXML private Label lblNormativa;

	@FXML private ComboBox<Casello> comboDa;
	@FXML private ComboBox<Casello> comboA;
	

	@FXML private TextField txtPedaggio;
	@FXML private TextField txtTarga;
	
	@FXML private Button btnPedaggioIT;
	
	@FXML private ToggleGroup classeVeicolo;
	
	
	private PercorsoManager prcmgr = new PercorsoManager();
	//private VeicoloManager vclmgr = new VeicoloManager();
	private NormativaManager nrmmgr = new NormativaManager();	
	
	private Veicolo veicolo  = new Veicolo();
	private Casello caselloDa;
	private Casello caselloA;
	private Autostrada a;
	private ObservableList<Casello> elencoCaselli = FXCollections.observableArrayList();
	
	
	
	int c1;
	int c2;
	
	public PercorsoController() {
		elencoCaselli.setAll(CaselloManager.getInstance().getAllCas());
	}
	
	
//metodo per inizializzare i componenti
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lblNormativa.setText("Normativa vigente: "+ nrmmgr.getNormativa());
		comboDa.setItems(this.elencoCaselli);	
		comboA.setItems(this.elencoCaselli);	
		
	}
	

	public void getUserdata (String user) {	
	//lblUser.setText(user);
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
	
/*
	public List<String> fillComboCasello() throws SQLException {		
		return null;		
	}
	
*/
	
	public void getComboDa(ActionEvent evt) {
		caselloDa=comboDa.getValue();
		c2=comboDa.getValue().getAltezza();
		System.out.println("dento combo DA:"  + c2);
	}
	
	public void getComboA(ActionEvent evt) {
		caselloA=comboA.getValue();
		c1=comboA.getValue().getAltezza();
		System.out.println("dento combo A:"  + c1);
		System.out.println("tariffa comboA:" + caselloA.getNomecasello());
		System.out.println("IdA:" + caselloA.getIdAutostrada());
		a=prcmgr.getAuto(caselloA.getIdAutostrada());
		double x=a.getTariffa();
		System.out.println("Tariffa: " + x);
		}
	
	public void calcolaPedaggio() {
		
		 String normativa = NormativaManager.getInstance().getNormativa();
		
		//Da ERRORE!
		 veicolo=prcmgr.getVeicolo(txtTarga.getText());
		
		int distanza=Math.abs(caselloDa.getAltezza()-caselloA.getAltezza());
		System.out.println("Distanza: " + distanza + "classe: " + veicolo.getIdclasse() + "Tipo: " + veicolo.getIdtipo());
		
		
		
		//if (classeV.isEmpty()||caselloDA.isEmpty()||caselloA.isEmpty()){
//			PercorsoModel.infoBox("Devono essere scelti tutti i valori","OOSD - Laura Fabio Marco", "Errore di compilazione", "WARNING");
		//}else{
			
/*Verifica la normantiva scelta
			
			Italiana pedaggio = distanza * tariffa
			Europea pedaggio = distanza* tariffa* tipo *fasciaOraria
			
			1) se i caselli sono nella stessa autostrada
			 	calcola la distanza e la moliplica per la tariffa autostradale
				ritorna il pedaggio
				
			2) se i caselli sono in autostrada diverse, simula la distanza minima
				calcola la distanza (dist1) tra l'autostrada in ingresso (autIn)
				e lo svincolo con l'autostrada in uscita (autOut)
				e calcolca pedaggio1
				calcola la distanza tra lo svincolo aut1 con l'autostrada in uscita (autOut)
				calcola pedaggio2
				return pedaggio=ped1+ped2				
		*/
		//}	
	}


	public void setTxtPedaggio(TextField txtPedaggio) {
		this.txtPedaggio = txtPedaggio;
	}

}
