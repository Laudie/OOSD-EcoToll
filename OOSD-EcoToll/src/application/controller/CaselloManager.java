package application.controller;

//import java.sql.Connection;
import java.util.List;

import application.dao.DAOFactory;
import application.model.Casello;
public class CaselloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
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
	

	// Dato un casello lo rimuove dal DB	
	public boolean delete(Casello casello) {
		return DaoFactory.getDAOCasello().deleteCasello(casello);
	}

		
	/*Dato un casello lo salva nel DB*/
	public boolean aggiungi(Casello c) {
		return DaoFactory.getDAOCasello().addCasello(c);
	}
	
}