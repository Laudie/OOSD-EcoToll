package ecotoll.dao;

import java.util.List;

import application.model.Casello;

public interface DAOCasello {

	/** Recupera tutti gli oggetti Casello dal DB. */
	public List<Casello> getAllCasello();
	
	/** Recupera un oggetto Casello esistente a partire dall'id. */
	public Casello getCasello(int id);
	
	/** Recupera un oggetto Casello esistente a partire dall'id. */
	public Casello getCasello(String id);
	
	/** Crea un oggetto Casello */
	public boolean addCasello(Casello casello);
		
	/** Cancella un casello esistente. */
	public boolean deleteCasello(String nome);

}
