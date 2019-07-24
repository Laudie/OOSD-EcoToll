package application.front.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class InfoController {
	//InfoBox
	public static void infoBox(String infoMessage, String headerMessage, String msgType)
    {
		Alert alert = new Alert(AlertType.valueOf(msgType));
        alert.setTitle("OOS - EcoToll");
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
