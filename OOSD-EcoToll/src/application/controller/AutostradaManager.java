package application.controller;

import java.util.List;

import application.dao.DAOFactory;
import application.model.Autostrada;

/**
 * Implementa le logiche per l'autostrada
 *
 */
public class AutostradaManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  AutostradaManager() {}
	
	public static AutostradaManager getInstance() {
		return new AutostradaManager();
	}
/**
 * 	
 * @param CodAutostrada idautostrada
 * @return ritrona il codice dell'autostrada (A1, A24, ...)
 */
	public Autostrada getAutostrada(String CodAutostrada) {
		return DaoFactory.getDAOAutostrada().getAutostrada(CodAutostrada);
	}
	
	/**
	 * 
	 * @return List di autostrade
	 */
	public List<Autostrada> getAllAut() {
		return DaoFactory.getDAOAutostrada().getAllAutostrada();
	}
	
	
	/*Salva l'autostrada nel DB
	 
	public void store(Autostrada a) {
			return DaoFactory.getEcoTollDAO().addAutostrada(a);
		}
		*/
	
	/*Cancella  un' Autostrada dal DB

	public void delete(Autostrada a){
		return DaoFactory.getEcoTollDAO().deleteAutostrada(a);
	}*/
	
	/* modifica la tariffa dell'autostrada
	 
	public void modify(float tariffa, Autostrada a) {
		return DaoFactory.getEcoTollDAO().modifyAutostrada(tariffa,a);
	}*/
}