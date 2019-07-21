package business.model;

public class Pedaggio {
		private Casello caselloIn;
		private Casello caselloOut;
		private Autostrada autostradaIn;
		private Autostrada autostradaOut;
		private Veicolo veicolo;
		private double pedaggio;
		
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
		public Autostrada getAutostradaIn() {
			return autostradaIn;
		}
		public void setAutostradaIn(Autostrada autostradaIn) {
			this.autostradaIn = autostradaIn;
		}
		public Autostrada getAutostradaOut() {
			return autostradaOut;
		}
		public void setAutostradaOut(Autostrada autostradaOut) {
			this.autostradaOut = autostradaOut;
		}
		public Veicolo getVeicolo() {
			return veicolo;
		}
		public void setVeicolo(Veicolo veicolo) {
			this.veicolo = veicolo;
		}
		public double getPedaggio() {
			return pedaggio;
		}
		public void setPedaggio(double pedaggio) {
			this.pedaggio = pedaggio;
		}
		
}
