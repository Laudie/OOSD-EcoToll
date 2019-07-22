package ecotoll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory{

	/** la classe driver */
    public static final String DRIVER = "com.mysql.jdbc.Driver";
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
        try {/*
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL_WWW, USER, PASS);
            */
        	Class.forName("com.mysql.cj.jdbc.Driver");			
			conn=DriverManager.getConnection("jdbc:mysql://51.75.200.121:3306/EcoToll"
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
					+ "serverTimezone=UTC","objsw","$obj!sw$");
        	
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        }
        return conn;
    }
    
	public EcoTollDAO getEcoTollDAO() {
		return new MySQLEcoTollDAOImpl();
	}
}
