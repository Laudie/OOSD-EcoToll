package application.controller;

import application.dao.DAOFactory;
/**
 * implementa le logiche della normativa
 */
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
	
	public double getValoreClasse(int idclasseIT) {
		return DaoFactory.getDAONormativa().getValoreClasse(idclasseIT);
	}
	
	public double getValoreEU(int idclasseEU) {
		return DaoFactory.getDAONormativa().getValoreEU(idclasseEU);
	}
}
