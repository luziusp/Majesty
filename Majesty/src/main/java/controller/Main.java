package controller;

import java.io.File;

import ch.majesty.model.Player;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {

	private Stage primaryStage;

	private ObservableList<Player> playerData = FXCollections.observableArrayList();

	public Main() { //das weiss VIEW noch nicht, also nicht ersichtlich, jetzt muss im mainwindowcontroller noch .... gemacht werden

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		loginWindow(); // beim start wird das loginwindow aufgebaut
	}

	public void loginWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/LoginView.fxml"));
			AnchorPane pane = loader.load(); // das erste ist AnchorPane, das
			// wird jetzt geladen!
			Scene scene = new Scene(pane); // eine szene wird gebaut!
			Stage stage = new Stage();


			scene.getStylesheets().add("view/style.css"); // CSS einbindung!

			LoginController controller = loader.getController();
			controller.setMain(this); // eigenes objekt geben!
			controller.setStage(stage);

			primaryStage.setTitle("Majesty - Login");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void gameWindow() {
		try {
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("/view/GameView.fxml"));
			AnchorPane pane = loader.load(); // das erste ist AnchorPane, das
			// wird jetzt geladen!
			Scene scene = new Scene(pane); // eine szene wird gebaut!
			Stage stage = new Stage();

			GameController controller = loader.getController();
			controller.setMain(this); // eigenes objekt geben!
			controller.setStage(stage);

			primaryStage.setTitle("Majesty - Spiel");
			primaryStage.setScene(scene);
			primaryStage.setResizable(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		launch(args);
	}

	public ObservableList<Player> getPlayerData() {
		return playerData;
	}



}
