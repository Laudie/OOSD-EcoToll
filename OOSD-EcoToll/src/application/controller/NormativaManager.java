package application.controller;

import java.sql.Connection;

import application.modelold.mysqlConnection;
import ecotoll.dao.DAOFactory;

public class NormativaManager {
	
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);
	
public static Connection connessione;
	public NormativaManager() {connessione = mysqlConnection.Connector();
	//per gestire il null nella classe mysqlConnection in caso di errore (catch return null)
	//faccio un if sulla connessione, in caso di errore exit
	if (connessione == null) System.exit(1);
}
	public static NormativaManager getInstance() {
		return new NormativaManager();
	}
public String getNormativa() {
	return DaoFactory.getDAONormativa().getNormativa();
}
;
	
	public boolean setNormativa(String normativa) {
		return DaoFactory.getDAONormativa().setNormativa(normativa);
	};
	
	
}
