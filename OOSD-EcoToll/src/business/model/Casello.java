package business.model;

import business.model.Autostrada;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/*
 * package propertydemo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
 
class Bill {
 
    // Define a variable to store the property
    private DoubleProperty amountDue = new SimpleDoubleProperty();
 
    // Define a getter for the property's value
    public final double getAmountDue(){return amountDue.get();}
 
    // Define a setter for the property's value
    public final void setAmountDue(double value){amountDue.set(value);}
 
     // Define a getter for the property itself
    public DoubleProperty amountDueProperty() {return amountDue;}
 
}*/

public class Casello {
	
	private IntegerProperty idcasello =new SimpleIntegerProperty();	
	private IntegerProperty altezza = new SimpleIntegerProperty();
	private StringProperty nomecasello = new SimpleStringProperty();
	private Autostrada autostrada =new Autostrada();
	
	
// Define a getter for the property's value
	public final int getIdcasello() {return idcasello.get();}
	public final int getAltezza() {return altezza.get();}
	public final String getNomecasello() {return nomecasello.get();}

// Define a setter for the property's value
	public final void setIdcasello(int value) {idcasello.set(value);}
	public final void setAltezza(int value) {altezza.set(value);}
	public final void setNomecasello(String value) {nomecasello.set(value);}
	
// Define a getter for the property itself
    public IntegerProperty idcaselloProperty() {return idcasello;}
    public IntegerProperty altezzaProperty() {return altezza;}
    public StringProperty nomecaselloProperty() {return nomecasello;}
 	
	
	public Autostrada geAutostrada() {
		return this.autostrada;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Casello))
			return false;
		Casello other = (Casello) obj;
		if (altezza == null) {
			if (other.altezza != null)
				return false;
		} else if (!altezza.equals(other.altezza))
			return false;
		if (autostrada == null) {
			if (other.autostrada != null)
				return false;
		} else if (!autostrada.equals(other.autostrada))
			return false;
		if (idcasello == null) {
			if (other.idcasello != null)
				return false;
		} else if (!idcasello.equals(other.idcasello))
			return false;
		if (nomecasello == null) {
			if (other.nomecasello != null)
				return false;
		} else if (!nomecasello.equals(other.nomecasello))
			return false;
		return true;
	}

	
}
