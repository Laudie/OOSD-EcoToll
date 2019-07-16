package application;

import java.sql.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AppModel {
	
	public static Connection connessione;
	// Formato dataOra
	private static final String DATE_FORMATTER= "yyyy-MM-dd HH:mm:ss";
	

	public AppModel() {
		connessione = mysqlConnection.Connector();
		//per gestire il null nella classe mysqlConnection in caso di errore (catch return null)
		//faccio un if sulla connessione, in caso di errore exit
		if (connessione == null) System.exit(1);
	}
	
//metodo per verificare la connessione al database
	public boolean isDbConnected() {
		try {
			return !connessione.isClosed();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
		}
	}
// Metodo per verificare user e password **
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String qry="select * from utente where username=? and password=?";
		try {
			pst = connessione.prepareStatement(qry);
			pst.setString(1, user); //primo argomento del metodo che va nel ? di username
			pst.setString(2, pass); //secondo argomento del metodo che va nel ? di username
			rst = pst.executeQuery();
			if (rst.next()) {
				return true;
			}else {
				return false;
			}			
			} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {//viene eseguito sempre - chiude le connessioni al db
			pst.close();
			rst.close();
		}
	}
	
//metodo per verificare che l'utente esiste 
	public boolean isUserName(String username) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		int tot=0;
		String query = "select username from utente where username=?;";	
		try {
			pst = connessione.prepareStatement(query);
			pst.setString(1, username);
			rst = pst.executeQuery();			
			while (rst.next()) {
				   tot+=1;				         
			   }
			System.out.println("righe tot: " + tot);			
			if (tot>0) { //username presente
				return true;
			} else {
				return false;
			}			  
			}catch(Exception e) {return false;}
	}
//metodo per registrare un nuovo utente
	public boolean isRegistered(String nome, String cognome, String username, String password) throws SQLException {		
		
		PreparedStatement pst = null;		
		String qry="insert into EcoToll.utente (nome, cognome, username, password) value (?,?,?,?);";
		try {
			pst=connessione.prepareStatement(qry);
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, username);
			pst.setString(4, password);	
			
			int count=pst.executeUpdate();
		
			System.out.println("update: " + count);	
			if (count==1)
				return true;
			else
				return false;			
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}finally { //viene eseguito sempre - chiude le connessioni al db
			pst.close();			
		}		
	}

//InfoBox
	public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
		String msgType="WARNING";
        Alert alert = new Alert(AlertType.valueOf(msgType));
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

/* Metodo per simulare lettura targa (esempio telepass)
 * Legge la targa dal DB e prende le info del veicolo per il calcolo del pedaggio */

public boolean isTarga(String targa) throws SQLException {	
	PreparedStatement pst = null;
	ResultSet rst = null;
	String qry="select * from veicolo where targa=? ";
	try {
		pst = connessione.prepareStatement(qry);
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
	} finally {//viene eseguito sempre - chiude le connessioni al db
		pst.close();
		rst.close();
	}		
}
//  Salva sul DB il transito del veicolo con tutte le info
public boolean isTargaRegistered(String targa, String da, String a, String dataoraIn, String dataoraOut, double pedaggio) throws SQLException {
	
	PreparedStatement pst = null;		
	String qry="insert into EcoToll.storico (targa, da, a, dataoraIn, dataoraOut, pedaggio) value (?,?,?,?,?,?);";
	System.out.println("qry targa: " + qry);
	try {
		pst=connessione.prepareStatement(qry);
		pst.setString(1, targa);
		pst.setString(2, da);
		pst.setString(3, a);
		pst.setString(4, dataoraIn);
		pst.setString(5, dataoraOut);
		pst.setDouble(6, pedaggio);
		System.out.println("bohh: " + qry);
		int count=pst.executeUpdate();
		System.out.println("update: " + count);	
		if (count==1)
			return true;
		else
			return false;		
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}finally { //viene eseguito sempre - chiude le connessioni al db
		pst.close();			
	}		

}


public static String getDateFormatter() {
	return DATE_FORMATTER;
}
	
//Metodo per eliminare un casello (solo admin)
	public boolean eliminaCasello(String casello) throws SQLException {
		PreparedStatement pst = null;		
		String qry="delete from EcoToll.casello where(casello = ?)";
		try {
			pst=connessione.prepareStatement(qry);
			pst.setString(1, casello);				
			int count=pst.executeUpdate();
			if (count==1)
				return true;
			else
				return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}finally { //viene eseguito sempre - chiude le connessioni al db
			pst.close();			
		}		
		
	}
//Metodo per verificare la preseza di un casello (solo admin)
	public boolean caselloPresente(String casello) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select casello from casello where casello=?;";	
		try {
			pst = connessione.prepareStatement(query);
			pst.setString(1, casello);
			rst = pst.executeQuery();			
			if (rst.next()) {
				System.out.println("Casello già presente");
					return true;}
				else {return false;}
			}catch(Exception e) {return false;}		
	}

//Metodo per aggiungere un casello (solo admin)
public boolean aggiungiCas(String codice, String nome, String altezza, String codautostrada) throws SQLException {		
		
		PreparedStatement pst = null;		
		String qry="insert into EcoToll.casello (codcasello, casello, altezza, idautostrada) value (?,?,?,?);";
		try {
			pst=connessione.prepareStatement(qry);
			pst.setString(1, codice);
			pst.setString(2, nome);
			pst.setString(3, altezza);
			pst.setString(4, codautostrada);
			
			int count = pst.executeUpdate();
			if (count==1)
				return true;
			else
				return false;			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally { //viene eseguito sempre - chiude le connessioni al db
			pst.close();			
		}		
		
	}

//Metodo per vedere se l'utente è amministratore
	public boolean amministratore(String username) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select ruolo from utente where username=?;";	
		try {
			pst = connessione.prepareStatement(query);
			pst.setString(1, username);
			rst = pst.executeQuery();			
			if (rst.next()) {
				System.out.println(rst.getInt("ruolo"));
				if (rst.getInt("ruolo")==1) {
					
					return true;
				}
				return false;
			}
			
			}catch(Exception e) {return false;}		
		return true;
	}
	
	
	public double pedaggioTotale(String Da, String A) {
		
		double tariffa1=0.0,tariffa2=0.0;
		int km1=0,km2=0;
		String ingresso=null,uscita=null;
		int altezzaIn=0, altezzaOut=0;
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select * from tariffa where casello=?;";	
		
		
		PreparedStatement pst1 = null;
		ResultSet rst1 = null;
		String query1 = "select * from tariffa where casello=?;";	
		
		try {
			pst = connessione.prepareStatement(query);
			pst.setString(1, Da);
			rst = pst.executeQuery();
			
			
			pst1 = connessione.prepareStatement(query);
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
			 tariffa2= rst.getDouble("tariffaKm");
			 System.out.println(altezzaOut + " " + uscita + " " + tariffa2);
			}


			
				
	}catch(Exception e) {System.out.print(e);}
		
		if(codiceautostrada(ingresso,uscita)) {
			// Stessa autostrada faccio la differenza tra le altezza con valore assoluto
			int distanzaunica = abs(altezzaIn-altezzaOut);
			return distanzaunica*tariffa1;
		}
		else {
			
			//autostrade diverse. Calcoliamo lo svincolo
			//Km dello svincolo da autostradaIn ad autostradaOut
			PreparedStatement pst2 = null;
			ResultSet rst2 = null;
			String query2 = "select km from svincolo where autostradaIn=? and autostradaOut=?;";	
			
			//Km da AutostradaOut a autostradaIn
			PreparedStatement pst3 = null;
			ResultSet rst3 = null;
			String query3 = "select km from svincolo where autostradaIn=? and autostradaOut=?;";	
			
			try {
				pst2 = connessione.prepareStatement(query);
				pst2.setString(1, ingresso);
				pst2.setString(2, uscita);
				rst2 = pst2.executeQuery();
				
				
				pst3 = connessione.prepareStatement(query);
				pst3.setString(1, uscita);
				pst2.setString(2, ingresso);
				rst3 = pst3.executeQuery();
				
			
				
					km1 = rst2.getInt("km");
					System.out.print(km1);
					km2 = rst3.getInt("km");
					System.out.print(km1);
					
				
				}catch(Exception e) {System.out.println(e);}
			
			int distanzain = abs(altezzaIn-km1);

			int distanzaout = abs(altezzaOut-km2);
			System.out.println("altezza e km 1" + altezzaIn + " "+ km1 + " alt e km2 " + altezzaOut + " " + km2);
			
			System.out.println("Distanza in" + distanzain + " Out " + distanzaout);
			System.out.println("tariffa1 in" + tariffa1 + " tariffa2 " + tariffa2);
			return (distanzain*tariffa1)+(distanzaout*tariffa2);
			
		}
	
	
	}
	
	private int abs(int i) {
		if ( i<0) {return -i;}
		else {return i;}
	}
	
	public boolean codiceautostrada(String ingresso, String uscita) {
		if(ingresso.equals(uscita)) {
			return true;
		}
		else return false;
		
	}
}
