package ch.majesty.model;
/*
 * PLU  31.10.2018
 */

import ch.majesty.userdb.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Player {
	private User user;
	private boolean youTurn;
	private Locations loc;
	private Infirmary inf;
	private int currentScore;
	private int endScore;
	private MeepleCard mc;
	
	public void changeScore(int i) {
		this.currentScore += i;
	}
	
	public Player(User us) {
		this.user = us;
		this.youTurn = false;
		this.loc = new Locations();
		this.currentScore =0;
		this.mc = new MeepleCard();
		this.endScore =0;
		
	}

}
