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
	private boolean yourTurn;
	private Locations loc;
	private Infirmary inf;
	private int currentScore;
	private int endScore;
	private MeepleCard mc;
	
	public void changeScore(int i) {
		this.currentScore += i;
		System.out.println(this.user.getLogin() + " score increased by " +i + " to a total of: "+ this.getCurrentScore());
	}
	
	public Player(User us) {
		this.user = us;
		this.yourTurn = false;
		this.loc = new Locations();
		this.currentScore =0;
		this.mc = new MeepleCard();
		this.endScore =0;
		
	}
	
	public int calcEndScore(){
		
		int variety= this.calcVar();
		int infirmary = this.calcInf();
		int majority = this.calcMaj();
		
		return this.getCurrentScore() + variety  + majority - infirmary;
		
	}
	
	private int calcVar() {
		int var=0;
		if(this.getLoc().getMill() > 0)
			var++;
		if(this.getLoc().getBrewery() > 0)
			var++;
		if(this.getLoc().getCottage() > 0)
			var++;
		if(this.getLoc().getGuardhouse() > 0)
			var++;
		if(this.getLoc().getBarracks() > 0)
			var++;
		if(this.getLoc().getPub() > 0)
			var++;
		if(this.getLoc().getCastle() > 0)
			var++;		
		
		return var*var;
	}
	
	private int calcInf() {
		int inf=0;
		
		while(!this.getInf().getPatients().isEmpty()) {
			this.getInf().getPatients().pop();
			inf++;
		}
		
		return inf;
	}
	
	private int calcMaj() {
		int maj=0;
		
		//TODO: calculate majority score: (write compare function in locations)
		/*
		 * if the player has the most cards of a group add points:
		 * Mill +10
		 * Brewery +11
		 * Cottage +12
		 * guardhouse +13
		 * barracks +14
		 * pub +15
		 * castle +16
		 */
		
		return maj;
	}

}
