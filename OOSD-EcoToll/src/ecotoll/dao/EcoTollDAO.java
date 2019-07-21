package ecotoll.dao;
import java.util.List;

import business.model.*;


//Note that methods within an interface are public by default, so you can omit public from their headers
/**
 * L'interfaccia DAO per le diverse implementazioni di Eco Toll. Definisce le operazioni CRUD.
 */
public interface EcoTollDAO {

	/** Recupera tutti gli oggetti Casello dal DB. */
	public List<String> getAllCasello();
	
	/** Recupera un oggetto Casello esistente a partire dall'id. */
	public Casello getCasello(int id);
	
	/** Crea un oggetto Casello */
	public void createCasello(String codAutostrada, String nomeCasello, int Altezza);
		
	/** Cancella un casello esistente. */
	public boolean deleteCasello(int idcasello);
	
	/** Recupera un oggetto Autostrada esistente a partire dall'id. */	
	public Autostrada getAutostrada(String codAutostrada);
	
	/** Recupera un oggetto Svincolo esistente */
	public Svincolo getSvincoloIn(String autostradaIn, String autostradaOut);
	
	/** Recupera un oggetto veicolo dalla targa */
	public Veicolo getVeicolo(String veicolo);
	
	/** Salva su DB il pedaggio */
	public void SetPedaggio (String caselloIn, String caselloOut, String targa);
	
	
	
	
}
