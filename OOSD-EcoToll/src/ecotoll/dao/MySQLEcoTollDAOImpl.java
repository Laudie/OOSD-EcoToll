package ecotoll.dao;

import java.util.List;

import business.model.Autostrada;
import business.model.Casello;
import business.model.Svincolo;
import business.model.Veicolo;

public class MySQLEcoTollDAOImpl implements EcoTollDAO {

	//QUERY
	private static final String DATE_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	private static final String TARGA_VEICOLO = "select * from veicolo where targa=?;";
	private static final String PASSAGGIO_VEICOLO = "insert into EcoToll.storico (targa, da, a, dataoraIn, dataoraOut, pedaggio) value (?,?,?,?,?,?);";
	private static final String DATI_CASELLO = "select * from tariffa where casello=?;";
	private static final String DATI_SVINCOLO = "select km from svincolo where autostradaIn=? and autostradaOut=?;";
	
	
	@Override
	public List<String> getAllCasello() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Casello getCasello(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCasello(String codAutostrada, String nomeCasello, int Altezza) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteCasello(int idcasello) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Autostrada getAutostrada(String codAutostrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Svincolo getSvincoloIn(String autostradaIn, String autostradaOut) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veicolo getVeicolo(String veicolo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void SetPedaggio(String caselloIn, String caselloOut, String targa) {
		// TODO Auto-generated method stub
		
	}

	

}
