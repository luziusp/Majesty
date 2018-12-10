package ch.majesty.model;
/*
 * PLU  31.10.2018
 */

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Player")
@Getter @Setter @NoArgsConstructor
public class Player implements Serializable{
	private String user;
	private boolean yourTurn;
	private Locations loc;
	private Infirmary inf;
	private int currentScore;
	private MeepleCard mc;
	
	public void changeScore(int i) {
		this.currentScore += i;
		System.out.println(this.user + " score increased by " +i + " to a total of: "+ this.getCurrentScore());
	}
	
	public void resolveMC() {
		changeScore(this.mc.resolve());
	}
	
	
	public Player(String user) {
		this.user = user;
		this.yourTurn = false;
		this.loc = new Locations();
		this.inf = new Infirmary();
		this.currentScore =0;
		this.mc = new MeepleCard();

		
	}
	
	public int calcEndScore(Players pl){
		
		int variety= this.calcVar();
		int infirmary = this.calcInf();
		int majority = this.calcMaj(pl);
		System.out.println("Endscore of Player "+ this.user +" " + (this.getCurrentScore() + variety  + majority - infirmary));
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
	
	private int calcMaj(Players pl) {
		int maj=0;
		
		/*NOTE:
		 * if the player has the most cards of a group add points:
		 * Mill +10
		 * Brewery +11
		 * Cottage +12
		 * guardhouse +13
		 * barracks +14
		 * pub +15
		 * castle +16
		 */
		if(loc.isMaxValue(pl, CardType.MILLER)) {
			maj += 10;
		}
		if(loc.isMaxValue(pl, CardType.BREWER)) {
			maj += 11;
		}
		if(loc.isMaxValue(pl, CardType.WITCH)) {
			maj += 12;
		}
		if(loc.isMaxValue(pl, CardType.GUARD)) {
			maj += 13;
		}
		if(loc.isMaxValue(pl, CardType.KNIGHT)) {
			maj += 14;
		}
		if(loc.isMaxValue(pl, CardType.INNKEEPER)) {
			maj += 15;
		}
		if(loc.isMaxValue(pl, CardType.NOBLE)) {
			maj += 16;
		}
		
		return maj;
	}
	

}
