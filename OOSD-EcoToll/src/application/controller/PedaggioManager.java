package application.controller;

import application.dao.DAOFactory;
import application.model.Pedaggio;
/**
 * Implementa le logiche del Pedaggio 
 */

public class PedaggioManager {
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	public PedaggioManager() {}
	
	public static PedaggioManager getInstance() {
		return new PedaggioManager();
	}
	
	public boolean addPedaggio(Pedaggio pedaggio) {
		return DaoFactory.getDAOPedaggio().addPedaggio(pedaggio);
	}
}
