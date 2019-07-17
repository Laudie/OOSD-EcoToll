package application.front.controller;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import application.model.PercorsoModel;


public class LetturaTargaController implements Initializable, Pedaggio {	
	
	@FXML ComboBox<String> comboDa;
	@FXML ComboBox<String> comboA;
	
	@FXML Label lblTarga;
	@FXML Label lblDataOraIn;
	@FXML Label lblDataOraOut;

	@FXML TextField txtTarga;
	@FXML TextField txtPedaggio;
	@FXML Button btnPedaggio;
	
	
	public PercorsoModel targaModel = new PercorsoModel();
	public PercorsoController perModel = new PercorsoController();
	
	//DA FARE
	//metodi per inserire la targa (su AppModel)
	//Calcolare il pedaggio sia IT che EU
	

@Override
	public void calcolaPedaggio() {
	
		LocalDateTime dataIn =  LocalDateTime.now();
		System.out.println("Current Time " + dataIn);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PercorsoModel.getDateFormatter());
	    String formatDateTimeIn = dataIn.format(formatter);
	    System.out.println("Dataora in :" +formatDateTimeIn);
	    lblDataOraIn.setText(formatDateTimeIn);
	    
	    LocalDateTime dataOut =  LocalDateTime.now().plusHours(2);
		System.out.println("Current Time " + dataOut);

	    String formatDateTimeOut = dataOut.format(formatter);
	    System.out.println("Dataora out :" +formatDateTimeOut);
	    lblDataOraOut.setText(formatDateTimeOut);
		
	    String targa="AQ120788";
	    String da="AQ Ovest";
	    String a="Roma Est";
	    double pedaggio=11.70;
	    txtTarga.setText(targa);
	    
	    try {
			if (targaModel.isTargaRegistered(targa, da, a, formatDateTimeIn, formatDateTimeOut, pedaggio)) {
				txtPedaggio.setText("Dati salvati correttamente");
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

@Override
public void initialize(URL location, ResourceBundle resources) {
	try {
		comboDa.setItems(FXCollections.observableArrayList(perModel.fillComboCasello()));
		comboA.setItems(FXCollections.observableArrayList(perModel.fillComboCasello()));		
	} catch (SQLException e) {			
		e.printStackTrace();
	}
}	

}
	

	
