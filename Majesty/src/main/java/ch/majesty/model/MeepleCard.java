package ch.majesty.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/*
 * PLU  31.10.2018
 */
@Getter
@Setter
public class MeepleCard implements Serializable{
	int count;
	final int MAXMEEPLE=5;
	
	
	public MeepleCard() {
		this.count = MAXMEEPLE;
	}
	
	public void add(int i) {
		count += i;
	}
	
	public void remove(int i) {
		if(i <= count) {
			count -= i;
		}
	//TODO: Add Error	
	}
	
	//Use at end of turn
	public int resolve() {
		if(count >= MAXMEEPLE) {
			int diff = (count - MAXMEEPLE);
			this.count = MAXMEEPLE;	
			return diff;
		}	
		else return 0;
	}
	
}
