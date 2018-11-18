package test;

import java.util.Random;

import ch.majesty.model.CardModel;
import ch.majesty.model.CardType;
import ch.majesty.model.Market;
import ch.majesty.model.Player;
import ch.majesty.userdb.User;

public class TestMarket {
	public static void main(String[] args) {

		
	Market market = new Market();
	Player player = new Player(new User("bla", "blabb", 0, 0));
	int rounds = 5;
	
	for(int iteration = 0; iteration < rounds; iteration++) {
		Random rand = new Random();
	System.out.println("");	
	System.out.println("++++++++++++++++++++++++++++++++");	
	System.out.println("+                              +");	
	System.out.println("+        ROUND " + iteration+ "               +");	
	System.out.println("+                              +");	
	System.out.println("++++++++++++++++++++++++++++++++");	
	System.out.println("");
	System.out.println("------------------------------");
	System.out.println("Meeple count");
	System.out.println(player.getMc().getCount());
	System.out.println("------------------------------");
	
	System.out.println("Cards on board");
	StringBuilder board1 = new StringBuilder();
	for(CardType cards : market.getList()){
	board1.append(cards.toString()+ " / ");
	}
	System.out.println(board1.toString());
	System.out.println("------------------------------");
	
	System.out.println("Meeples on cards ");
	
	StringBuilder amounts = new StringBuilder();
	for(int amount : market.getMeeples()){
		amounts.append(amount + " / ");
	}
	System.out.println(amounts.toString());
	
	System.out.println("------------------------------");
	System.out.println("ACTION: Buy a random card ");
	CardModel bla = market.buy(rand.nextInt(5), player);
	
	
	
	System.out.println("------------------------------");
	System.out.println("Meeple count");
	System.out.println(player.getMc().getCount());

	System.out.println("------------------------------");
	

	System.out.println("Cards on board afterwards");
	StringBuilder board2 = new StringBuilder();
	for(CardType cards : market.getList()){
	board2.append(cards.toString()+ " / ");
	}
	System.out.println(board2.toString());
	
	System.out.println("------------------------------");
	System.out.println("Meeples on cards after");
	StringBuilder amounts2 = new StringBuilder();
	for(int amount : market.getMeeples()){
		amounts2.append(amount + " / ");
	}
	System.out.println(amounts2.toString());
	
	System.out.println("------------------------------");
	
	System.out.println("Rest of cards: ");
	System.out.println("Brewer: "+market.getAmountBrewer() 
	+ " / Miller: "+market.getAmountMiller() 
	+ " / Witch: "+ market.getAmountWitch() 
	+ " / Guard: "+market.getAmountGuard()
	+ " / Knight: "+market.getAmountKnight()
	+ " / Innkeeper: "+market.getAmountInnkeeper()		
	+ " / Noble: "+market.getAmountNoble()		
			);
	System.out.println("------------------------------");
	System.out.println("End turn and resolve meeples");
	player.resolveMC();
	
	System.out.println("------------------------------");
	}
}
}
