package ch.majesty.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Players")

public class Players {

	@XmlElement(name = "Player", type = Player.class)
	private ObservableList<Player> PlayerData = FXCollections.observableArrayList();

	public Players() {

	}

	public Players(ObservableList<Player> PlayerData) {
		this.PlayerData = PlayerData;
	}

	public ObservableList<Player> getPlayersData() {
		return PlayerData;
	}

	public void setPlayerData(ObservableList<Player> PlayerData) {
		this.PlayerData = PlayerData;
	}

}
