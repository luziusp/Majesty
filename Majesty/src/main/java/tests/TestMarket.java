package tests;

import ch.majesty.model.Card;
import ch.majesty.model.CardType;
import ch.majesty.model.Market;
import ch.majesty.model.Player;
import ch.majesty.userdb.User;

public class TestMarket {
	public static void main(String[] args) {

		
	Market market = new Market();
	Player player = new Player(new User("bla", "blabb", 0, 0));
	
	System.out.println("------------------------------");
	System.out.println("Meeple count");
	System.out.println(player.getMc().getCount());
	System.out.println("------------------------------");
	
	System.out.println("Cards on board");
	for(CardType cards : market.getList()){
		System.out.println(cards.toString());
	}
	System.out.println("------------------------------");
	
	System.out.println("Meeples on cards ");
	for(int amount : market.getMeeples()){
		System.out.println(amount);
	}
	
	System.out.println("------------------------------");
	System.out.println("ACTION: Buy cards 3 and 4 ");
	Card bla = market.buy(3, player);
	Card bla2 = market.buy(4, player);
	System.out.println(bla.getType().toString());
	
	System.out.println("------------------------------");
	System.out.println("Meeple count");
	System.out.println(player.getMc().getCount());

	System.out.println("------------------------------");
	
	System.out.println("Cards on board afterwards");
	for(CardType cards : market.getList()){
		System.out.println(cards.toString());
	}
	System.out.println("------------------------------");
	System.out.println("Meeples on cards after");
	for(int amount : market.getMeeples()){
		System.out.println(amount);
	}
	System.out.println("------------------------------");
	
	System.out.println("Rest of cards: ");
	System.out.println("Brewer: "+market.getAmountBrewer());

	System.out.println("Miller: "+market.getAmountMiller());

	System.out.println("Witch: "+ market.getAmountWitch());

	System.out.println("Guard: "+market.getAmountGuard());

	System.out.println("Knight: "+market.getAmountKnight());

	System.out.println("Innkeeper: "+market.getAmountInnkeeper());

	System.out.println("Noble: "+market.getAmountNoble());
}
}
