package application.dao;

import application.model.Veicolo;

public interface DAOVeicolo {

	/** Recupera un oggetto veicolo dalla targa */
	public Veicolo getVeicolo(String veicolo);
}
