package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LetturaTargaController extends AbstractPercorso {	
	
	@FXML ComboBox<String> comboDa;
	@FXML ComboBox<String> comboA;
	
	@FXML Label lblTarga;
	@FXML Label lblDataOraIn;
	@FXML Label lblDataOraOut;

	@FXML TextField txtTarga;
	@FXML TextField txtPedaggio;
	@FXML Button btnPedaggio;
	
	public AppModel targaModel = new AppModel();
	//DA FARE
	//metodi per inserire la targa (su AppModel)
	//Calcolare il pedaggio sia IT che EU
	
	

	@Override
	public void calcolaPedaggio() {
	
		LocalDateTime dataIn =  LocalDateTime.now();
		System.out.println("Current Time " + dataIn);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(AppModel.getDateFormatter());
	    String formatDateTimeIn = dataIn.format(formatter);
	    System.out.println("Formatted Time :" +formatDateTimeIn);
	    lblDataOraIn.setText(formatDateTimeIn);
	    
	    LocalDateTime dataOut =  LocalDateTime.now().plusHours(2);
		System.out.println("Current Time " + dataOut);

	    String formatDateTimeOut = dataOut.format(formatter);
	    System.out.println("Formatted Time :" +formatDateTimeOut);
	    lblDataOraOut.setText(formatDateTimeOut);
		
	    String targa="AQ120788";
	    String da="AQ Ovest";
	    String a="AQ Est";
	    double pedaggio=18.70;
	    txtTarga.setText(targa);
	    
	    try {
			targaModel.isTargaRegistered(targa, da, a, formatDateTimeIn, formatDateTimeOut, pedaggio);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public void formPercorsoITEU(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
	

}
	

	
