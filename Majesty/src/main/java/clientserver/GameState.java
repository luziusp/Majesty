package clientserver;

import java.io.Serializable;

import ch.majesty.model.Infirmary;
import ch.majesty.model.Locations;
import ch.majesty.model.Market;
import ch.majesty.model.MeepleCard;
import ch.majesty.model.Players;
import ch.majesty.userdb.User;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameState implements Serializable{
	Market market;
	Players players;

	public GameState(Market market, Players players) {
		this.market = market;
		this.players = players;
	}
}
