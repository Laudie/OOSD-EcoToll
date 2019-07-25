package application.controller;

import application.dao.DAOFactory;
import application.model.*;

public class PedaggioManager {
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	 public PedaggioManager() {}
		
	public boolean addPedaggio(Pedaggio p) {
		return DaoFactory.getDAOPedaggio().addPedaggio(p);
	}
	

}
