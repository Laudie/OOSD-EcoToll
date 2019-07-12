package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AmministratoreController implements Initializable {

	@FXML private ComboBox<String> ScegliC;
	@FXML private Label lblUser;
	@FXML private Label lblsuccesso;
	public AppModel caselloModel = new AppModel();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			ScegliC.setItems(FXCollections.observableArrayList(fillComboCasello()));
		} catch (SQLException e) {			
			e.printStackTrace();
		}

	}
	
	public void eliminaCasello(ActionEvent event) throws SQLException {
		
		
		String casello=ScegliC.getValue();
		if(caselloModel.eliminaCasello(casello)) {
			lblsuccesso.setText("Casello eliminato con successo");
		}
		else {
		lblsuccesso.setText("Impossibile eliminare il casello");
		}
	}
	
	public void getUserdata (String user) {	
	lblUser.setText("Ciao " + user);
	}	
	
	
	public List<String> fillComboCasello() throws SQLException {		
		PreparedStatement pst =null;
		ResultSet rst =null;		
		String qry="select casello from EcoToll.casello limit 15;";		
		List<String> lista = new ArrayList<String>();
		try {
			pst =AppModel.conection.prepareStatement(qry);
			rst = pst.executeQuery();
			while (rst.next()) {
				lista.add(rst.getString("casello"));						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pst.close();
			rst.close();
		}
		return lista;		
	}
}