package application.controller;

import application.dao.DAOFactory;
import application.dao.MySqlPedaggio;
import application.model.Autostrada;
import application.model.Login;
import application.model.Percorso;
import application.model.Veicolo;

public class PercorsoManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public  PercorsoManager() {}
	
	public static PercorsoManager getInstance() {
		return new PercorsoManager();
	}
	
	public Autostrada getAuto(String idAuto) {
		return DaoFactory.getDAOAutostrada().getAutostrada(idAuto);
	}
	
	public Veicolo getVeicolo(String Targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(Targa);
	}


	
	
	
/*	public void storePedaggio(Pedaggio p) {
		DaoFactory.getEcoTollDAO().setPedaggio(p.getCaselloIn().getNomecasello(), p.getCaselloOut().getNomecasello(), p.getVeicolo().getTarga());
	}
*/
}