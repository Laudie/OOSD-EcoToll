package application.controller;

import application.dao.DAOFactory;
import application.model.Autostrada;
import application.model.Svincolo;


public class SvincoloManager {
	
	private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	private  SvincoloManager() {}
	
	public static SvincoloManager getInstance() {
		return new SvincoloManager();
	}
	/*
	public Svincolo getSvincolo(Autostrada autostradaIn,Autostrada autostradaOut) {
		return DaoFactory.getEcoTollDAO().getSvincoloIn(autostradaIn.getNomeautostrada(),autostradaOut.getNomeautostrada());
	}*/

}