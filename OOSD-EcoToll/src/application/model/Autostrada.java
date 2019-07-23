package application.model;

import java.util.List;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class Autostrada {

	@Override
	public String toString() {
		return getIdautostrada() ;
	}

	private StringProperty idautostrada =new SimpleStringProperty();	
	private StringProperty nomeautostrada = new SimpleStringProperty();
	private StringProperty da = new SimpleStringProperty();
	private StringProperty a = new SimpleStringProperty();	
	private IntegerProperty lunghezza =new SimpleIntegerProperty();	
	private DoubleProperty tariffa =new SimpleDoubleProperty();
	
	private final ObservableList<Autostrada> autostrade;
	
	public Autostrada() {
		idautostrada=new SimpleStringProperty();
		nomeautostrada=new SimpleStringProperty();
		da=new SimpleStringProperty();
		a=new SimpleStringProperty();
		lunghezza =new SimpleIntegerProperty();
		
		autostrade=FXCollections.observableArrayList();
	}
	
	
	// Define a getter for the property's value
	public final String getIdautostrada() {return idautostrada.get();}
	public final String getNomeautostrada() {return nomeautostrada.get();}
	public final String getDa() {return da.get();}
	public final String getA() {return a.get();}
	public final int getLunghezza() {return lunghezza.get();}
	public final double getTariffa() {return tariffa.get();}
	
	// Define a setter for the property's value
	public final void setIdautostrada(String value) {idautostrada.set(value);}
	public final void setNomeautostrada(String value) {nomeautostrada.set(value);}
	public final void setDa(String value) {da.set(value);}
	public final void setA(String value) {a.set(value);}
	public final void setLunghezza(int value) {lunghezza.set(value);}
	public final void setTariffa(double value) {tariffa.set(value);}
	
	public StringProperty idautostradaProperty() {return idautostrada;}
	public StringProperty nomeautostradaProperty() {return nomeautostrada;}
	public StringProperty daProperty() {return da;}
	public StringProperty aProperty() {return a;}
	public IntegerProperty lunghezzaProperty() {return lunghezza;}
	public DoubleProperty tariffaProperty() {return tariffa;}
	
	public List<Autostrada> getElencoAutostrade() {
		return this.autostrade;
	}
	
	public void setElencoAutostrade(List<Autostrada> autostrade) {
		this.autostrade.setAll(autostrade);
	}
	
	public ObservableList<Autostrada> autostradaObsList() {
		return this.autostrade;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Autostrada))
			return false;
		Autostrada other = (Autostrada) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (autostrade == null) {
			if (other.autostrade != null)
				return false;
		} else if (!autostrade.equals(other.autostrade))
			return false;
		if (da == null) {
			if (other.da != null)
				return false;
		} else if (!da.equals(other.da))
			return false;
		if (idautostrada == null) {
			if (other.idautostrada != null)
				return false;
		} else if (!idautostrada.equals(other.idautostrada))
			return false;
		if (lunghezza == null) {
			if (other.lunghezza != null)
				return false;
		} else if (!lunghezza.equals(other.lunghezza))
			return false;
		if (nomeautostrada == null) {
			if (other.nomeautostrada != null)
				return false;
		} else if (!nomeautostrada.equals(other.nomeautostrada))
			return false;
		if (tariffa == null) {
			if (other.tariffa != null)
				return false;
		} else if (!tariffa.equals(other.tariffa))
			return false;
		return true;
	}
}
