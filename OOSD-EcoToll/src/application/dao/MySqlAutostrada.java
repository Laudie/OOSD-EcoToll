package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Autostrada;


public class MySqlAutostrada implements DAOAutostrada{

	private static final String DATI_AUTOSTRADA= "select * from autostrada where idautostrada=?;";
	private static final String ELENCO_AUTOSTRADA= "select * from autostrada order by idautostrada;";
	
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
		
		return autostrada;
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
	public List<Autostrada> getAllAutostrada() {
	
		List<Autostrada> listautostrada = new ArrayList<>();
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;
		
		conn = MySQLDAOFactory.createConnection();
		
		try {
			pst = conn.prepareStatement(ELENCO_AUTOSTRADA);
			rst = pst.executeQuery();
			while (rst.next()) {
				Autostrada autostrada = new Autostrada();
				autostrada.setIdautostrada(rst.getString("idautostrada"));
				autostrada.setNomeautostrada(rst.getString("nomeautostrada"));
				autostrada.setLunghezza(rst.getInt("lunghezza"));
				//aggiunge autostrada nella lista
				listautostrada.add(autostrada);
			}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return listautostrada;
	}	

}
