package test;

import java.util.concurrent.TimeUnit;

import clientserver.Client;

public class Clientservertest1 {

	public static void main(String[] args) {
		Client client1 = new Client("Heinz", "localhost");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
