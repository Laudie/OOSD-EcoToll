package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Pedaggio;


public class MySqlPedaggio implements DAOPedaggio {
	
	private static final String INSERT_PEDAGGIO="INSERT INTO EcoToll.storico (targa, da, a, pedaggio, normativa) VALUES (?,?,?,?,?);";
	private static final String INSERT_PEDAGGIO1="INSERT INTO EcoToll.storico (targa, da, a, pedaggio, normativa) VALUES ('t','da','a',30,'n');";
	@Override
	public boolean addPedaggio(Pedaggio p) {
		
		System.out.println("DENTRO MySQLDAOPEDAGGIO targa: " + p.getTargaveicolo());
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
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
		 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}
	
public boolean addPedaggio3() {
		
		System.out.println("DENTRO MySQLDAOPEDAGGIO 1 targa: " );
		
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(INSERT_PEDAGGIO1);			
			int i=pst.executeUpdate();
			if (i==1) return true;
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

	@Override
	public boolean addPd2(String targa, String da, String a, double t, String n) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(INSERT_PEDAGGIO);
			int i=pst.executeUpdate();
			pst.setString(1, targa);
			pst.setString(2, da);
			pst.setString(3, a);
			pst.setDouble(4, t);
			pst.setString(5, n);
			
			if (i==1) return true;
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
