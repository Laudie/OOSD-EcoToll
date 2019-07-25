package application.dao;

/**
 * Pattern DAO - QUORA
 * DAO factory pattern applies point 1 and 2 to the way we access database in our application
 *
 * 1 - factory design pattern uses factories to hide the complexity of creating objects 
 * from the end user and separating low level data accessing API or operations from high level business services.
 *
 *2 - DAO stands for "Data Access Object". It's an interface-based class that handles all your CRUD operations 
 * with a relational database for a particular object.
 */
public abstract class DAOFactory {

	 /** Membro statico per la factory MySQL */
    public static final int MYSQL = 0;  
    /** Membro statico per la factory Oracle */
    public static final int ORACLE = 1;
 
    /* Metodi statici per EcoToll DAO */
    public abstract DAOAutostrada getDAOAutostrada();
    public abstract DAOCasello getDAOCasello();
    public abstract DAOLogin getDAOLogin();
    public abstract DAOPedaggio getDAOPedaggio();
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
