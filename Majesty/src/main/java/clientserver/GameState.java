package clientserver;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ch.majesty.model.Infirmary;
import ch.majesty.model.Locations;
import ch.majesty.model.Market;
import ch.majesty.model.MeepleCard;
import ch.majesty.model.Player;
import ch.majesty.model.Players;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameState implements Serializable{
	Market market;
	Players players;
	
	//Players must be cast to Arraylist since Observable list cannot be serialized
	public GameState(Market market, Players players) {
		this.market = market;
		this.players = players;
	}
}
