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
	private static final String DATI_VEICOLO = "select * from veicolo where targa=?;";
	private static final String DATI_SVINCOLO = "select km from svincolo where autostradaIn=? and autostradaOut=?;";
	private static final String DATI_CASELLO_ID = "select * from casello where idcasello=?;";
	private static final String DATI_CASELLO_NOME = "select * from casello where casello=?;";
	private static final String DATI_AUTOSTRADA= "select * from autostrada where idautostrada=?;";
	
	private static final String PASSAGGIO_VEICOLO = "insert into EcoToll.storico (targa, da, a, dataoraIn, dataoraOut, pedaggio) value (?,?,?,?,?,?);";
	
	//private static final String DATI_CASELLO_TARIFFA_ID = "select * from tariffa where idcasello=?;";
	//private static final String DATI_CASELLO_TARIFFA_NOME = "select * from tariffa where casello=?;";
	
	private static final String ELENCO_CASELLO= "select * from casello;";
	private static final String ELENCO_AUTOSTRADA= "select * from autostrada;";
	
	
	
	@Override
	public List<Casello> getAllCasello() {
		List<Casello> caselli = new ArrayList<>();
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
	public Casello getCasello(int id) {
		// TODO Auto-generated method stub
		Casello casello=new Casello();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_CASELLO_ID);
			pst.setInt(1, id);
			rst = pst.executeQuery();
			while (rst.next()) {
				casello.setIdcasello(rst.getInt("idcasello"));
				casello.setNomecasello(rst.getString("casello"));
				casello.setAltezza(rst.getInt("altezza"));		}
			
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
	public Casello getCasello(String nome) {
		Casello casello=new Casello();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_CASELLO_NOME);
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
		Autostrada autostrada= new Autostrada();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_AUTOSTRADA);
			pst.setString(1, codAutostrada);
			rst=pst.executeQuery();
			while (rst.next()){
				autostrada.setIdautostrada(rst.getString(1));
				autostrada.setNomeautostrada(rst.getString(2));
				autostrada.setDa(rst.getString(3));
				autostrada.setA(rst.getString(4));
				autostrada.setLunghezza(rst.getInt(5));
				autostrada.setTariffa(rst.getDouble(6));				
			}
		}catch (SQLException e)	{
			e.printStackTrace();
			}finally {
				 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
				 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
				 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
		
		return null;
	}
	
	@Override
	public String getIdAutostrada(String codAutostrada) {
		String idautostrada=null;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_AUTOSTRADA);
			pst.setString(1, codAutostrada);
			rst=pst.executeQuery();
			while (rst.next()){
				idautostrada=rst.getString(1);
			}
		}catch (SQLException e)	{
			e.printStackTrace();
			}finally {
				 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
				 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
				 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
		
		return idautostrada;
	}
	
	@Override
	public Svincolo getSvincolo(String autostradaIn, String autostradaOut) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getAltezzaSvincolo(String autostradaIn, String autostradaOut) {
		int altezzaKm=0;
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst = conn.prepareStatement(DATI_SVINCOLO);
			pst.setString(1, autostradaIn);
			pst.setString(2, autostradaOut);
			rst=pst.executeQuery();
			while (rst.next()){
				altezzaKm=rst.getInt(1);
			}
		}catch (SQLException e)	{
			e.printStackTrace();
			}finally {
				 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
				 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
				 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
		return altezzaKm;
	}

	@Override
	public Veicolo getVeicolo(String targa) {
		Veicolo veicolo = new Veicolo();
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			while (rst.next()){
				veicolo.setTarga(rst.getString(1));
				veicolo.setIdclasse(rst.getInt(2));
				veicolo.setIdtipo(rst.getInt(3));		
			}
		}catch (SQLException e)	{
				e.printStackTrace();
		}finally {
			 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
				}
		return veicolo;
	}

	@Override
	public void SetPedaggio(String caselloIn, String caselloOut, String targa) {
		// TODO Auto-generated method stub
		
	}

	

}
