package ch.majesty.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

public class Players implements Serializable {

	@XmlElement(name = "Player", type = Player.class)
	private ArrayList<Player> playerData;

	public Players() {
		this.playerData = new  ArrayList<Player>();
	}
	


	public Players(ArrayList<Player> PlayerData) {
		this.playerData = PlayerData;
	}

	public ArrayList<Player> getPlayersData() {
		return playerData;
	}

	public void setPlayerData(ArrayList<Player> PlayerData) {
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

