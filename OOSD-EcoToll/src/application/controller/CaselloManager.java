package application.controller;

import java.util.List;

import application.model.Casello;
import ecotoll.dao.DAOFactory;
public class CaselloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public CaselloManager() {}
	
	public static CaselloManager getInstance() {
		return new CaselloManager();
	}
	
	// Cerca un casello nel db e lo ritorna	
	public Casello get(int id) {
		return DaoFactory.getDAOCasello().getCasello(id);
	}
		
	// Data un'Autostrada ritorna tutti i caselli nel db	
	public List<Casello> getAll() {
		return DaoFactory.getDAOCasello().getAllCasello();
	}
		
	// Dato un casello lo rimuove dal DB	
		public boolean delete(String nome) {
			return DaoFactory.getDAOCasello().deleteCasello(nome);
		}
		
	/*Dato un casello lo salva nel DB*/
	public boolean aggiungi(Casello c) {
		return DaoFactory.getDAOCasello().addCasello(c);
	}
	
}