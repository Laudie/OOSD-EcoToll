package business.model;

public class Veicolo {

	private String targa;
	private String modello;
	private String marca;
	private int anno;
	private int assi;
	// peso in KG, altezza in cm
	private int peso;
	private int altezza;
	private String classeTariffaria;
	private int classeEU;
	
	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public int getAssi() {
		return assi;
	}

	public void setAssi(int assi) {
		this.assi = assi;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public String getClasseTariffaria() {
		return classeTariffaria;
	}

	public void setClasseTariffaria(String classeTariffaria) {
		this.classeTariffaria = classeTariffaria;
	}

	public int getClasseEU() {
		return classeEU;
	}

	public void setClasseEU(int classeEU) {
		this.classeEU = classeEU;
	}

	public Veicolo() {
		// TODO Auto-generated constructor stub
	}

}
