package application.model;

public class Pedaggio {
		private String caselloIn;
		private String caselloOut;
		private String targaveicolo;
		private String normaVigente;
		private double pedaggio;
		
		public String getCaselloIn() {
			return caselloIn;
		}
		public void setCaselloIn(String caselloIn) {
			this.caselloIn = caselloIn;
		}
		public String getCaselloOut() {
			return caselloOut;
		}
		public void setCaselloOut(String caselloOut) {
			this.caselloOut = caselloOut;
		}
		public String getTargaveicolo() {
			return targaveicolo;
		}
		public void setTargaveicolo(String targaveicolo) {
			this.targaveicolo = targaveicolo;
		}
		public String getNormaVigente() {
			return normaVigente;
		}
		public void setNormaVigente(String normaVigente) {
			this.normaVigente = normaVigente;
		}
		public double getPedaggio() {
			return pedaggio;
		}
		public void setPedaggio(double pedaggio) {
			this.pedaggio = pedaggio;
		}
		
		
}
