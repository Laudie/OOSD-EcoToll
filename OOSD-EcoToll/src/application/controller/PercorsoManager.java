package application.controller;

import application.dao.DAOFactory;
import application.model.Veicolo;
import application.model.Autostrada;;

public class PercorsoManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public  PercorsoManager() {}
	
	/*
	 Per usare pattern SINGLETON
	 public static PercorsoManager getInstance() {
		return new PercorsoManager();
	}*/
	
	public Autostrada getAutostrada(String idAuto) {
		return DaoFactory.getDAOAutostrada().getAutostrada(idAuto);
	}
	
	public Veicolo getVeicolo(String Targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(Targa);
	}
	
	public boolean isVeicolo(String Targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(Targa) != null;
	}

}