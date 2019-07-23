package application.controller;

import java.sql.Connection;
import java.util.List;

import application.model.Autostrada;
import application.model.Casello;
import application.modelold.mysqlConnection;
import ecotoll.dao.DAOFactory;
public class CaselloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	public static Connection connessione;
	
	public CaselloManager() {connessione = mysqlConnection.Connector();
	//per gestire il null nella classe mysqlConnection in caso di errore (catch return null)
	//faccio un if sulla connessione, in caso di errore exit
	if (connessione == null) System.exit(1);
}
	
	
	
	
	public static CaselloManager getInstance() {
		return new CaselloManager();
	}
	
	// Cerca un casello nel db e lo ritorna	
	public Casello get(int id) {
		return DaoFactory.getDAOCasello().getCasello(id);
	}
		
	// ritorna tutti i caselli nel db	
	public List<Casello> getAllCas() {
		return DaoFactory.getDAOCasello().getAllCasello();
	}
	
	public List<Autostrada> getAllAut() {
		return DaoFactory.getDAOAutostrada().getAllAutostrada();
	}
		
	// Dato un casello lo rimuove dal DB	
	public boolean delete(Casello casello) {
		return DaoFactory.getDAOCasello().deleteCasello(casello);
	}

		
	/*Dato un casello lo salva nel DB*/
	public boolean aggiungi(Casello c) {
		return DaoFactory.getDAOCasello().addCasello(c);
	}
	
}