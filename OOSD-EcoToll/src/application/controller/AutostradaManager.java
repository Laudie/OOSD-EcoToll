package application.controller;

import java.util.List;

import application.dao.DAOFactory;
import application.model.Autostrada;


public class AutostradaManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  AutostradaManager() {}
	
	public static AutostradaManager getInstance() {
		return new AutostradaManager();
	}
	
	public List<Autostrada> getAllAut() {
		return DaoFactory.getDAOAutostrada().getAllAutostrada();
	}
		
	
	public Autostrada getAutostrada(String CodAutostrada) {
		return DaoFactory.getDAOAutostrada().getAutostrada(CodAutostrada);
	}

}