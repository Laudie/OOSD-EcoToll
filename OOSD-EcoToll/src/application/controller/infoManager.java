package application.controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public abstract class infoManager {
	//InfoBox
	public static void infoBox(String infoMessage, String titleBar, String headerMessage, String msgType)
    {
		Alert alert = new Alert(AlertType.valueOf(msgType));
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }
}
