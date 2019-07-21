package ecotoll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDAOFactory extends DAOFactory{

	/** la classe driver */
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    /** L'url al database */
    public static final String DBURL = "jdbc:mysql://localhost:3306/prime";
    /** Lo username per le operazioni sul DB  */
    public static final String USER = "prime";
    /** La password per le operazioni sul DB */
    public static final String PASS = "prime";
    
    /**
     * Metodo per creare una connessione sul DB MySQL
     * 
     * @return l'oggetto Connection.
     */
    public static Connection createConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
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
