package application.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory{

	/** la classe driver */
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /** L'url al database */
    public static final String DBURL_SSH = "jdbc:mysql://127.0.0.1:3306/EcoToll?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DBURL_WWW = "jdbc:mysql://51.75.200.121:3306/EcoToll?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    /** Lo username per le operazioni sul DB  */
    public static final String USER = "objsw";
    /** La password per le operazioni sul DB */
    public static final String PASS = "$obj!sw$";
    
    /**
     * Metodo per creare una connessione sul DB MySQL
     * 
     * @return l'oggetto Connection.
     */
    public static Connection createConnection() {
       	Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DBURL_SSH, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return conn;
    }
    
	public DAOAutostrada getDAOAutostrada() {
		return new MySqlAutostrada();
	}
	
	public DAOCasello getDAOCasello() {
		return new MySqlCasello();
	}
	
	public DAOLogin getDAOLogin() {
		return new MySqlLogin();
	}
	
	public DAOPedaggio getDaoPedaggio() {
		return new MySqlPedaggio();
	}
	
	public DAOSvincolo getDAOSvincolo() {
		return new MySqlSvincolo();
	}
	
	public DAOVeicolo getDAOVeicolo() {
		return new MySqlVeicolo();
	}

	@Override
	public DAOPedaggio getDAOPedaggio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DAONormativa getDAONormativa() {
		return new MySqlNormativa();
	}	
}
