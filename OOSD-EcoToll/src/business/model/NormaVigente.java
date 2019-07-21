package business.model;

public class NormaVigente {
	

	private String norma;
	private int idnorma;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idnorma;
		result = prime * result + ((norma == null) ? 0 : norma.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof NormaVigente))
			return false;
		NormaVigente other = (NormaVigente) obj;
		if (idnorma != other.idnorma)
			return false;
		if (norma == null) {
			if (other.norma != null)
				return false;
		} else if (!norma.equals(other.norma))
			return false;
		return true;
	}
	
	
}
