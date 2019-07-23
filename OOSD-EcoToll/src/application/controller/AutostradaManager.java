package application.controller;

import application.model.Autostrada;
import ecotoll.dao.DAOFactory;


public class AutostradaManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  AutostradaManager() {}
	
	public static AutostradaManager getInstance() {
		return new AutostradaManager();
	}
	
	public Autostrada getAutostrada(String CodAutostrada) {
		return DaoFactory.getDAOAutostrada().getAutostrada(CodAutostrada);
	}
	
	/*Salva l'autostrada nel DB
	 
	public void store(Autostrada a) {
			return DaoFactory.getEcoTollDAO().storeAutostrada(a);
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