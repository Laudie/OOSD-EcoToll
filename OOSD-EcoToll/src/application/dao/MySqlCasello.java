package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Casello;

public class MySqlCasello implements DAOCasello {

	//private static final String DATI_CASELLO_ID = "select * from  EcoToll.casello where idcasello=?;";
	private static final String DATI_CASELLO_NOME = "select * from  EcoToll.casello where casello=?;";
	private static final String ELENCO_CASELLO= "select * from  EcoToll.casello order by casello;";
	
	private static final String INSERT_CASELLO="insert into EcoToll.casello (casello, altezza, idautostrada) value (?,?,?);";	
	private static final String DELETE_CASELLO="delete from EcoToll.casello where casello=?;";
	
	
	
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
				casello.setIdAutostrada(rst.getString("idautostrada"));
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
		return null;
	}


	@Override
	public boolean addCasello(Casello casello) {
		Connection conn=null;
		PreparedStatement pst=null;
		conn = MySQLDAOFactory.createConnection();
		
		try {
			pst = conn.prepareStatement(INSERT_CASELLO);
			pst.setString(1, casello.getNomecasello());
			pst.setInt(2, casello.getAltezza());
			pst.setString(3, casello.getAutostrada().getIdautostrada());			
			int i = pst.executeUpdate();
			if (i==1) {return true;}
			else return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
				}
	}
	
	@Override
	public boolean deleteCasello(Casello casello) {
		Connection conn=null;
		PreparedStatement pst=null;
				
		conn = MySQLDAOFactory.createConnection();
		try {
		pst = conn.prepareStatement(DELETE_CASELLO);
		pst.setString(1, casello.getNomecasello());
		int i = pst.executeUpdate();
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
