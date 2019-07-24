package application.controller;

import application.dao.DAOFactory;
import application.dao.MySqlPedaggio;
import application.model.Percorso;

public class PercorsoManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public  PercorsoManager() {}
	
	public static PercorsoManager getInstance() {
		return new PercorsoManager();
	}
	
	
	
	
/*	public void storePedaggio(Pedaggio p) {
		DaoFactory.getEcoTollDAO().setPedaggio(p.getCaselloIn().getNomecasello(), p.getCaselloOut().getNomecasello(), p.getVeicolo().getTarga());
	}
*/
}