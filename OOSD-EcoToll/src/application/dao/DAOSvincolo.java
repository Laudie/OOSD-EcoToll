package application.dao;

import application.model.Svincolo;

public interface DAOSvincolo {

	/** Recupera un oggetto Svincolo esistente */
	public Svincolo getSvincolo(String autostradaIn, String autostradaOut);
	
	/** Recupera altezza dello Svincolo tra autoIn e autoout */
	public int getAltezzaSvincolo(String autostradaIn, String autostradaOut);
	
}
