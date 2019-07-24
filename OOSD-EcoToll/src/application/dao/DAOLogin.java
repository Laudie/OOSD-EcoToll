package application.dao;

import application.model.Login;

public interface DAOLogin {
	
	public Login getUserPwd(String user, String pwd);
	
	public boolean isLogin(String user, String pwd);
	
	public boolean addUser(Login login);
	
}
