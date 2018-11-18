package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Observable;
import java.util.Optional;

import com.sun.javafx.util.Utils;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class GameController {
	@FXML ImageView player1muehle;
	@FXML ImageView player1brauerei;
	@FXML ImageView player1hexenhaus;
	@FXML ImageView player1wachturm;
	@FXML ImageView player1kaserne;
	@FXML ImageView player1caverne;
	@FXML ImageView player1schloss;
	@FXML ImageView player1lazarett; 
	
	@FXML ImageView player2muehle;
	@FXML ImageView player2brauerei;
	@FXML ImageView player2hexenhaus;
	@FXML ImageView player2wachturm;
	@FXML ImageView player2kaserne;
	@FXML ImageView player2caverne;
	@FXML ImageView player2schloss;
	@FXML ImageView player2lazarett; 
	
	private Main main;
	private Stage stage;
	private ImageView imageView0;


	
	public void setMain(Main main) {
		this.main = main;
	}

	public void initialize() {
		// diese methode braucht man um das mapping model->view zu erstellen.
		// diese methode muss initialize heissen!
																					// überschrieben!
	}

	public void handleNew() {
		main.newPlayerWindow();
	}

	public void handleEdit() {

	}
	
	public void spielregelnButton() {
	     try {
             Desktop.getDesktop().open(new File("/Users/Gezim/Documents/workspace22/MajestyGame/src/rules/Majesty_Spielanleitung.pdf"));
         } catch (IOException e1) {
             e1.printStackTrace();
         }
	    }
	
	public void refillCards(){
		
	}
	
	@FXML
	public void takeFirstCard(ActionEvent event) {
		Image image = new Image("/images/character_cards/Adlige.jpg");
		player1schloss.setImage(image);
	}
	
	@FXML
	public void takeSecondCard(ActionEvent event) {
		Image image = new Image("/images/character_cards/Brauer.jpg");
		player1brauerei.setImage(image);
	}
	
	@FXML
	public void takeThirdCard(ActionEvent event) {
		Image image = new Image("/images/character_cards/Muellerin.jpg");
		player1muehle.setImage(image);
	}
	
	@FXML
	public void takeFourthCard(ActionEvent event) {
		Image image = new Image("/images/character_cards/Wachen.jpg");
		player1wachturm.setImage(image);
	}
	
	
	public void takeFifthCard() {
		Image image = new Image("/images/character_cards/Wirt.jpg");
		player1caverne.setImage(image);
	}
	
	public void takeSixthCard() {
		Image image = new Image("/images/character_cards/Soldat.jpg");
		player1kaserne.setImage(image);
	}
	
	

	public void handleAbbrechen() {
		stage.close();
		main.lobbyWindow();
	}

	public void handleAbmelden() {
		stage.close();
		main.loginWindow();
	}


	public void setStage(Stage stage) {
		this.stage = stage;
	}
}

