package controller;

import java.util.ArrayList;
import java.util.List;

import ch.majesty.model.Player;
import ch.majesty.userdb.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class NewPlayerController {

	@FXML
	TextField benutzernameField, passwortField;

	private Stage stage;
	private Main main;
	private boolean okClicked = false;

	public void setPlayer(Player player) {
		
		if (player != null) { // wenn wirklich eine person dahinter ist, dann
								// übernimmt er alle textfelder von der
								// ausgewählten person.
			fillPlayerDetails();
		}
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void handleAbbrechen() {
		stage.close();
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	public void handleBestaetitung() {

		List<String> fehlerhafteFelder = new ArrayList<String>();
		

		List<String> mussFelder = new ArrayList<String>();
		mussFelder.add(benutzernameField.getText());
		mussFelder.add(passwortField.getText());


		List<String> fehlerhafteMussFelder = new ArrayList<String>();
		for (String feld : mussFelder) {
			if (feld.isEmpty()) {
				fehlerhafteMussFelder.add(feld);
			}
		}

		if (!fehlerhafteMussFelder.isEmpty()) {
			String fehlerTextMuss = "Foldende Felder müssen noch gesetzt werden: \n\n";

			if (benutzernameField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Benutzername\n";
			}
			if (passwortField.getText().isEmpty()) {
				fehlerTextMuss = fehlerTextMuss + "Passwort\n";
			;
			}
			fehlerhafteFelder(fehlerTextMuss);
		} else if (!fehlerhafteFelder.isEmpty()) {
			String fehlerTextZahl = "Folgende Felder müssen eine Ganzzahl sein: \n";
			
			fehlerhafteFelder(fehlerTextZahl);

		} else {

			if (user != null) { // wenns die person gibt, passt er die werte
									// an
									// (überschreibt nur)
				user.setLogin(benutzernameField.getText());
				user.setPassword(passwortField.getText());
			} else {
				User user = new User(benutzernameField.getText(), // wenns
																				// die
																				// person
																				// nicht
																				// gibt,
																				// dann
																				// wird
																				// hier
																				// eine
																				// erstellt.
						passwortField.getText(), 0, 0);
		//DEPRICATED		main.getPlayerData().add(user);
				//TODO Add player to DB
			}
			okClicked = true;
			main.savePlayers();
			stage.close();
		}
	}

	public void fillPlayerDetails() {
		benutzernameField.setText(user.getLogin());
		passwortField.setText(user.getPassword());
	}

	private boolean validiereZahl(String feld) {
		try {
			Integer.valueOf(feld);
		} catch (Exception e) {
			return false;
		}
		return true;
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
