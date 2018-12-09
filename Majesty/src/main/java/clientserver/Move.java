package clientserver;

import java.io.Serializable;

import ch.majesty.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Move implements Serializable {
	private int cardPlayed;
	private Player player;
	
	private Move(int cardPlayed,  Player player) {
		this.cardPlayed =  cardPlayed;
		this.player = player;
	}

}