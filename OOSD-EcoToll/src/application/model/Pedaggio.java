package application.model;

public class Pedaggio {
		private Casello caselloIn;
		private Casello caselloOut;
		private Veicolo veicolo;
		private Normativa normaVigente;
		private Percorso percorso;
		
		public Casello getCaselloIn() {
			return caselloIn;
		}
		public void setCaselloIn(Casello caselloIn) {
			this.caselloIn = caselloIn;
		}
		
		public Normativa getNormativa() {
			return normaVigente;
		}
		public void setnNormativa(Normativa normaVigente) {
			this.normaVigente = normaVigente;
		}
		
		public Percorso getPercorso() {
			return percorso;
		}
		public void setPercorso(Percorso percorso) {
			this.percorso = percorso;
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
