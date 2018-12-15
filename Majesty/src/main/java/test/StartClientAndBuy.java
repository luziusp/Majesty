package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import clientserver.Client;
import clientserver.Move;

public class StartClientAndBuy {
	public static void main(String[] args) {
		Client client1 = new Client("Heinz", "localhost");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Move move = new Move(1 , client1.getThisPlayer());
		try {
			client1.sendMove(move);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

