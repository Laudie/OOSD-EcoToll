package application.controller;

import application.dao.DAOFactory;
import application.model.Pedaggio;

public class PedaggioManager {
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public PedaggioManager() {}
	
	public static PedaggioManager getInstance() {
		return new PedaggioManager();
	}
	
	public boolean addPedaggio(Pedaggio p) {
		if (DaoFactory.getDAOPedaggio().addPedaggio(p)) return true;
		else return false;
	}

	public boolean addP2(String targa, String da, String a, double t, String n) {
		if (DaoFactory.getDAOPedaggio().addPd2(targa, da, a, t, n)) return true;
		else return false;
	}
	
	public boolean addPedaggio3() {
		if (DaoFactory.getDAOPedaggio().addPedaggio3()) return true;
		else return false;
	}
}
