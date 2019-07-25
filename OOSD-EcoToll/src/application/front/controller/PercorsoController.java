package application.front.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.controller.CaselloManager;
import application.controller.NormativaManager;
import application.controller.PedaggioManager;
import application.controller.PercorsoManager;
import application.model.Casello;
import application.model.Pedaggio;
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
	private PedaggioManager pdgmgr = new PedaggioManager();	
	
	private Casello caselloDa;
	private Casello caselloA;
	private Pedaggio pedaggio=new Pedaggio();
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
	
	public int distanza(Casello cIn, Casello cOut) {
		return Math.abs(cIn.getAltezza()-cOut.getAltezza());
	}
	
	public void calcolaPedaggio() {
		Veicolo veicolo;
		double costo;
		if (!(prcmgr.isVeicolo(txtTarga.getText()))) {infoBox("veicolo non presente","Pedaggio","ERROR");}
		else {
			/*
			  if ( (caselloA.equals(caselloDa)) || ! (caselloA.getAutostrada().equals(caselloDa.getAutostrada())) ){
			 
				infoBox("Autostrade differenti - da implementare","Autostrada","WARNING");
			}else {
			*/
				veicolo=prcmgr.getVeicolo(txtTarga.getText());
				
				double tariffa=prcmgr.getAutostrada(caselloDa.getIdAutostrada()).getTariffa();
				double moltIT=nrmmgr.getValoreClasse(veicolo.getIdclasseIT());
				double moltEU=nrmmgr.getValoreClasse(veicolo.getIdclasseIT());
						if (nrmmgr.getNormativa().equals("Italiana")){							
							costo=distanza(caselloDa, caselloA)*tariffa*moltIT;
							System.out.println("Pedaggio IT:" + costo);	
						}else {
							costo=distanza(caselloDa, caselloA)*tariffa*moltEU;
							System.out.println("Pedaggio EU:" + costo);
							}
				pedaggio.setCaselloIn(caselloDa.getNomecasello());
				pedaggio.setCaselloOut(caselloA.getNomecasello());
				pedaggio.setNormaVigente(nrmmgr.getNormativa());
				pedaggio.setTargaveicolo(veicolo.getTarga());
				pedaggio.setPedaggio(costo);			
				
				System.out.println("SALVA IL PEDAGGIO!!!");
				
				if (pdgmgr.addPedaggio(pedaggio)){
					infoBox("Pedaggio salvato","Pedaggio","INFORMATION");
				}else {infoBox("Pedaggio salvato","Pedaggio","ERROR");}
			}
		//}
	}


}
