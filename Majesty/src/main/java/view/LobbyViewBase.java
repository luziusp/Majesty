package view;

import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.scene.layout.AnchorPane;

public abstract class LobbyViewBase extends AnchorPane {

    protected final Region region;
    protected final Label label;
    protected final HBox hBox;
    protected final Button button;
    protected final Button button0;
    protected final Hyperlink hyperlink;
    protected final VBox vBox;
    protected final VBox vBox0;
    protected final ImageView imageView;
    protected final Label player1Label;
    protected final VBox vBox1;
    protected final Button button1;
    protected final ImageView imageView0;
    protected final Label label0;

    public LobbyViewBase() {

        region = new Region();
        label = new Label();
        hBox = new HBox();
        button = new Button();
        button0 = new Button();
        hyperlink = new Hyperlink();
        vBox = new VBox();
        vBox0 = new VBox();
        imageView = new ImageView();
        player1Label = new Label();
        vBox1 = new VBox();
        button1 = new Button();
        imageView0 = new ImageView();
        label0 = new Label();

        setLayoutX(1.0);
        setLayoutY(5.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1018.0);

        AnchorPane.setLeftAnchor(region, -1.0);
        AnchorPane.setRightAnchor(region, -1.0);
        AnchorPane.setTopAnchor(region, -6.0);
        region.setLayoutX(-1.0);
        region.setLayoutY(-6.0);
        region.setPrefHeight(71.0);
        region.setPrefWidth(801.0);
        region.getStyleClass().add("regione");
        region.getStylesheets().add("/view/style.css");

        AnchorPane.setLeftAnchor(label, 20.0);
        label.setLayoutX(20.0);
        label.setLayoutY(16.0);
        label.getStyleClass().add("labelWindowTitle");
        label.getStylesheets().add("/view/style.css");
        label.setText("Majesty - Lobby");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 20.0));

        AnchorPane.setBottomAnchor(hBox, 20.0);
        AnchorPane.setRightAnchor(hBox, 40.0);
        hBox.setLayoutX(884.0);
        hBox.setLayoutY(673.0);
        hBox.setPrefHeight(27.0);
        hBox.setPrefWidth(172.0);
        hBox.setSpacing(20.0);

        button.setLayoutX(10.0);
        button.setLayoutY(10.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::handleBeenden);
        button.getStylesheets().add("/view/style.css");
        button.setText("Beenden");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        button0.setMnemonicParsing(false);
        button0.setOnAction(this::handleAbmelden);
        button0.getStylesheets().add("/view/style.css");
        button0.setText("Abmelden");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);

        AnchorPane.setBottomAnchor(hyperlink, 20.0);
        AnchorPane.setLeftAnchor(hyperlink, 40.0);
        hyperlink.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hyperlink.setLayoutX(57.0);
        hyperlink.setLayoutY(595.0);
        hyperlink.setOnAction(this::infoButton);
        hyperlink.setText("Information");
        hyperlink.setUnderline(true);

        AnchorPane.setRightAnchor(vBox, 40.0);
        vBox.setLayoutX(766.0);
        vBox.setLayoutY(195.0);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(144.0);

        vBox0.setPrefHeight(152.0);
        vBox0.setPrefWidth(127.0);

        imageView.setFitHeight(127.0);
        imageView.setFitWidth(138.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../images/general/player.png").toExternalForm()));

        player1Label.setAlignment(javafx.geometry.Pos.CENTER);
        player1Label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        player1Label.setText("Player 1");

        vBox1.setPrefHeight(175.0);
        vBox1.setPrefWidth(144.0);

        button1.setMnemonicParsing(false);
        button1.setOnAction(this::spielEroeffnen);

        imageView0.setFitHeight(146.0);
        imageView0.setFitWidth(126.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../images/general/gamestart.png").toExternalForm()));
        button1.setGraphic(imageView0);

        label0.setText("Spiel eröffnen");

        getChildren().add(region);
        getChildren().add(label);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        getChildren().add(hBox);
        getChildren().add(hyperlink);
        vBox0.getChildren().add(imageView);
        vBox0.getChildren().add(player1Label);
        vBox.getChildren().add(vBox0);
        vBox1.getChildren().add(button1);
        vBox1.getChildren().add(label0);
        vBox.getChildren().add(vBox1);
        getChildren().add(vBox);

    }

    protected abstract void handleBeenden(javafx.event.ActionEvent actionEvent);

    protected abstract void handleAbmelden(javafx.event.ActionEvent actionEvent);

    protected abstract void infoButton(javafx.event.ActionEvent actionEvent);

    protected abstract void spielEroeffnen(javafx.event.ActionEvent actionEvent);

}
