package business.manager;

import java.util.List;

import business.model.Casello;
import ecotoll.dao.DAOFactory;
public class CaselloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private CaselloManager() {}
	
	public static CaselloManager getInstance() {
		return new CaselloManager();
	}
	
	
	
	// Cerca un casello nel db e lo ritorna
	
	public Casello get(int id) {
		return DaoFactory.getEcoTollDAO().getCasello(id);
	}
	
	
	
	// Data un'Autostrada ritorna tutti i caselli nel db
	
	public List<Casello> getAll() {
		return DaoFactory.getEcoTollDAO().getAllCasello();
	}
	
	
	
	
	// Dato un casello lo rimuove dal DB

	
		public boolean delete(int idcasello) {
			return DaoFactory.getEcoTollDAO().deleteCasello(idcasello);
		}
	
	
	/*Dato un casello lo salva nel DB

	
	public void store(Casello c) {
	return DaoFactory.getEcoTollDAO().AddCasello(c);
	}
	
	*/
	

	/*Dato un casello lo modifica nel DB

	
	public void modify(String nome, Casello c){
	return DaoFactory.getEcoTollDAO().ModifyCasello(nome , c);
	}
	
	*/
	

}