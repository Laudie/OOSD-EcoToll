package application.model;

public class Normativa {

	private String norma;
	private int idnorma;
	private int idclasseIT;
	private int idclasseEU;
	
	public int getIdclasseIT() {
		return idclasseIT;
	}
	public void setIdclasseIT(int idclasseIT) {
		this.idclasseIT = idclasseIT;
	}
	public int getIdclasseEU() {
		return idclasseEU;
	}
	public void setIdclasseEU(int idclasseEU) {
		this.idclasseEU = idclasseEU;
	}
	public String getNorma() {
		return norma;
	}
	public void setNorma(String norma) {
		this.norma = norma;
	}
	public int getIdnorma() {
		return idnorma;
	}
	public void setIdnorma(int idnorma) {
		this.idnorma = idnorma;
	}

}
