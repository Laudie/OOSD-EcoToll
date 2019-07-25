package application.dao;

import java.util.List;

import application.model.Autostrada;

public interface DAOAutostrada {
	/**
	 * Recupera un oggetto Autostrada esistente a partire dall'id
	 * @param codAutostrada codice A1, A2, A24,..
	 * @return idAutostrada stringa*/
	
	public Autostrada getAutostrada(String codAutostrada);
	
	
	public String getIdAutostrada(String codAutostrada);
	/**
	 * Lista di tutte le autostrada
	 * @return List di autostrada
	 */
	public List<Autostrada> getAllAutostrada();
	
}
