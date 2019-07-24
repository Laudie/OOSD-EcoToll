package application.model;

import java.time.LocalDateTime;

public class Percorso {

	Casello caselloIn;
	Casello caselloOut;
	LocalDateTime dataoraIn;
	LocalDateTime dataoraOut;
	Veicolo veicolo;
	
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
	public Veicolo getVeicolo() {
		return veicolo;
	}
	public void setVeicolo(Veicolo veicolo) {
		this.veicolo = veicolo;
	}
	
}
