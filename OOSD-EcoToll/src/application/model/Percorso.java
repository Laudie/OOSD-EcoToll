package application.model;

import java.time.LocalDateTime;

public class Percorso {

	Casello caselloIn;
	Casello caselloOut;
	LocalDateTime dataoraIn;
	LocalDateTime dataoraOut;
		
	public int distanza (Casello cIn, Casello cOut) {
		return Math.abs(cIn.getAltezza()-cOut.getAltezza());
	}
	
}
