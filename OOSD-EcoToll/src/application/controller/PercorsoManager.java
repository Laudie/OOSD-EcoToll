package application.controller;

import application.dao.DAOFactory;
import application.model.Veicolo;
import application.model.Autostrada;

public class PercorsoManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public  PercorsoManager() {}
	
	/*
	// Per usare pattern SINGLETON
	 public static PercorsoManager getInstance() {
		return new PercorsoManager();
	}*/
	
	public Autostrada getAutostrada(String idAuto) {
		return DaoFactory.getDAOAutostrada().getAutostrada(idAuto);
	}
	
	public Veicolo getVeicolo(String targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(targa);
	}
	
	public boolean isVeicolo(String targa) {
		return DaoFactory.getDAOVeicolo().isVeicolo(targa) ;
	}

}