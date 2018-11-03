package ch.majesty.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * PLU 31.10.2018
 * 
 * Buy Cards for Meeples
 * If cost < meeplegain, gain meeple
 * 
 */
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
	
	
	
	
}
