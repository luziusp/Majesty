package clientserver;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

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
public class Server extends Thread{
	//TODO: Set player correctly
	
	private static final int PORT = 22322;
	private static final int MAX_PLAYERS = 2;
	private static ServerSocket servSocket;
	private static Thread thread;
	private boolean running = true;
	private int cardsBoughtTotal=0;
	
	private static HashSet<ObjectOutputStream> outputList = new HashSet<ObjectOutputStream>();

	
	private GameController gc;

	private static Players playerList;
	private static Market market;
	

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
	private InputStreamReader reader;
	private OutputStreamWriter writer;

	public Handler(Socket socket){
		this.socket = socket;
		
	}

	// Sorry kei Überblick bi dr RUN-Methode...
	public void run(){
		try {
			 input = new ObjectInputStream(socket.getInputStream());
	         output = new ObjectOutputStream(socket.getOutputStream());
	         
	         outputList.add(output);

	         
			Object o = new Object();

			while(running) {
				try {
					try {
						o = input.readObject();	
					}catch (Exception e) {
                        // Example: Object not fully sent
                        // This should be handled
						continue;
					}

					if (o instanceof Move) {
							System.out.print("Move");
                     
							handleMove((Move) o);
							actualizeGame();
					}
					if (o instanceof Player) {
                    
							if(playerList.getPlayerData().size() < MAX_PLAYERS) {
								Player player = (Player) o;
								if(playerList.getPlayerData().size() == 1) {
									player.setColor(Color.BLUE);
								}
								else {
									player.setColor(Color.GREEN);
								}
									
							playerList.getPlayerData().add(player);
							System.out.println("Player added");
							System.out.println("playersize "+ playerList.getPlayerData().size());
							}
							if(playerList.getPlayerData().size() == MAX_PLAYERS) {
								playerList.getPlayerData().get(1).setYourTurn(true);
								market = new Market(playerList);
								System.out.println("Market created");
								GameState gs = actualizeGame();
								
							}
							if (o instanceof ChatMessage) {
								ChatMessage message = (ChatMessage) o;
								System.out.println(message.getMessage());
								sendMessage(message);
							}

				}
				}catch (Exception e) {
					e.printStackTrace();
					break;
				}
			}
		}catch (Exception e){

		}finally {
			if (output != null) {		
			try {
                // I think sockets can be clsoed here?
                // Close serverSocket here as well?
				//socket.close();
                //servSocket.close();
                //input.close();
                //output.close();
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

					sendToAll(gameState);
					System.out.println("Gamestate sent");
					

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

			sendToAll(player);
			
		}
		catch(IOException e){
			e.printStackTrace();
		
		}	
		finally {
            // Pretty sure we dont need to close the serversocket/input/output here
            // -> only when game ends after while(running) loop ends
/*			servSocket.close();
			output.close();*/
			input.close();
		}
	}
	public void sendWinner (String winner) throws IOException {
		try {

			sendToAll(winner);
			
		}
		catch(IOException e){
			e.printStackTrace();
			
		}	
		finally {
            // Pretty sure we dont need to close the serversocket/input/output here
            // -> only when game ends after while(running) loop ends
/*			servSocket.close();
			output.close();*/
			running = false;
			
		}
	}
	private void sendMessage(ChatMessage message) {
		try {

			sendToAll(message);
			
		}
		catch(IOException e){
			e.printStackTrace();
			
		}	
		finally {
			
		}
	}

	private void handleMove(Move move){
		market.buy(move.getCardPlayed(), move.getPlayer());
		
	}
    private void sendToAll(Object o) throws IOException {
        for (ObjectOutputStream output : outputList){
            if (output != null){
                output.writeObject(o);
                output.reset();
            }

        }
    }

}
}

