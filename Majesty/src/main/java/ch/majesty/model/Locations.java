package ch.majesty.model;
/*
 * PLU  31.10.2018
 */

import ch.majesty.userdb.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
