package application.controller;

import application.model.Pedaggio;
import ecotoll.dao.DAOFactory;

public class PedaggioManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  PedaggioManager() {}
	
	public static PedaggioManager getInstance() {
		return new PedaggioManager();
	}
	
/*	public void storePedaggio(Pedaggio p) {
		DaoFactory.getEcoTollDAO().setPedaggio(p.getCaselloIn().getNomecasello(), p.getCaselloOut().getNomecasello(), p.getVeicolo().getTarga());
	}
*/
}