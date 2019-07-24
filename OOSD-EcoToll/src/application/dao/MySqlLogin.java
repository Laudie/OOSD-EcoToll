package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Login;

public class MySqlLogin implements DAOLogin{

	private static final String DATI_LOGIN= "select * from utente where username=? and password=?;";
	private static final String INSERT_LOGIN="insert into EcoToll.utente (username,nome,cognome, password, ruolo) value (?,?,?,?,?);";
	
	@Override
	
	public Login getUserPwd(String user, String pwd) {
		Login login= new Login();
			
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(DATI_LOGIN);
			pst.setString(1, user);
			pst.setString(2, pwd);
			rst=pst.executeQuery();
			while (rst.next()){
				login.setPassword(rst.getString("password"));
				login.setUsername(rst.getString("username"));
				login.setRuolo(rst.getInt("ruolo"));					
			}
		}catch (SQLException e)	{
				e.printStackTrace();
		}finally {
			 if (rst != null) try { rst.close(); } catch (SQLException ignore) {}
			 if (pst != null) try { pst.close(); } catch (SQLException ignore) {}
			 if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
				}
		return login;
	}

	public boolean isLogin(String user, String pwd) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(DATI_LOGIN);
			pst.setString(1, user);
			pst.setString(2, pwd);
			rst=pst.executeQuery();
			
			if (rst.next()) {
					System.out.println("next: " +  rst.getString(1));
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

	@Override
	public boolean addUser(Login login) {
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;		
		conn = MySQLDAOFactory.createConnection();
		try {
			pst=conn.prepareStatement(INSERT_LOGIN);
			pst.setString(1, login.getUsername());
			pst.setString(2, login.getUsername());
			pst.setString(3, login.getUsername());
			pst.setString(4, login.getPassword());
			pst.setInt(5, 2);
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
	
}
