package application.controller;

import application.dao.DAOFactory;
import application.model.Veicolo;


public class VeicoloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	public  VeicoloManager() {}
	
	public static VeicoloManager getInstance() {
		return new VeicoloManager();
	}
	
	public Veicolo getVeicolo(String Targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(Targa);
	}

}