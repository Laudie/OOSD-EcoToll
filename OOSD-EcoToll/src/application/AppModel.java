package login;
import java.sql.*;

import application.MySqlConnection;

public class LoginModel {
	Connection connection;
	
	public LoginModel () {
		connection = MySqlConnection.Connector();
		if(connection == null) {System.exit(1);}
	}

	public boolean IsConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLogin(String user, String pass) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from utente where username = ? and password = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);
			
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
			return false;
		}
		finally {
			preparedStatement.close();
			resultSet.close();
		}
		
	}
	
	public boolean UtenteReg(String username) {
		PreparedStatement pst = null;
		ResultSet rst = null;
		String query = "select count(*) from utente where username = ?";
		
		try {
			pst = connection.prepareStatement(query);
			pst.setString(1, username);
			rst = pst.executeQuery();
			if (rst.getFetchSize()>0) {
				return true;
			} else {
			return false;
			}
			}catch(Exception e) {return false;}
	}
	
	public boolean isRegistered(String nome, String cognome, String username, String password ) throws SQLException {
		if(UtenteReg(username)) {
			System.out.println("Utente già presente");
			return true;
		}
				PreparedStatement pst = null;
				ResultSet rst = null;
				String query2 = "insert into EcoToll.utente (nome, cognome, username, password) values (?,?,?,?);";
				try {
						pst = connection.prepareStatement(query2);
						pst.setString(1, nome);
						pst.setString(2, cognome);
						pst.setString(3, username);
						pst.setString(4, password);
								
								
						rst = pst.executeQuery();
						
						if (pst.executeUpdate()==1) {
							
							return true;
						}
						else {
							return false;
						}
				}catch(Exception e) {
					return false;
				}
		
		finally {
			pst.close();
			rst.close();
		}
	}
}
