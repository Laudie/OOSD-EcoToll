package application.controller;

import application.dao.DAOFactory;
import application.model.Veicolo;
import application.model.Casello;
import application.model.Pedaggio;

public class PercorsoManager {
private DAOFactory DaoFactory = DAOFactory.getDAOFactory(0);//0 è MYSQL, 1 ORACLE
	
	
	public  PercorsoManager() {}
	

	public static PercorsoManager getInstance() {
		return new PercorsoManager();
	}
	
	public int distanza(Casello caselloIn, Casello caselloOut) {
		return Math.abs(caselloIn.getAltezza()-caselloOut.getAltezza());
	}
	
	public String calcolaPedaggio(String targa, Casello caselloDa, Casello caselloA ) {
		
		String result="";
		Veicolo veicolo;
		double costo;
		Pedaggio pedaggio;
		NormativaManager normativaManager = new NormativaManager();
		
		 if (!(this.isVeicolo(targa))) {result="WARNING: Veicolo non presente nel DB ";
		 								return result;}
		 else {
			 if (! (caselloA.getIdAutostrada().equals(caselloA.getIdAutostrada()) ) ) {		
					result="WARNING: Autostrade differenti - da implementare ";
					return result;
				}else {			
					veicolo = this.getVeicolo(targa);
				}
			 
			 
		
					double tariffa=AutostradaManager.getInstance().getAutostrada(caselloDa.getIdAutostrada()).getTariffa();
					double moltIT=normativaManager.getValoreClasse(veicolo.getIdclasseIT());
					double moltEU=normativaManager.getValoreClasse(veicolo.getIdclasseEU());
							if (normativaManager.getNormativa().equals("Italiana")){	
								
								costo=distanza(caselloDa, caselloA)*tariffa*moltIT;
								costo = Math.round(costo * 10) / 10.0;
							}else {
								costo=distanza(caselloDa, caselloA)*tariffa*moltEU;
								costo = Math.round(costo * 10) / 10.0;
								}
						 pedaggio=	new Pedaggio(caselloDa.getNomecasello(),caselloA.getNomecasello(),veicolo.getTarga(),normativaManager.getNormativa(),costo);
					
					//salvaPedaggio per lo storico;
					if(PedaggioManager.getInstance().addPedaggio(pedaggio)) {
						result="Il pedaggio secondo la normativa "+ pedaggio.getNormaVigente()+" è di €"+pedaggio.getPedaggio();
						return result;
					};

				}
		 result="Errore";
		return result;
	 }

	public Veicolo getVeicolo(String targa) {
		return DaoFactory.getDAOVeicolo().getVeicolo(targa);
	}
	
	public boolean isVeicolo(String targa) {
		return DaoFactory.getDAOVeicolo().isVeicolo(targa) ;
	}

}