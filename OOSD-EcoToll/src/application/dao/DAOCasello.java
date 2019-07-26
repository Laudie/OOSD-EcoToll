package application.dao;

import java.util.List;

import application.model.Casello;

public interface DAOCasello {
	
	public List<Casello> getAllCasello();
	
	public Casello getCasello(int id);
				
	public boolean addCasello(Casello casello);
			
	public boolean deleteCasello(Casello casello );

}
