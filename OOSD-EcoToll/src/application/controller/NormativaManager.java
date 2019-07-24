package application.controller;

import application.dao.DAOFactory;

public class NormativaManager {
	
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);

	public static NormativaManager getInstance() {
		return new NormativaManager();
	}
	public String getNormativa() {
		return DaoFactory.getDAONormativa().getNormativa();
	}
	
	public boolean setNormativa(String normativa) {
		return DaoFactory.getDAONormativa().setNormativa(normativa);
	}
	
	
}
