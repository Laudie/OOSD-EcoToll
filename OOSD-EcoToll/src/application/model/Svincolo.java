package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


public class Svincolo {
	
	private IntegerProperty idsvincolo =new SimpleIntegerProperty();	
	private IntegerProperty km = new SimpleIntegerProperty();
	private Autostrada autostradaIn =new Autostrada();
	private Autostrada autostradaOut =new Autostrada();
	
	// Define a getter for the property's value
		public final int getIdsvincolo() {return idsvincolo.get();}
		public final int getKm() {return km.get();}
		
	// Define a setter for the property's value
		public final void setIdsvincolo(int value) {idsvincolo.set(value);}
		public final void setkm(int value) {km.set(value);}
				
	// Define a getter for the property itself
	    public IntegerProperty idsvincoloProperty() {return idsvincolo;}
	    public IntegerProperty kmProperty() {return km;}
	   
	 	
		
		public Autostrada geAutostradaIn() {
			return this.autostradaIn;
		}
	
		public Autostrada geAutostradaOut() {
			return this.autostradaOut;
		}
	
}
