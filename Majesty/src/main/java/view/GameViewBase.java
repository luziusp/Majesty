package view;

import javafx.geometry.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import java.lang.*;
import javafx.scene.layout.*;
import javafx.scene.layout.AnchorPane;

public abstract class GameViewBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Region region;
    protected final Label label;
    protected final HBox hBox;
    protected final Hyperlink hyperlink;
    protected final Button button;
    protected final Button button0;
    protected final VBox vBox;
    protected final HBox hBox0;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final ImageView imageView4;
    protected final ImageView imageView5;
    protected final ImageView imageView6;
    protected final ImageView imageView7;
    protected final ImageView imageView8;
    protected final HBox hBox1;
    protected final Button button1;
    protected final ImageView imageView9;
    protected final Button button2;
    protected final ImageView imageView10;
    protected final Button button3;
    protected final ImageView imageView11;
    protected final Button button4;
    protected final ImageView imageView12;
    protected final Button button5;
    protected final ImageView imageView13;
    protected final Button button6;
    protected final ImageView imageView14;
    protected final ImageView imageView15;
    protected final HBox hBox2;
    protected final ImageView imageView16;
    protected final ImageView imageView17;
    protected final ImageView imageView18;
    protected final ImageView imageView19;
    protected final ImageView imageView110;
    protected final ImageView imageView111;
    protected final ImageView imageView112;
    protected final ImageView imageView113;
    protected final ImageView imageView114;

    public GameViewBase() {

        imageView = new ImageView();
        region = new Region();
        label = new Label();
        hBox = new HBox();
        hyperlink = new Hyperlink();
        button = new Button();
        button0 = new Button();
        vBox = new VBox();
        hBox0 = new HBox();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        imageView4 = new ImageView();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        imageView7 = new ImageView();
        imageView8 = new ImageView();
        hBox1 = new HBox();
        button1 = new Button();
        imageView9 = new ImageView();
        button2 = new Button();
        imageView10 = new ImageView();
        button3 = new Button();
        imageView11 = new ImageView();
        button4 = new Button();
        imageView12 = new ImageView();
        button5 = new Button();
        imageView13 = new ImageView();
        button6 = new Button();
        imageView14 = new ImageView();
        imageView15 = new ImageView();
        hBox2 = new HBox();
        imageView16 = new ImageView();
        imageView17 = new ImageView();
        imageView18 = new ImageView();
        imageView19 = new ImageView();
        imageView110 = new ImageView();
        imageView111 = new ImageView();
        imageView112 = new ImageView();
        imageView113 = new ImageView();
        imageView114 = new ImageView();

        setLayoutX(1.0);
        setLayoutY(5.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1018.0);

        imageView.setFitHeight(635.0);
        imageView.setFitWidth(1036.0);
        imageView.setLayoutX(-1.0);
        imageView.setLayoutY(65.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("../images/general/holztisch.jpg").toExternalForm()));

        AnchorPane.setLeftAnchor(region, -1.0);
        AnchorPane.setRightAnchor(region, 0.0);
        AnchorPane.setTopAnchor(region, -6.0);
        region.setLayoutX(-1.0);
        region.setLayoutY(-6.0);
        region.setPrefHeight(72.0);
        region.setPrefWidth(1018.0);
        region.getStyleClass().add("regione");
        region.getStylesheets().add("/view/style.css");

        AnchorPane.setLeftAnchor(label, 20.0);
        label.setLayoutX(20.0);
        label.setLayoutY(16.0);
        label.getStyleClass().add("labelWindowTitle");
        label.getStylesheets().add("/view/style.css");
        label.setText("Majesty - Spiel");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("System Bold", 20.0));

        AnchorPane.setBottomAnchor(hBox, 20.0);
        AnchorPane.setRightAnchor(hBox, 20.0);
        hBox.setLayoutX(884.0);
        hBox.setLayoutY(673.0);
        hBox.setPrefHeight(31.0);
        hBox.setPrefWidth(310.0);
        hBox.setSpacing(20.0);

        hyperlink.setAccessibleRole(javafx.scene.AccessibleRole.BUTTON);
        hyperlink.setOnAction(this::spielregelnButton);
        hyperlink.setPrefHeight(27.0);
        hyperlink.setPrefWidth(100.0);
        hyperlink.setText("Spielregeln");
        hyperlink.setTextFill(javafx.scene.paint.Color.WHITE);
        hyperlink.setUnderline(true);
        hyperlink.setFont(new Font("System Bold", 15.0));

        button.setLayoutX(10.0);
        button.setLayoutY(10.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::handleAbbrechen);
        button.getStylesheets().add("/view/style.css");
        button.setText("Abbrechen");
        button.setTextFill(javafx.scene.paint.Color.WHITE);

        button0.setMnemonicParsing(false);
        button0.setOnAction(this::handleAbmelden);
        button0.getStylesheets().add("/view/style.css");
        button0.setText("Abmelden");
        button0.setTextFill(javafx.scene.paint.Color.WHITE);

        AnchorPane.setBottomAnchor(vBox, 160.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);
        AnchorPane.setTopAnchor(vBox, 160.0);
        vBox.setLayoutX(73.0);
        vBox.setLayoutY(171.0);
        vBox.setPrefHeight(200.0);
        vBox.setPrefWidth(100.0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);
        hBox0.setRotate(180.0);
        hBox0.setSpacing(5.0);

        imageView0.setFitHeight(131.0);
        imageView0.setFitWidth(70.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../images/locations/Muehle.jpg").toExternalForm()));
        
        imageView1.setFitHeight(131.0);
        imageView1.setFitWidth(70.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../images/locations/Brauerei.jpg").toExternalForm()));

        imageView2.setFitHeight(131.0);
        imageView2.setFitWidth(70.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("../images/locations/Hexenhaus.jpg").toExternalForm()));

        imageView3.setFitHeight(131.0);
        imageView3.setFitWidth(70.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("../images/locations/Wachturm.jpg").toExternalForm()));

        imageView4.setFitHeight(131.0);
        imageView4.setFitWidth(70.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("../images/locations/Kaserne.jpg").toExternalForm()));

        imageView5.setFitHeight(131.0);
        imageView5.setFitWidth(70.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("../images/locations/Caverne.jpg").toExternalForm()));

        imageView6.setFitHeight(131.0);
        imageView6.setFitWidth(70.0);
        imageView6.setPickOnBounds(true);
        imageView6.setPreserveRatio(true);
        imageView6.setImage(new Image(getClass().getResource("../images/locations/Schloss.jpg").toExternalForm()));

        imageView7.setFitHeight(131.0);
        imageView7.setFitWidth(70.0);
        imageView7.setPickOnBounds(true);
        imageView7.setPreserveRatio(true);
        imageView7.setImage(new Image(getClass().getResource("../images/locations/Lazarett.jpg").toExternalForm()));

        imageView8.setFitHeight(120.0);
        imageView8.setFitWidth(120.0);
        imageView8.setPickOnBounds(true);
        imageView8.setPreserveRatio(true);
        imageView8.setImage(new Image(getClass().getResource("../images/meeples_cards/Meeple_red.jpg").toExternalForm()));
        hBox0.setPadding(new Insets(20.0, 0.0, 0.0, 0.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(615.0);
        hBox1.setSpacing(5.0);

        button1.setMnemonicParsing(false);
        button1.setOnAction(this::takeFirstCard);

        imageView9.setFitHeight(131.0);
        imageView9.setFitWidth(70.0);
        imageView9.setPickOnBounds(true);
        imageView9.setPreserveRatio(true);
        imageView9.setImage(new Image(getClass().getResource("../images/character_cards/Adlige.jpg").toExternalForm()));
        button1.setGraphic(imageView9);

        button2.setMnemonicParsing(false);
        button2.setOnAction(this::takeSecondCard);

        imageView10.setFitHeight(131.0);
        imageView10.setFitWidth(70.0);
        imageView10.setPickOnBounds(true);
        imageView10.setPreserveRatio(true);
        imageView10.setImage(new Image(getClass().getResource("../images/character_cards/Brauer.jpg").toExternalForm()));
        button2.setGraphic(imageView10);

        button3.setMnemonicParsing(false);
        button3.setOnAction(this::takeThirdCard);

        imageView11.setFitHeight(131.0);
        imageView11.setFitWidth(70.0);
        imageView11.setPickOnBounds(true);
        imageView11.setPreserveRatio(true);
        imageView11.setImage(new Image(getClass().getResource("../images/character_cards/Muellerin.jpg").toExternalForm()));
        button3.setGraphic(imageView11);

        button4.setMnemonicParsing(false);
        button4.setOnAction(this::takeFourthCard);

        imageView12.setFitHeight(131.0);
        imageView12.setFitWidth(70.0);
        imageView12.setPickOnBounds(true);
        imageView12.setPreserveRatio(true);
        imageView12.setImage(new Image(getClass().getResource("../images/character_cards/Wachen.jpg").toExternalForm()));
        button4.setGraphic(imageView12);

        button5.setMnemonicParsing(false);
        button5.setOnAction(this::takeFifthCard);

        imageView13.setFitHeight(131.0);
        imageView13.setFitWidth(70.0);
        imageView13.setPickOnBounds(true);
        imageView13.setPreserveRatio(true);
        imageView13.setImage(new Image(getClass().getResource("../images/character_cards/Wirt.jpg").toExternalForm()));
        button5.setGraphic(imageView13);

        button6.setMnemonicParsing(false);
        button6.setOnAction(this::takeSixthCard);

        imageView14.setFitHeight(131.0);
        imageView14.setFitWidth(70.0);
        imageView14.setPickOnBounds(true);
        imageView14.setPreserveRatio(true);
        imageView14.setImage(new Image(getClass().getResource("../images/character_cards/Soldat.jpg").toExternalForm()));
        button6.setGraphic(imageView14);

        imageView15.setFitHeight(131.0);
        imageView15.setFitWidth(70.0);
        imageView15.setPickOnBounds(true);
        imageView15.setPreserveRatio(true);
        imageView15.setImage(new Image(getClass().getResource("../images/backs/Back_Green.jpg").toExternalForm()));
        hBox1.setPadding(new Insets(10.0, 0.0, 10.0, 0.0));

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(615.0);
        hBox2.setSpacing(5.0);

        imageView16.setFitHeight(131.0);
        imageView16.setFitWidth(70.0);
        imageView16.setPickOnBounds(true);
        imageView16.setPreserveRatio(true);
        imageView16.setImage(new Image(getClass().getResource("../images/locations/Muehle.jpg").toExternalForm()));

        imageView17.setFitHeight(131.0);
        imageView17.setFitWidth(70.0);
        imageView17.setPickOnBounds(true);
        imageView17.setPreserveRatio(true);
        imageView17.setImage(new Image(getClass().getResource("../images/locations/Brauerei.jpg").toExternalForm()));

        imageView18.setFitHeight(131.0);
        imageView18.setFitWidth(70.0);
        imageView18.setPickOnBounds(true);
        imageView18.setPreserveRatio(true);
        imageView18.setImage(new Image(getClass().getResource("../images/locations/Hexenhaus.jpg").toExternalForm()));

        imageView19.setFitHeight(131.0);
        imageView19.setFitWidth(70.0);
        imageView19.setPickOnBounds(true);
        imageView19.setPreserveRatio(true);
        imageView19.setImage(new Image(getClass().getResource("../images/locations/Wachturm.jpg").toExternalForm()));

        imageView110.setFitHeight(131.0);
        imageView110.setFitWidth(70.0);
        imageView110.setPickOnBounds(true);
        imageView110.setPreserveRatio(true);
        imageView110.setImage(new Image(getClass().getResource("../images/locations/Kaserne.jpg").toExternalForm()));

        imageView111.setFitHeight(131.0);
        imageView111.setFitWidth(70.0);
        imageView111.setPickOnBounds(true);
        imageView111.setPreserveRatio(true);
        imageView111.setImage(new Image(getClass().getResource("../images/locations/Caverne.jpg").toExternalForm()));

        imageView112.setFitHeight(131.0);
        imageView112.setFitWidth(70.0);
        imageView112.setPickOnBounds(true);
        imageView112.setPreserveRatio(true);
        imageView112.setImage(new Image(getClass().getResource("../images/locations/Schloss.jpg").toExternalForm()));

        imageView113.setFitHeight(131.0);
        imageView113.setFitWidth(70.0);
        imageView113.setPickOnBounds(true);
        imageView113.setPreserveRatio(true);
        imageView113.setImage(new Image(getClass().getResource("../images/locations/Lazarett.jpg").toExternalForm()));

        imageView114.setFitHeight(120.0);
        imageView114.setFitWidth(120.0);
        imageView114.setPickOnBounds(true);
        imageView114.setPreserveRatio(true);
        imageView114.setImage(new Image(getClass().getResource("../images/meeples_cards/Meeple.jpg").toExternalForm()));
        hBox2.setPadding(new Insets(20.0, 0.0, 0.0, 0.0));

        getChildren().add(imageView);
        getChildren().add(region);
        getChildren().add(label);
        hBox.getChildren().add(hyperlink);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button0);
        getChildren().add(hBox);
        hBox0.getChildren().add(imageView0);
        hBox0.getChildren().add(imageView1);
        hBox0.getChildren().add(imageView2);
        hBox0.getChildren().add(imageView3);
        hBox0.getChildren().add(imageView4);
        hBox0.getChildren().add(imageView5);
        hBox0.getChildren().add(imageView6);
        hBox0.getChildren().add(imageView7);
        hBox0.getChildren().add(imageView8);
        vBox.getChildren().add(hBox0);
        hBox1.getChildren().add(button1);
        hBox1.getChildren().add(button2);
        hBox1.getChildren().add(button3);
        hBox1.getChildren().add(button4);
        hBox1.getChildren().add(button5);
        hBox1.getChildren().add(button6);
        hBox1.getChildren().add(imageView15);
        vBox.getChildren().add(hBox1);
        hBox2.getChildren().add(imageView16);
        hBox2.getChildren().add(imageView17);
        hBox2.getChildren().add(imageView18);
        hBox2.getChildren().add(imageView19);
        hBox2.getChildren().add(imageView110);
        hBox2.getChildren().add(imageView111);
        hBox2.getChildren().add(imageView112);
        hBox2.getChildren().add(imageView113);
        hBox2.getChildren().add(imageView114);
        vBox.getChildren().add(hBox2);
        getChildren().add(vBox);

    }

    protected abstract void spielregelnButton(javafx.event.ActionEvent actionEvent);

    protected abstract void handleAbbrechen(javafx.event.ActionEvent actionEvent);

    protected abstract void handleAbmelden(javafx.event.ActionEvent actionEvent);

    protected abstract void takeFirstCard(javafx.event.ActionEvent actionEvent);

    protected abstract void takeSecondCard(javafx.event.ActionEvent actionEvent);

    protected abstract void takeThirdCard(javafx.event.ActionEvent actionEvent);

    protected abstract void takeFourthCard(javafx.event.ActionEvent actionEvent);

    protected abstract void takeFifthCard(javafx.event.ActionEvent actionEvent);

    protected abstract void takeSixthCard(javafx.event.ActionEvent actionEvent);

}
