package application.dao;

import application.model.Pedaggio;

public interface DAOPedaggio {

	/** Salva su DB il pedaggio */
	public boolean addPedaggio(Pedaggio p);

}
