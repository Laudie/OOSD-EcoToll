package business.model;

import java.time.LocalDateTime;

public class Percorso {

	Casello caselloIn;
	Casello caselloOut;
	LocalDateTime dataoraIn;
	LocalDateTime dataoraOut;

// Costruttore
	public Percorso(Casello caselloIn, Casello caselloOut, LocalDateTime dataoraIn, LocalDateTime dataoraOut) {
		super();
		this.caselloIn = caselloIn;
		this.caselloOut = caselloOut;
		this.dataoraIn = dataoraIn;
		this.dataoraOut = dataoraOut;
	}
//Getters & Setters
	public Casello getCaselloIn() {
		return caselloIn;
	}
	
	public void setCaselloIn(Casello caselloIn) {
		this.caselloIn = caselloIn;
	}
	
	public Casello getCaselloOut() {
		return caselloOut;
	}
	
	public void setCaselloOut(Casello caselloOut) {
		this.caselloOut = caselloOut;
	}
	
	public LocalDateTime getdataoraIn() {
		return dataoraIn;
	}
	
	public void setdataoraIn(LocalDateTime dataoraIn) {
		this.dataoraIn = dataoraIn;
	}
	
	public LocalDateTime getdataoraOut() {
		return dataoraOut;
	}
	
	public void setdataoraOut(LocalDateTime dataoraOut) {
		this.dataoraOut = dataoraOut;
	}
	
//Metodi standard
		@Override
	public String toString() {
		return "Percorso [caselloIn=" + caselloIn + ", caselloOut=" + caselloOut + ", dataoraIn=" + dataoraIn + ", dataoraOut="
				+ dataoraOut + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caselloIn == null) ? 0 : caselloIn.hashCode());
		result = prime * result + ((caselloOut == null) ? 0 : caselloOut.hashCode());
		result = prime * result + ((dataoraIn == null) ? 0 : dataoraIn.hashCode());
		result = prime * result + ((dataoraOut == null) ? 0 : dataoraOut.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Percorso other = (Percorso) obj;
		if (caselloIn == null) {
			if (other.caselloIn != null)
				return false;
		} else if (!caselloIn.equals(other.caselloIn))
			return false;
		if (caselloOut == null) {
			if (other.caselloOut != null)
				return false;
		} else if (!caselloOut.equals(other.caselloOut))
			return false;
		if (dataoraIn == null) {
			if (other.dataoraIn != null)
				return false;
		} else if (!dataoraIn.equals(other.dataoraIn))
			return false;
		if (dataoraOut == null) {
			if (other.dataoraOut != null)
				return false;
		} else if (!dataoraOut.equals(other.dataoraOut))
			return false;
		return true;
	}

//Calcola la distanza del percorso
	public int calcolaDistanza() {
		String codAutIn;
		String codAutOut;		
		codAutIn=caselloIn.getAutostrada().getIdautostrada();
		codAutOut=caselloOut.getAutostrada().getIdautostrada();
		if (codAutIn.equals(codAutOut))
				return abs(caselloOut.getAltezza()-caselloIn.getAltezza());
		else 
			// Calcolo della distanza su percorsi con autostrade diverse
			return 50;			
}

	
	public Pedaggio calcolaPedaggio(Veicolo veicolo, Casello caselloIn, Casello caselloOut, NormaVigente norma) {
		
		Pedaggio pedaggio=new Pedaggio();
		
		double a=20.0;
		if (norma.getNorma().equals("IT")) {
			//calcola tariffa con dati Italiani, senza moltiplicatori
			
			double tariffa= Math.round(a*100)/100f;
			
			pedaggio.setPedaggio(tariffa);
			pedaggio.setCaselloIn(caselloIn);
			pedaggio.setCaselloOut(caselloOut);
			pedaggio.setVeicolo(veicolo);
		}else {
			//calcola tariffa con dati europei, con i moltiplicatori
			double tariffa= Math.round(a*50)/100f;
			pedaggio.setPedaggio(tariffa);
			pedaggio.setCaselloIn(caselloIn);
			pedaggio.setCaselloOut(caselloOut);
			pedaggio.setVeicolo(veicolo);
			
		}		
		
		return pedaggio;
	}
	
	
//Fascia oraria del percorso
	public String calcolaFasciaOraria() {
	int oraIn=dataoraIn.getHour();
	int oraOut=dataoraOut.getHour();
	return oraIn + "-" + oraOut;
}

//Valore assoluto
	private int abs(int i) {
	// TODO Auto-generated method stub
	if (i>0)
		 return i;
	else
		return (-i);
	
}

}
