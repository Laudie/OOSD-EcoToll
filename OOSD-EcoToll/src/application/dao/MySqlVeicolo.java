package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Veicolo;

public class MySqlVeicolo implements DAOVeicolo{

	private static final String DATI_VEICOLO = "select * from veicolo where targa=?;";
	
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
				veicolo.setTarga(rst.getString("targa"));
				veicolo.setIdclasseIT(rst.getInt("idclasseIT"));
				veicolo.setIdclasseEU(rst.getInt("idclasseEU"));		
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
	
	public boolean isVeicolo(String targa) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			if (rst.next()) {
				//System.out.println("next: " +  rst.getString(1));
				return true;}
			else return false;
		}catch (SQLException e)	{
				e.printStackTrace();
				return false;
		}finally {
			 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
				}
	}
}
