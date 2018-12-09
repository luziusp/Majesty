package test;

import ch.majesty.model.CardType;
import ch.majesty.model.Player;
import ch.majesty.model.Players;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TestLocation {
	public static void main(String[] args) {
		Player player1 = new Player("Hans");
		Player player2 = new Player("peter");
		Player player3 = new Player("Gustav");
		
		Players list = new Players();
		list.getPlayerData().addAll(player1,player2,player3);
		
		System.out.println(player1.getLoc().isMaxValue(list, CardType.BREWER));
		System.out.println(list.calcWinner().getUser());

}
}
