package application.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PercorsoModel {
	public static Connection connessione;
	// Formato dataOra
	private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static final String TARGA_VEICOLO = "select * from veicolo where targa=?;";
	private static final String PASSAGGIO_VEICOLO = "insert into EcoToll.storico (targa, da, a, dataoraIn, dataoraOut, pedaggio) value (?,?,?,?,?,?);";
	private static final String DATI_CASELLO = "select * from tariffa where casello=?;";
	private static final String DATI_SVINCOLO = "select km from svincolo where autostradaIn=? and autostradaOut=?;";
	
	
	public PercorsoModel() {
		connessione = mysqlConnection.Connector();
		if (connessione == null) System.exit(1);
	}

	/* Metodo per simulare lettura targa (esempio telepass)
	 * Legge la targa dal DB e prende le info del veicolo per il calcolo del pedaggio */
	
	public boolean isTarga(String targa) throws SQLException {	
		PreparedStatement pst = null;
		ResultSet rst = null;		
		try {
			pst = connessione.prepareStatement(TARGA_VEICOLO);
			pst.setString(1, targa); 			
			rst = pst.executeQuery();
			if (rst.next()) {
				return true;
			}else {
				return false;
			}			
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			pst.close();
			rst.close();
		}		
	}

	//  Salva sul DB il transito del veicolo con tutte le info
	public boolean isTargaRegistered(String targa, String da, String a, String dataoraIn, String dataoraOut, double pedaggio) throws SQLException {
		
		PreparedStatement pst = null;	
		try {
			pst=connessione.prepareStatement(PASSAGGIO_VEICOLO);
			pst.setString(1, targa);
			pst.setString(2, da);
			pst.setString(3, a);
			pst.setString(4, dataoraIn);
			pst.setString(5, dataoraOut);
			pst.setDouble(6, pedaggio);			
			int count=pst.executeUpdate();
			System.out.println("update: " + count);	
			if (count==1)
				return true;
			else
				return false;		
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			pst.close();			
		}		
	
	}

	public double pedaggioTotale(String Da, String A, String classeV) {
		
		double tariffa1=0.0,tariffa2=0.0,classePercento=0.0;		
		int km1=0,km2=0,altezzaIn=0, altezzaOut=0;		
		String ingresso=null,uscita=null; 
		
		switch (classeV) {
			case "A":
				classePercento=1;
				break;
			case "B":
				classePercento=1.04;
				break;
			case "3":
				classePercento=1.1;
				break;
			case "4":
				classePercento=1.5;
				break;
			case "5":
				classePercento=2.0;
				break;			
			default:
				classePercento=1.0;
		}
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		PreparedStatement pst1 = null;
		ResultSet rst1 = null;		
		
		
		try {
			pst = connessione.prepareStatement(DATI_CASELLO);
			pst.setString(1, Da);
			rst = pst.executeQuery();
			
			
			pst1 = connessione.prepareStatement(DATI_CASELLO);
			pst1.setString(1, A);
			rst1 = pst1.executeQuery();
			if(rst.next() && rst1.next()) {
			
			//Stampo idautostrada in ingresso			
			 altezzaIn = rst.getInt("altezza");
			 ingresso = rst.getString("autostrada");
			 tariffa1= rst.getDouble("tariffaKm");
			 System.out.println(altezzaIn + " " + ingresso + " " + tariffa1 );
			 
			//Stampo idautostrada del casello in uscita			
			 altezzaOut = rst1.getInt("altezza");
			 uscita = rst1.getString("autostrada");
			 tariffa2= rst1.getDouble("tariffaKm");
			 System.out.println(altezzaOut + " " + uscita + " " + tariffa2);
			}
	
	}catch(Exception e) {System.out.print(e);}
		
		if(codiceautostrada(ingresso,uscita)) {
			// Stessa autostrada faccio la differenza tra le altezza con valore assoluto
			int distanzaunica = abs(altezzaIn-altezzaOut);
			return distanzaunica*tariffa1*classePercento;
		}else{			
			//autostrade diverse. Simulo la distanza minima supponendo esista un solo svincolo tra le due autostrade
			//Calcolo i Km fatti nelle due autostrade
			PreparedStatement pst2 = null;
			ResultSet rst2 = null;
			
			PreparedStatement pst3 = null;
			ResultSet rst3 = null;			
			
			try {				
				pst2 = connessione.prepareStatement(DATI_SVINCOLO);
				pst2.setString(1, ingresso);
				pst2.setString(2, uscita);
				rst2 = pst2.executeQuery();
				
				pst3 = connessione.prepareStatement(DATI_SVINCOLO);
				pst3.setString(1, uscita);
				pst3.setString(2, ingresso);
				rst3 = pst3.executeQuery();
				
				if (rst3.next() && rst2.next()){
					km1 = rst2.getInt("km");
					System.out.print(km1);
					km2 = rst3.getInt("km");
					System.out.print(km2);	
				}
				}catch(Exception e) {
					System.out.println("cazz! "+ e);
				}					
			int distanzain = abs(altezzaIn-km1);
			int distanzaout = abs(altezzaOut-km2);
			return (distanzain*tariffa1*classePercento)+(distanzaout*tariffa2*classePercento);					
		}
	
	}

	public double pedaggioTotale(String Da, String A, String classeV, String fasciaO, String tipoV) {
		
		double tariffa1=0.0,tariffa2=0.0;
		double classePercento=1.0, fasciaOpercento=1.0,  tipoVpercento=1.0;	

		int km1=0,km2=0,altezzaIn=0, altezzaOut=0;		
		String ingresso=null,uscita=null; 
		
		switch (classeV) {
			case "A":
				classePercento=1;
				break;
			case "B":
				classePercento=1.04;
				break;
			case "3":
				classePercento=1.1;
				break;
			case "4":
				classePercento=1.5;
				break;
			case "5":
				classePercento=2;
				break;			
			default:
				classePercento=1.0;
		}
		
		switch (fasciaO) {
			case "1":
				fasciaOpercento=1.1;
				break;
			case "2":
				fasciaOpercento=1.0;
				break;
			case "3":
				fasciaOpercento=0.9;
				break;
			default:
				fasciaOpercento=1.0;
		}
		
		switch (tipoV) {
			case "metano":
				tipoVpercento=0.95;
				break;
			case "elettrica":
				tipoVpercento=0.8;
				break;
			case "ibrida":
				tipoVpercento=0.9;
				break;
			default:
				tipoVpercento=1.0;
	}
		
		
		PreparedStatement pst = null;
		ResultSet rst = null;
		
		PreparedStatement pst1 = null;
		ResultSet rst1 = null;		
		
		
		try {
			pst = connessione.prepareStatement(DATI_CASELLO);
			pst.setString(1, Da);
			rst = pst.executeQuery();
			
			
			pst1 = connessione.prepareStatement(DATI_CASELLO);
			pst1.setString(1, A);
			rst1 = pst1.executeQuery();
			if(rst.next() && rst1.next()) {
			
			//Stampo idautostrada in ingresso			
			 altezzaIn = rst.getInt("altezza");
			 ingresso = rst.getString("autostrada");
			 tariffa1= rst.getDouble("tariffaKm");
			 System.out.println(altezzaIn + " " + ingresso + " " + tariffa1 );
			 
			//Stampo idautostrada del casello in uscita			
			 altezzaOut = rst1.getInt("altezza");
			 uscita = rst1.getString("autostrada");
			 tariffa2= rst1.getDouble("tariffaKm");
			 System.out.println(altezzaOut + " " + uscita + " " + tariffa2);
			}
	
	}catch(Exception e) {System.out.print(e);}
		
		if(codiceautostrada(ingresso,uscita)) {
			// Stessa autostrada faccio la differenza tra le altezza con valore assoluto
			int distanzaunica = abs(altezzaIn-altezzaOut);
			return distanzaunica*tariffa1*classePercento*fasciaOpercento*tipoVpercento;
		}else{			
			//autostrade diverse. Simulo la distanza minima supponendo esista un solo svincolo tra le due autostrade
			//Calcolo i Km fatti nelle due autostrade
			PreparedStatement pst2 = null;
			ResultSet rst2 = null;
			
			PreparedStatement pst3 = null;
			ResultSet rst3 = null;			
			
			try {				
				pst2 = connessione.prepareStatement(DATI_SVINCOLO);
				pst2.setString(1, ingresso);
				pst2.setString(2, uscita);
				rst2 = pst2.executeQuery();
				
				pst3 = connessione.prepareStatement(DATI_SVINCOLO);
				pst3.setString(1, uscita);
				pst3.setString(2, ingresso);
				rst3 = pst3.executeQuery();
				
				if (rst3.next() && rst2.next()){
					km1 = rst2.getInt("km");
					System.out.print(km1);
					km2 = rst3.getInt("km");
					System.out.print(km2);	
				}
				}catch(Exception e) {
					System.out.println("cazz! "+ e);
				}					
			int distanzain = abs(altezzaIn-km1);
			int distanzaout = abs(altezzaOut-km2);
			return (distanzain*tariffa1*classePercento*fasciaOpercento*tipoVpercento)+(distanzaout*tariffa2*classePercento*fasciaOpercento*tipoVpercento);					
		}
	
	}
	
	public boolean codiceautostrada(String ingresso, String uscita) {
		if(ingresso.equals(uscita)) {
			return true;
		}
		else return false;
		
	}

	private int abs(int i) {
		if ( i<0) {return -i;}
		else {return i;}
	}

	
	public static String getDateFormatter() {
			return DATE_FORMATTER;
		}

			//InfoBox
			public static void infoBox(String infoMessage, String titleBar, String headerMessage, String msgType)
		    {
				Alert alert = new Alert(AlertType.valueOf(msgType));
		        alert.setTitle(titleBar);
		        alert.setHeaderText(headerMessage);
		        alert.setContentText(infoMessage);
		        alert.showAndWait();
		    }

}
