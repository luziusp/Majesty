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

/*
 *  Sources:
 *  https://www.geeksforgeeks.org/introducing-threads-socket-programming-java/
 *  
 */
@Getter @Setter
public class Server2 extends Thread{
	//TODO: Set player correctly
	
	private static final int PORT = 22322;
	private static final int MAX_PLAYERS = 2;
	private static ServerSocket servSocket;
	private static Thread thread;
	private boolean running = true;
	private int cardsBoughtTotal=0;

	
	private GameController gc;

	private Players playerList;
	private Market market;
	

    public Server2() throws Exception{
        servSocket = new ServerSocket(PORT);
        System.out.println("Server started");
        playerList = new Players();

        while (true){ 
        	Socket s = null;
        try {
           s = servSocket.accept();
           
           ObjectInputStream input = new ObjectInputStream(s.getInputStream());
           ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());     
           Thread t = new Handler(s, input, output);
           t.start();
        
        }
         catch (Exception e){
        	 s.close();
            e.printStackTrace();
        }
    }
    }


public  class Handler extends Thread{
	private Socket socket;
	private String name;
	private ObjectInputStream input;
	private ObjectOutputStream output;

	public Handler(Socket socket, ObjectInputStream input, ObjectOutputStream output){
		this.socket = socket;
		
	}

	// Sorry kei Überblick bi dr RUN-Methode...
	public void run(){
		try {
			 input = new ObjectInputStream(socket.getInputStream());
	         output = new ObjectOutputStream(socket.getOutputStream());
			Object o = new Object();

			while(running) {
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
							if(playerList.getPlayerData().size() < MAX_PLAYERS - 1) {
							playerList.getPlayerData().add((Player) o);
							}
							if(playerList.getPlayerData().size() == MAX_PLAYERS) {
								playerList.getPlayerData().get(1).setYourTurn(true);
								market = new Market(playerList);
								System.out.println("Market created");
								output.writeObject(actualizeGame());
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
		GameState gameState = new GameState (market, playerList);
		if(cardsBoughtTotal<= MAX_PLAYERS * 12 ) {
			cardsBoughtTotal++;
			// nach Anzahl Spieler x 12 Zügen Gewinner wird berechnet (players.calcWinner)
			if(output != null) {
				try {
					output.writeObject(gameState);
					output.reset();

				}catch (Exception e){

				}

			}
		}else {
		Player winner =	playerList.calcWinner(); //kontrollieren?!
		try {
			sendWinner(winner.getUser());
		} catch (IOException e) {
			e.printStackTrace();
		}	
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
		
		}	
		finally {
			servSocket.close();
			output.close();
			input.close();
		}
	}
	public void sendWinner (String winner) throws IOException {
		try {
			
			//TODO Update GUI to show winner or loser view 
			
			output.reset();
			output.writeObject(winner);
		}
		catch(IOException e){
			e.printStackTrace();
			
		}	
		finally {
			servSocket.close();
			output.close();
			running = false;
			
		}
	}

	private void handleMove(Move move){
		market.buy(move.getCardPlayed(), move.getPlayer());
		//TODO GUI updaten	
		
	}
	

}
}

