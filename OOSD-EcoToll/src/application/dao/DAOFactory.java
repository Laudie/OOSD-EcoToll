package application.dao;

public abstract class DAOFactory {

	 /** Membro statico per la factory MySQL */
    public static final int MYSQL = 0;  
    /** Membro statico per la factory Oracle */
    public static final int ORACLE = 1;
 
    /** Metodi statici per EcoToll DAO */
    public abstract DAOAutostrada getDAOAutostrada();
    public abstract DAOCasello getDAOCasello();
    public abstract DAOLogin getDAOLogin();
    public abstract DAOPedaggio getDAOPedaggio();
    public abstract DAOSvincolo getDAOSvincolo();
    public abstract DAOVeicolo getDAOVeicolo();
    public abstract DAONormativa getDAONormativa();
 
    /**
     * Metodo Factory
     * 
     * @param database: il database da scegliere
     * @return la factory corrispondente
     */
    public static DAOFactory getDAOFactory(int database) {
        switch (database) {
        case MYSQL:
            return new MySQLDAOFactory();
        case ORACLE:
             return new OracleDAOFactory();
        default:
            return null;
        }
    }
}
