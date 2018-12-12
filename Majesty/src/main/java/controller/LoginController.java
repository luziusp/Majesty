package controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController {

	@FXML
	private TextField usernameField, ipAdressField, portField;


	private Main main;
	private Stage stage;

	public void setMain(Main main) {
		this.main = main;
		usernameField.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				KeyEvent keyEvent = (KeyEvent) event;
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					doLogin();
				}
			}
		});
		
		ipAdressField.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				KeyEvent keyEvent = (KeyEvent) event;
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					doLogin();
				}
			}
		});
		
		portField.setOnKeyPressed(new EventHandler<Event>() {

			@Override
			public void handle(Event event) {
				KeyEvent keyEvent = (KeyEvent) event;
				if (keyEvent.getCode().equals(KeyCode.ENTER)) {
					doLogin();
				}
			}
		});
	}

	public void loginButton(ActionEvent event) {
		doLogin();
	}

	private void doLogin() {
		List<String> fehlerhafteFelder = new ArrayList<>();
		

		List<String> mussFelder = new ArrayList<>();
		mussFelder.add(usernameField.getText());
		mussFelder.add(ipAdressField.getText());
		mussFelder.add(portField.getText());
		
		List<String> fehlerhafteMussFelder = new ArrayList<>();
		for (String feld : mussFelder) {
			if (feld.isEmpty()) {
				fehlerhafteMussFelder.add(feld);
			}
		}
		
		if (!fehlerhafteMussFelder.isEmpty()) {
			String fehlerTextMuss = "Foldende Felder müssen noch gesetzt werden: \n\n";

			if (usernameField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Benutzername\n";
			}
			if (ipAdressField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "IP Adresse\n";
			}
			if (portField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Port\n";
			}
			fehlerhafteFelder(fehlerTextMuss);
		} else if (!fehlerhafteFelder.isEmpty()) {
			String fehlerTextZahl = "Folgende Felder müssen eine Ganzzahl sein: \n";
			
			fehlerhafteFelder(fehlerTextZahl);


		} else {
			main.gameWindow();// methode zum stage wechseln bzw. gamewindows
			// öffnen
		}
		usernameField.clear();
		ipAdressField.clear();
		portField.clear();
	}

	@FXML
	public void handleKeyPressed(KeyEvent ke) {
		if (ke.getCode().equals(KeyCode.ENTER)) {
			doLogin();
		}
	}

	public void exitButton() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText("Abmeldung");
		alert.setContentText("Bye Bye!");
		alert.showAndWait();
		
		System.exit(0);
	}

	public void hilfeButton() {
		Alert alert = new Alert (AlertType.INFORMATION);
		alert.setTitle("Majesty - Hilfe");
		alert.setHeaderText("Hilfe");
		alert.setContentText("Wir benötigen einen Benutzername, IP-Adresse und Port, um ein Spiel zu starten. Wir wünschen Ihnen viel Spass und Glück!");
		alert.showAndWait();
}
	

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	private void fehlerhafteFelder(String fehlerText) {
		Alert alert = new Alert(AlertType.ERROR);
		DialogPane dialogPane = alert.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("/view/style.css").toExternalForm());
		dialogPane.getStyleClass().add("context-menu");
		alert.setTitle("Fehler");
		alert.setHeaderText("");
		alert.setContentText(fehlerText);
		alert.showAndWait();
	}

}