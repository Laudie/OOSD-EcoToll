package application.dao;

import application.model.Pedaggio;

public interface DAOPedaggio {

	/** Salva su DB il pedaggio */
	public boolean addPedaggio (Pedaggio p);
	public boolean addPd2(String targa, String da, String a, double t, String n);
	public boolean addPedaggio3();
}
