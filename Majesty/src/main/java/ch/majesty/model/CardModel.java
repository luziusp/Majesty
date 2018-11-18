package ch.majesty.model;

import ch.majesty.userdb.User;

/*
 * PLU  31.10.2018
 */



import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CardModel {

	CardType type;
	Player player;
	
	public CardModel(CardType t, Player buyer) {
		this.type = t;
		this.player = buyer;
		
	}
	
	
	
	
	
	public void playMiller() {
		player.getLoc().changeMill(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getMill() + " Miller(s)");
		player.changeScore(player.getLoc().getMill() *2);
	}
	
	public void playBrewer() {
		player.getLoc().changeBrewery(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getBrewery() + " Brewers(s)");
		player.changeScore(player.getLoc().getBrewery() *2);
		player.getMc().add(player.getLoc().getBrewery() *1);
		
		if(player.getLoc().getMill()> 0) {
			player.changeScore(2);
		}
		
		
	}
	public void playWitch() {
		
		//The witch heals a card from the infirmary
		if(player.getInf() != null) {
		player.getInf().heal(player);
		}
		else {
			System.out.println("No card could be healed");
		}
		
		int array[] = new int[3];
		player.getLoc().changeCottage(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getCottage() + " Witch(es)");
		
		//cottage gives 2 points per combo of miller, brewer, and witch
		//--> smallest value of these three * 2
		array[0] = player.getLoc().getMill();
		array[1] = player.getLoc().getBrewery();
		array[2] = player.getLoc().getCottage();
		
		player.changeScore(this.getMinValue(array));
		
	}
	public void playGuard() {
		int array[] = new int[3];
		player.getLoc().changeGuardhouse(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getGuardhouse() + " Guard(s)");
		
		//guardhouse gives 2 points per combo of miller, brewer, and witch
		//--> smallest value of these three * 2
		array[0] = player.getLoc().getPub();
		array[1] = player.getLoc().getGuardhouse();
		array[2] = player.getLoc().getBarracks();
		player.changeScore(this.getMinValue(array));
	
	}
	public void playKnight() {
		
		player.getLoc().changeBarracks(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getBarracks() + " Knight(s)");
		player.changeScore(player.getLoc().getMill() * 3);
		
		//Attack all players. the first card from the left goes to the infirmary 
		//Define playerlist
		/*
		 for(Player enemy : GameServer.getPlayers()){
			 if((enemy != player) && (enemy.getLoc().getGuardhouse() < player.getLoc().getGuardhouse)){
			 	
			 if(enemy.getLoc().getMill() > 0){
				 enemy.getLoc().changeMill(-1);
				 enemy.getInf().add(CardType.MILLER);
			 	} 
			 else {
				 if(enemy.getLoc().getBrewery() > 0){
					 enemy.getLoc().changeBrewery(-1);
					 enemy.getInf().add(CardType.BREWER);
				 	} 
				 else {
					 if(enemy.getLoc().getCottage() > 0){
						 enemy.getLoc().changeCottage(-1);
						 enemy.getInf().add(CardType.WITCH);
					 	} 
					 else {
						 
						 if(enemy.getLoc().getGuardhouse() > 0){
							 enemy.getLoc().changeGuardhouse(-1);
							 enemy.getInf().add(CardType.GUARD);
						 	} 
						 else {
							 if(enemy.getLoc().getBarracks() > 0){
								 enemy.getLoc().changeBarracks(-1);
								 enemy.getInf().add(CardType.KNIGHT);
							 	} 
							 else {
								 if(enemy.getLoc().getPub() > 0){
									 enemy.getLoc().changePub(-1);
									 enemy.getInf().add(CardType.INNKEEPER);
								 	} 
								 else {
									 if(enemy.getLoc().getCastle() > 0){
										 enemy.getLoc().changeCastle(-1);
										 enemy.getInf().add(CardType.NOBLE);
									 	} 
								 }
							 }
							 
							 
						 	}
							 
						 }
				 	}
			 
		
			 	}
			 }
		 }
		 
		  */
	}
	
			
		
	public void playInnkeeper() {
		player.getLoc().changePub(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getPub() + " Innkeeper(s)");
		player.changeScore(player.getLoc().getPub() *2);
		
		
		if(player.getLoc().getBrewery()> 0) {
			player.changeScore(2);
		}
	}
	public void playNoble() {
		player.getLoc().changeCastle(1);
		System.out.println("Player " + player.getUser().getLogin() + " now has " + player.getLoc().getCastle() + " Noble(s)");
		player.changeScore(player.getLoc().getCastle() *5);
		player.getMc().add(player.getLoc().getCastle() *1);
	}
	
	
	
	//Copied from https://stackoverflow.com/questions/18525474/java-minimum-and-maximum-values-in-arrayS
	public int getMinValue(int[] array) {
	    int minValue = array[0];
	    for (int i = 1; i < array.length; i++) {
	        if (array[i] < minValue) {
	            minValue = array[i];
	        }
	    }
	    return minValue;
	}
	
	

		 
	public void play() {
		
		
		
		switch (type) {
		case MILLER:  this.playMiller( );
        break;
		case BREWER:  this.playBrewer( );
        break;
		case WITCH: this.playWitch( );
        break;

		case GUARD: this.playGuard( );
        break;
		case KNIGHT: this.playKnight( );
        break;
		case INNKEEPER: this.playInnkeeper( );
        break;
		case NOBLE: this.playNoble( );
        break;

		
		}
	
		
	}

}
