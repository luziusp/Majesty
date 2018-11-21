package ch.majesty.model;
/*
 * PLU  31.10.2018
 */

import java.util.Stack;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Infirmary {
	private Stack<CardType> patients;
	
	public void add(CardType card) {
		patients.add(card);
	}
	public Infirmary() {
		patients = new Stack<CardType>();
	}
	
	public void heal(Player player) {
		if(!patients.isEmpty()) {
			
		CardType healed = patients.pop();
		
		switch (healed) {
		
		case MILLER : player.getLoc().changeMill(1);		
		break;
		
		case BREWER : player.getLoc().changeBrewery(1);		
		break;
		
		case WITCH : player.getLoc().changeCottage(1);		
		break;
		
		case GUARD : player.getLoc().changeGuardhouse(1);		
		break;
		
		case KNIGHT : player.getLoc().changeBarracks(1);		
		break;
		
		case INNKEEPER : player.getLoc().changePub(1);		
		break;
		
		case NOBLE : player.getLoc().changeCastle(1);		
		break;
		
		
		
		}
		
	}
	}

}
