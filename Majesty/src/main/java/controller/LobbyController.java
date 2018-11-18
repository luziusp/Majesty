package controller;

import java.util.Observable;
import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class LobbyController {
	
	private Main main;
	private Stage stage;
	
	@FXML
	private Label player1Label;
	
	public void setMain(Main main) {
		this.main = main;
	}

	public void initialize() {
		// diese methode braucht man um das mapping model->view zu erstellen.
		// diese methode muss initialize heissen!
																					// überschrieben!
	}

	public void handleAbmelden() {
		stage.close();
		main.loginWindow();
	}

	public void handleEdit() {

	}
	
	public void infoButton() {
		Alert alert = new Alert (AlertType.INFORMATION);
		alert.setTitle("Majesty - Info");
		alert.setHeaderText("Information");
		alert.setContentText("Klicken Sie ein verfügbaren Gegner an und fordern Sie ihn mittels Button 'Spiel eröffnen' zu einem Spiel aus.");
		alert.showAndWait();
	}
	
	public void spielEroeffnen() {
		main.gameWindow();
	}
	
	public void spielregelnButton() {
		
	}

	public void refreshTableView() {

	}

	public void handleDelete() {

	}

	public void handleBeenden() {
		System.exit(0);
	}

	public void handleSave() {
		main.savePlayers();
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}

}
