package application;

import java.sql.*;

import javax.swing.JOptionPane;

public class AppModel {
	public static Connection conection;
	public AppModel() {
		conection = mysqlConnection.Connector();
		//per gestire il null nella classe mysqlConnection in caso di errore (catch return null)
		//faccio un if sulla connessione, in caso di errore exit
		if (conection == null) System.exit(1);
	}
//metodo per verificare la connessione al database
	public boolean isDbConnected() {
		try {
			return !conection.isClosed();
	} catch (SQLException e) {
		e.printStackTrace();
		return false;
		}
	}
	
/*
 *  Metodo per verificare user e password **
 *
*/

	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String qry="select * from utente where username=? and password=?";
		try {
			pst = conection.prepareStatement(qry);
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
	
	public boolean isUserName(String username) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		int tot=0;
		String query = "select username from utente where username=?;";	
		try {
			pst = conection.prepareStatement(query);
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
	
	public boolean isRegistered(String nome, String cognome, String username, String password) throws SQLException {		
		
		PreparedStatement pst = null;		
		String qry="insert into EcoToll.utente (nome, cognome, username, password) value (?,?,?,?);";
		try {
			pst=conection.prepareStatement(qry);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally { //viene eseguito sempre - chiude le connessioni al db
			pst.close();			
		}		
		
	}
	
	public boolean isTarga(String targa) {
		
		/*
		 * simulazione 
		 * Inserisce nel DB le targhe delle auto che sono transitate
		 *
		 * */
		return true;
		
	}
	
	public boolean eliminaCasello(String casello) throws SQLException {
		PreparedStatement pst = null;		
		String qry="delete from EcoToll.casello where(casello = ?)";
		try {
			pst=conection.prepareStatement(qry);
			pst.setString(1, casello);
			
			
			int count=pst.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}finally { //viene eseguito sempre - chiude le connessioni al db
			pst.close();			
		}		
		
	}
	
	public boolean caselloPresente(String casello) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select casello from casello where casello=?;";	
		try {
			pst = conection.prepareStatement(query);
			pst.setString(1, casello);
			rst = pst.executeQuery();			
			if (rst.next()) {
				System.out.println("Casello già presente");
					return true;}
				else {return false;}
			}catch(Exception e) {return false;}		
	}
	
public boolean aggiungiCas(String codice, String nome, String altezza, String codautostrada) throws SQLException {		
		
		PreparedStatement pst = null;		
		String qry="insert into EcoToll.casello (codcasello, casello, altezza, idautostrada) value (?,?,?,?);";
		try {
			pst=conection.prepareStatement(qry);
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

	public boolean amministratore(String username) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select ruolo from utente where username=?;";	
		try {
			pst = conection.prepareStatement(query);
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
	
	
	
}
