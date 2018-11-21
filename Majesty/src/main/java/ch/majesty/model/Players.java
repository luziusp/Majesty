package ch.majesty.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Players")

public class Players {

	@XmlElement(name = "Player", type = Player.class)
	private ObservableList<Player> playerData = FXCollections.observableArrayList();

	public Players() {

	}

	public Players(ObservableList<Player> PlayerData) {
		this.playerData = PlayerData;
	}

	public ObservableList<Player> getPlayersData() {
		return playerData;
	}

	public void setPlayerData(ObservableList<Player> PlayerData) {
		this.playerData = PlayerData;
	}
	
	public Player calcWinner() {
		    int maxValue = playerData.get(0).calcEndScore(this);
		    Player winner = playerData.get(0);
		    for (int i = 1; i < playerData.size(); i++) {
		    	int enemyScore = playerData.get(i).calcEndScore(this);
		        if (enemyScore > maxValue) {
		            maxValue = enemyScore;
		            winner = playerData.get(i);
		        }
		    }
		    return winner;
		}
		
		
	}

