package ch.majesty.model;
/*
 * PLU  31.10.2018
 */


import lombok.Getter;
import lombok.Setter;
//TODO Make observable to set counts in GUI 
@Getter @Setter
public class Locations {
	int mill;
	int brewery;
	int cottage;
	int guardhouse;
	int barracks;
	int pub;
	int castle;
	
	
	
	public Locations() {
		this.mill =0;
		this.brewery=0;
		this.cottage=0;
		this.guardhouse=0;
		this.barracks=0;
		this.pub=0;
		this.castle=0;		
	}
	
	public void changeMill(int amount) {
		this.mill += amount;
	}
	
	public void changeBrewery(int amount) {
		this.brewery += amount;
	}
	public void changeCottage(int amount) {
		this.cottage += amount;
	}
	public void changeGuardhouse(int amount) {
		this.guardhouse += amount;
	}
	public void changeBarracks(int amount) {
		this.barracks += amount;
	}
	public void changePub(int amount) {
		this.pub += amount;
	}
	public void changeCastle(int amount) {
		this.castle += amount;
	}
	
	
	
	public boolean isMaxValue(Players players, CardType type) {
		boolean isMax = true;
		int thisValue;
		int compValue = 0;
		int maxValue=0;
		
		for (int i = 1; i < players.getPlayerData().size(); i++) {	
		switch (type) {
		case MILLER:
			thisValue = this.mill;
			compValue = players.getPlayerData().get(i).getLoc().getMill();
			break;
		case BREWER:
			thisValue = this.brewery;
			compValue = players.getPlayerData().get(i).getLoc().getBrewery();
			break;
		case GUARD:
			thisValue = this.guardhouse;
			compValue = players.getPlayerData().get(i).getLoc().getGuardhouse();
			break;
		case INNKEEPER:
			thisValue = this.pub;
			compValue = players.getPlayerData().get(i).getLoc().getPub();
			break;
		case KNIGHT:
			thisValue = this.barracks;
			compValue = players.getPlayerData().get(i).getLoc().getBarracks();
			break;
		case NOBLE:
			thisValue = this.castle;
			compValue = players.getPlayerData().get(i).getLoc().getCastle();
			break;
		case WITCH:
			thisValue = this.cottage;
			compValue = players.getPlayerData().get(i).getLoc().getCottage();
			break;
			
		default:
			thisValue = 0;
			break;
		}
		
		
    
	        if ((compValue > maxValue) && (compValue > thisValue)) {
	           maxValue = compValue ;
	           isMax = false;
	        }
		}	        
	    
	    return isMax;
	}
	
	
}
