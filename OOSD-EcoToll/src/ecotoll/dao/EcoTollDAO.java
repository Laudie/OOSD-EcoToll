package ecotoll.dao;
import java.util.List;

import business.model.*;


//Note that methods within an interface are public by default, so you can omit public from their headers
/**
 * L'interfaccia DAO per le diverse implementazioni di Eco Toll. Definisce le operazioni CRUD.
 */
public interface EcoTollDAO {

	/** Recupera tutti gli oggetti Casello dal DB. */
	public List<Casello> getAllCasello();
	
	/** Recupera un oggetto Casello esistente a partire dall'id. */
	public Casello getCasello(int id);
	
	/** Recupera un oggetto Casello esistente a partire dall'id. */
	public Casello getCasello(String id);
	
	/** Crea un oggetto Casello */
	public void createCasello(String codAutostrada, String nomeCasello, int Altezza);
	
	/** Crea un oggetto Casello */
	public boolean addCasello(Casello casello);
		
	/** Cancella un casello esistente. */
	public boolean deleteCasello(String nome);
	
	/** Recupera un oggetto Autostrada esistente a partire dall'id. */	
	public Autostrada getAutostrada(String codAutostrada);
	
	/** Recupera idutostrada Autostrada . */	
	public String getIdAutostrada(String codAutostrada);
	
	/** Recupera un oggetto Svincolo esistente */
	public Svincolo getSvincolo(String autostradaIn, String autostradaOut);
	
	/** Recupera aletzza dello Svincolo tra autoIn e autoout */
	public int getAltezzaSvincolo(String autostradaIn, String autostradaOut);
	
	/** Recupera un oggetto veicolo dalla targa */
	public Veicolo getVeicolo(String veicolo);
	
	public Login getUserPwd(String user, String pwd);
	public boolean isLogin(String user, String pwd);
		
	/** Salva su DB il pedaggio */
	public void SetPedaggio (String caselloIn, String caselloOut, String targa);
	
}
