package business.manager;

import business.model.Veicolo;
import ecotoll.dao.DAOFactory;


public class VeicoloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  VeicoloManager() {}
	
	public static VeicoloManager getInstance() {
		return new VeicoloManager();
	}
	
	public Veicolo getVeicolo(String Targa) {
		return DaoFactory.getEcoTollDAO().getVeicolo(Targa);
	}

}