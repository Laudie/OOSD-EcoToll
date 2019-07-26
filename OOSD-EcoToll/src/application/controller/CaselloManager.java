package application.controller;

/**
 * implementa le logiche del casello
 */

import java.util.List;
/**
 * Implementa le logiche del casello
 */

import application.dao.DAOFactory;
import application.model.Casello;
public class CaselloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	public static CaselloManager getInstance() {
		return new CaselloManager();
	}
	
	public Casello get(int id) {
		return DaoFactory.getDAOCasello().getCasello(id);
	}

	public List<Casello> getAllCas() {
		return DaoFactory.getDAOCasello().getAllCasello();
	}

	public boolean delete(Casello casello) {
		return DaoFactory.getDAOCasello().deleteCasello(casello);
	}
		

	public boolean aggiungi(Casello c) {
		return DaoFactory.getDAOCasello().addCasello(c);
	}
	
}