package test;

import java.util.concurrent.TimeUnit;

import clientserver.Client;

public class Clientservertest2 {
	public static void main(String[] args) throws Exception {
		
		Client client2 = new Client("Peter", "localhost");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(client2.getMarket().printCards());

		
		
	}

}
