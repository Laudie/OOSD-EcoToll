package application.dao;

public interface DAOPedaggio {

	/** Salva su DB il pedaggio */
	public void SetPedaggio (String caselloIn, String caselloOut, String targa);
	
}
