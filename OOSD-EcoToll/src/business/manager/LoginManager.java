package business.manager;

import business.model.Login;
import ecotoll.dao.DAOFactory;

public class LoginManager {
	
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);
	
	
	public LoginManager() {}
	
	public static LoginManager getInstance() {
		return new LoginManager();
	}
	
	// Cerca user e pwd 	
	public Login get(String user, String pwd) {
		return DaoFactory.getEcoTollDAO().getUserPwd(user, pwd);
	}
	
	public boolean isLogin(String user1, String pwd1) {
		if (DaoFactory.getEcoTollDAO().isLogin(user1, pwd1)) return true;
		else return false;
		
	}
}
