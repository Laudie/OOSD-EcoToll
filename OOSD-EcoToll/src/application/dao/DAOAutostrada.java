package application.dao;

import java.util.List;

import application.model.Autostrada;

public interface DAOAutostrada {

	/** Recupera un oggetto Autostrada esistente a partire dall'id. */	
	public Autostrada getAutostrada(String codAutostrada);
	
	/** Recupera idutostrada Autostrada . */	
	public String getIdAutostrada(String codAutostrada);
	
	public List<Autostrada> getAllAutostrada();
	
}
