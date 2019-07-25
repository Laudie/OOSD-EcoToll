package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Pedaggio;


public class MySqlPedaggio implements DAOPedaggio {
	
	private static final String INSERT_PEDAGGIO="insert into EcoToll.storico (targa, da, a, pedaggio, normativa) VALUES (?,?,?,?,?);";
	@Override
	public boolean addPedaggio(Pedaggio p) {
		
		Connection conn=null;
		PreparedStatement pst=null;
		conn = MySQLDAOFactory.createConnection();
		
		try {
			pst=conn.prepareStatement(INSERT_PEDAGGIO);
			pst.setString(1, p.getTargaveicolo());
			pst.setString(2, p.getCaselloIn());
			pst.setString(3, p.getCaselloOut());
			pst.setDouble(4, p.getPedaggio());
			pst.setString(5, p.getNormaVigente());
			int i=pst.executeUpdate();
			if (i==1) return true;
			else return false;
		}catch (SQLException e)	{
			e.printStackTrace();
			return false;
	}finally {
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}
}
