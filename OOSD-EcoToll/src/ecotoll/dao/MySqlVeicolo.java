package ecotoll.dao;

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

}
