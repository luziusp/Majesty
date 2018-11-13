package ch.majesty.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ch.majesty.userdb.User;
import lombok.Getter;
import lombok.Setter;

/*
 * PLU 31.10.2018
 * 
 * Buy Cards for Meeples
 * If cost < bonus meeples , gain meeple
 * 
 */
@Getter @Setter
public class Market {
	//TODO: Alles
	
	/*
	 * Note that this implementation is not synchronized. 
	 * If multiple threads access a linked list concurrently, and at least one of 
	 * the threads modifies the list structurally, it must be 
	 * synchronized externally. 
	 * (A structural modification is any operation that adds or deletes one or more 
	 * elements; merely setting the value of an element is not a structural modification.) This is typically accomplished by synchronizing on some object that naturally encapsulates the list. If no such object exists, the list should be "wrapped" using the Collections.synchronizedList method. This is best done at creation time, 
	 * to prevent accidental unsynchronized access to the list:
   List list = Collections.synchronizedList(new LinkedList(...));
	 */
	List<CardType> list = Collections.synchronizedList(new LinkedList<CardType>());
	List<Integer> meeples = Collections.synchronizedList(new LinkedList<Integer>());
	
	//amount of cards left per type for probability calculation
	int amountMiller;
	int amountBrewer;
	int amountWitch;
	int amountGuard;
	int amountKnight;
	int amountInnkeeper;
	int amountNoble;
	
	
	public Market() {
		//TODO Set real amounts for cards
		//setting amount of cards in game
		 amountMiller = 5;
		 amountBrewer= 5;
		 amountWitch= 5;
		 amountGuard= 5;
		 amountKnight= 5;
		 amountInnkeeper= 5;
		 amountNoble= 5;
		

		
		for(int i = 0; i < 5; i++) {
			meeples.add(0);
			list.add(this.calcCard());
		}
		
		
	}
	
	
	public Card buy(int listLocation, Player player) {
		
		//reminder: location 0 on array = price 0. Do not change to +1!
		int cost = listLocation ;
		int bonus = meeples.get(listLocation);
		
		//TODO: check if enough meeple for buyable

		
		
		//Add meeple for all prior cards, remove from players meeplecard
		for(int i = 0; i < listLocation; i++) {
			int sum = meeples.get(i) + 1;
			meeples.set(i, sum);
			
			}
		
		
		
		
		
		Card purchasedCard = new Card(list.get(listLocation), player);
		
		//Remove both entries in costlist and cardlist, pay cost/add bonus meeples 
		list.remove(listLocation);
		meeples.remove(listLocation);
		
		player.getMc().add(bonus - cost);
		
		this.add();
		
		purchasedCard.play();
		return purchasedCard;
		
	}
	
	private void add(){
		
		this.meeples.add(0);
		this.list.add(calcCard());
		
	}
	//calculates from stock of cards what the next draw will be;
	private CardType calcCard() {
		CardType result;
		int total = amountMiller + amountBrewer + amountWitch + amountGuard + amountKnight + amountInnkeeper + amountNoble;
		
		Random rand = new Random();
		int randomised = rand.nextInt(total);
		if(randomised < amountMiller) {
			result = CardType.MILLER;
			amountMiller --;
		}
		else {
			if(randomised< (amountMiller +  amountBrewer)) {
				result = CardType.BREWER;
				amountBrewer --;
			}
			else {
				if(randomised < (amountMiller +  amountBrewer + amountWitch)) {
					result = CardType.WITCH;
					amountWitch --;
				}
				else {
					if(randomised < (amountMiller +  amountBrewer + amountWitch + amountGuard)) {
						result = CardType.GUARD;
						amountGuard --;
					}
					else {
						if(randomised < (amountMiller +  amountBrewer + amountWitch + amountGuard + amountKnight)) {
							result = CardType.KNIGHT;
							amountKnight --;
						}
						else {
							if(rand.nextInt(total)< (amountMiller +  amountBrewer + amountWitch + amountGuard + amountKnight + amountInnkeeper)) {
								result = CardType.INNKEEPER;
								amountInnkeeper --;
							}
							else {
								result = CardType.NOBLE;
								amountNoble --;
								}
						
		}
					}
				}
			}
		}
		
		
		return result;
	}
	
}

		