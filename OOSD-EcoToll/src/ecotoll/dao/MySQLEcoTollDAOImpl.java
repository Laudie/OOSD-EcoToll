package ecotoll.dao;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import business.model.Autostrada;
import business.model.Casello;
import business.model.Svincolo;
import business.model.Veicolo;

import ecotoll.dao.*;

public class MySQLEcoTollDAOImpl implements EcoTollDAO {

	//QUERY
	private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static final String DATI_VEICOLO = "select * from v_dativeicolo where targa=?;";
	private static final String PASSAGGIO_VEICOLO = "insert into EcoToll.storico (targa, da, a, dataoraIn, dataoraOut, pedaggio) value (?,?,?,?,?,?);";
	private static final String DATI_CASELLO_TARIFFA_ID = "select * from tariffa where idcasello=?;";
	private static final String DATI_CASELLO_TARIFFA_NOME = "select * from tariffa where casello=?;";
	private static final String ELENCO_CASELLO= "select * from casello;";
	private static final String DATI_SVINCOLO = "select km from svincolo where autostradaIn=? and autostradaOut=?;";
	
	
	@Override
	public List<Casello> getAllCasello() {
		List<Casello> caselli = new ArrayList();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		
		try {
			pst = conn.prepareStatement(ELENCO_CASELLO);		
			rst = pst.executeQuery();
			while (rst.next()) {
				Casello casello = new Casello();
				casello.setIdcasello(rst.getInt("idcasello"));
				casello.setNomecasello(rst.getString("casello"));
				casello.setAltezza(rst.getInt("altezza"));
				//aggiunge il casello nella lista
				caselli.add(casello);
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return caselli;
	}

	@Override
	public Casello getDatiCasello(int id) {
		// TODO Auto-generated method stub
		Casello casello=new Casello();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_CASELLO_TARIFFA_ID);
			pst.setInt(1, id);
			rst = pst.executeQuery();
			while (rst.next()) {
				casello.setIdcasello(rst.getInt("idcasello"));
				casello.setNomecasello(rst.getString("casello"));
				casello.setAltezza(rst.getInt("altezza"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		
		return casello;
	}
	
	@Override
	public Casello getDatiCasello(String nome) {
		Casello casello=new Casello();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_CASELLO_TARIFFA_NOME);
			pst.setString(1, nome);
			rst = pst.executeQuery();
			while (rst.next()) {
				casello.setIdcasello(rst.getInt("idcasello"));
				casello.setNomecasello(rst.getString("casello"));
				casello.setAltezza(rst.getInt("altezza"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
		}
		
		return casello;
	}
	
	@Override
	public void createCasello(String codAutostrada, String nomeCasello, int Altezza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteCasello(int idcasello) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Autostrada getAutostrada(String codAutostrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Svincolo getSvincoloIn(String autostradaIn, String autostradaOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veicolo getVeicolo(String veicolo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetPedaggio(String caselloIn, String caselloOut, String targa, double pedaggio) {
		// TODO Auto-generated method stub
		
	}

	

}
