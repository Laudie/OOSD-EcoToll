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

	public void chekcAutostradaUnica(Casello caselloIn, Casello caselloOut) {
		
		if (caselloIn.getAutostrada().getIdautostrada().equals(caselloOut.getAutostrada().getIdautostrada())){
			int distanza=abs(caselloOut.getAltezza()-caselloIn.getAltezza());
			double tariffa=caselloOut.getAutostrada().getTariffa();
			
		}else {
					//distanza1= Svincolo(caselloIn.getAutostrada(), caselloOut.getAutostrada()).
			
			}
		
	}
	
	
	public Pedaggio calcolaPedaggio(Veicolo veicolo, Casello caselloIn, Casello caselloOut , NormaVigente norma) {
		
		Pedaggio pedaggio=new Pedaggio();
		double classePercento=0, costo=0.0;
		
		if (caselloIn.getAutostrada().getIdautostrada().equals(caselloOut.getAutostrada().getIdautostrada())){
			int distanza=abs(caselloOut.getAltezza()-caselloIn.getAltezza());
			double tariffa=caselloOut.getAutostrada().getTariffa();
			int classe=veicolo.getIdclasse();
			switch (classe) {
			case 1:
				classePercento=1;
				break;
			case 2:
				classePercento=1.04;
				break;
			case 3:
				classePercento=1.1;
				break;
			case 4:
				classePercento=1.5;
				break;
			case 5:
				classePercento=2.0;
				break;			
			default:
				classePercento=1.0;
		}
			costo=distanza*tariffa*classePercento;
		}else {
			//SVINCOLO	SE CI RIUSCIAMO
			//ALLARME
			}
		
		double a=calcolaDistanza();
		
		if (norma.getNorma().equals("IT")) {
			//calcola tariffa con dati Italiani, senza moltiplicatori
			
			costo= Math.round(a*100)/100;
			
			pedaggio.setPedaggio(costo);
			pedaggio.setCaselloIn(caselloIn);
			pedaggio.setCaselloOut(caselloOut);
			pedaggio.setVeicolo(veicolo);
		}else {
			//calcola tariffa con dati europei, con i moltiplicatori
			costo= Math.round(a*50)/100f;
			pedaggio.setPedaggio(costo);
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
