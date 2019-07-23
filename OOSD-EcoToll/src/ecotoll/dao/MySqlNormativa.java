package ecotoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlNormativa implements DAONormativa {
	
	private static final String MODIFY_NORMATIVA="update EcoToll.normativa set normativa = ? WHERE (idnormativa = 1);";
	private static final String GET_NORMATIVA = "select * from EcoToll.normativa where idnormativa=1;";

	
	public boolean setNormativa(String normativa) {
		Connection conn=null;
		PreparedStatement pst=null;
		int rst=0;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(MODIFY_NORMATIVA);
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
			pst=conn.prepareStatement(GET_NORMATIVA);
			rst=pst.executeQuery();
			
			if (rst.next()) {
					System.out.println("next: " +  rst.getString(1));
			return rst.getString(1);}
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

}
