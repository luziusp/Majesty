package clientserver;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;

import ch.majesty.model.Market;
import ch.majesty.model.Player;
import ch.majesty.model.Players;
import controller.GameController;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Server extends Thread{
	//TODO: Set player correctly
	
	private static final int PORT = 22322;
	
	private static ServerSocket servSocket;
	private static Thread thread;
	

	
	private GameController gc;

	private Players playerList;
	private Market market;
	

    public Server() throws Exception{
        servSocket = new ServerSocket(PORT);
        System.out.println("Server started");
        playerList = new Players();

        
        try {
            while (true){
                Handler handler = new Handler(servSocket.accept());
                System.out.println("Handler created");
                handler.start();
                System.out.println("Handler Started");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }



public  class Handler extends Thread{
	private Socket socket;
	private String name;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public Handler(Socket socket){
		this.socket = socket;
	}

	// Sorry kei Überblick bi dr RUN-Methode...
	public void run(){


		try {
			 input = new ObjectInputStream(socket.getInputStream());
	         output = new ObjectOutputStream(socket.getOutputStream());
			Object o = new Object();

			while(true) {
				try {
					try {
						o = input.readObject();	
					}catch (Exception e) {
					}

					if (o == null) {
						return;
					}
					if (o instanceof Move) {
							handleMove((Move) o);
							actualizeGame();
							input.reset();
					}
					if (o instanceof Player) {
							playerList.getPlayerData().add((Player) o);
							if(playerList.getPlayerData().get(1) != null) {
								playerList.getPlayerData().get(1).setYourTurn(true);
								market = new Market(playerList);
								System.out.println("Market created");
								actualizeGame();
							}
							System.out.println("Player added");
							input.reset();
						
				}
				}catch (Exception e) {

					break;
				}
			}
		}catch (Exception e){

		}finally {
			if (output != null) {		
			try {
				socket.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
	}
	

	// gamestate aktualliserien, nach 24 Runden Gewinner ausrechnen
	private GameState actualizeGame(){
		int cardsBoughtTotal=0;
		GameState gameState = new GameState (market, playerList);
		if(cardsBoughtTotal<=24) {
			cardsBoughtTotal++;
			// nach 2malx12 Zügen Gewinner wird berechnet (players.calcWinner)
			
			if(output != null) {
				try {
					output.writeObject(gameState);
					output.reset();

				}catch (Exception e){

				}

			}
		}else {
			playerList.calcWinner(); //kontrollieren?!
			
		}
		return gameState;
		
	}



	public void sendPlayer (Players player) throws IOException {
		try {
			
			//TODO Update GUI to show winner or loser view 
			
			output.reset();
			output.writeObject(player);
		}
		catch(IOException e){
			e.printStackTrace();
			sendPlayer(player);
		}	
		finally {
			servSocket.close();
			output.close();
		}
	}

	// evtl weg??
	private void handleMove(Move move){
		market.buy(move.getCardPlayed(), move.getPlayer());
		//TODO GUI updaten	
		
	}

}
}

