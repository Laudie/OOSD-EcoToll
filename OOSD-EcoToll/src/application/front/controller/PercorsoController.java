package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.CaselloManager;
import application.controller.NormativaManager;
import application.controller.PercorsoManager;
import application.model.Casello;
import application.model.Veicolo;
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

public class PercorsoController extends InfoController implements Initializable{
	
	@FXML private Label lblNormativa;

	@FXML private ComboBox<Casello> comboDa;
	@FXML private ComboBox<Casello> comboA;
	

	@FXML private TextField txtPedaggio;
	@FXML private TextField txtTarga;
	
	@FXML private Button btnPedaggioIT;
	
		
	private PercorsoManager prcmgr = new PercorsoManager();
	private NormativaManager nrmmgr = new NormativaManager();	
	
	private Veicolo veicolo = new Veicolo();
	private Casello caselloDa;
	private Casello caselloA;
	//private Autostrada a;
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
	
	public void getComboDa(ActionEvent evt) {
		caselloDa=comboDa.getValue();
		System.out.println("Altezza Da:" + caselloDa.getAltezza());
		System.out.println("tariffa comboDA:" + caselloDa.getNomecasello());
		System.out.println("Autostrada IN:" + caselloDa.getIdAutostrada());
		System.out.println("Tariffa IN: " + prcmgr.getAutostrada(caselloDa.getIdAutostrada()).getTariffa());
	}
	
	public void getComboA(ActionEvent evt) {
		caselloA=comboA.getValue();
		System.out.println("Altezza A:" + caselloA.getAltezza());		
		System.out.println("tariffa comboA:" + caselloA.getNomecasello());
		System.out.println("Autostrada OUT:" + caselloA.getIdAutostrada());		
		System.out.println("Tariffa OUT: " + prcmgr.getAutostrada(caselloA.getIdAutostrada()).getTariffa());
		}
	
	
	public void calcolaPedaggio() {
		
		if (!(prcmgr.isVeicolo(txtTarga.getText()))) {infoBox("veicolo non presente","Pedaggio","ERROR");}
		else {
			if (!(caselloA.getIdAutostrada().equals(caselloDa.getIdAutostrada()))) {
				infoBox("Autostrade differenti - da implementare","Autostrada","WARNING");
			}else {
				veicolo=prcmgr.getVeicolo(txtTarga.getText());
				int distanza=Math.abs(caselloDa.getAltezza()-caselloA.getAltezza());			
				double tariffa=prcmgr.getAutostrada(caselloDa.getIdAutostrada()).getTariffa();
					
						if (nrmmgr.getNormativa().equals("Italiana")){
							double pedaggio=distanza*tariffa*nrmmgr.getValoreClasse(veicolo.getIdclasseIT());
							System.out.println("Pedaggio IT:" + pedaggio);	
						}else {
							double pedaggio=distanza*tariffa*nrmmgr.getValoreClasse(veicolo.getIdclasseEU());
							System.out.println("Pedaggio EU:" + pedaggio);	
							}			
			}
		}
	}
		
		
		
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
	
	
	public void setTxtPedaggio(TextField txtPedaggio) {
		this.txtPedaggio = txtPedaggio;
	}

}
