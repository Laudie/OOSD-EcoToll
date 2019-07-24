package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlNormativa implements DAONormativa {
	
	private static final String UPDATE_NORMATIVA="update EcoToll.normativa set normativa = ? WHERE (idnormativa = 1);";
	private static final String SELECT_NORMATIVA = "select * from EcoToll.normativa where idnormativa=1;";
	private static final String SELECT_CLASSE_IT="select * from EcoToll.classeIT where idclasseIT=?";
	private static final String SELECT_CLASSE_EU="select * from EcoToll.classeEU where idclasseEU=?";
	
	public boolean setNormativa(String normativa) {
		Connection conn=null;
		PreparedStatement pst=null;
		int rst=0;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(UPDATE_NORMATIVA);
			pst.setString(1, normativa);
			rst=pst.executeUpdate();
			
			if (rst==1) {
			return true;}
			else return false;
		}catch (SQLException e)	{
			e.printStackTrace();
			return false;
	}finally {
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}
	public String getNormativa() {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(SELECT_NORMATIVA);
			rst=pst.executeQuery();
			
			if (rst.next()) {
			return rst.getString("normativa");}
			else return "Nessuna Normativa presente";
		}catch (SQLException e)	{
			e.printStackTrace();
			return "Errore in SQL";
	}finally {
		 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}
	@Override
	public double getValoreClasse(int idclasseIT) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(SELECT_CLASSE_IT);
			pst.setInt(1, idclasseIT);
			rst=pst.executeQuery();			
			if (rst.next()) {
			return rst.getDouble("moltiplicatore");}
			else return 1;
		}catch (SQLException e)	{
			e.printStackTrace();
			return 0;
	}finally {
		 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}
	@Override
	public double getValoreEU(int idclasseEU) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(SELECT_CLASSE_EU);
			pst.setInt(1, idclasseEU);
			rst=pst.executeQuery();			
			if (rst.next()) {
			return rst.getDouble("moltiplicatore");}
			else return 1;
		}catch (SQLException e)	{
			e.printStackTrace();
			return 0;
	}finally {
		 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
		 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
		 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
			}
	}

}
