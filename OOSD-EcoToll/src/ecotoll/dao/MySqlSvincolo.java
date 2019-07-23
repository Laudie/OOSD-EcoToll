package ecotoll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Svincolo;

public class MySqlSvincolo implements DAOSvincolo{

	private static final String DATI_SVINCOLO = "select km from svincolo where autostradaIn=? and autostradaOut=?;";
	
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


}
