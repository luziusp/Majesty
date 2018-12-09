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

//Tutorial von http://www2.math.uni-wuppertal.de/~schaefer/jv/haupt/node102.html

public class Server extends Thread{
	//TODO: Set player correctly
	
	private static final int PORT = 5432;
	
	private static String servAdress;
	private static ServerSocket servSocket;
	private static Thread thread;
	
	private boolean yourTurn = true;
	private boolean gameStarted = false;
	private boolean isServer = false;
	private boolean running = false;
	private boolean valid = false;
	private boolean checked = false;
	
	private GameController gc;
	
	private static boolean reset = true;

	private Players playerList;
	private Market market;
	private Player thisPlayer;

	//public static void main(String[] args) throws Exception {

	//servSocket = new ServerSocket(PORT);
    public Server() throws Exception{
        servSocket = new ServerSocket(PORT);
        try {
            while (true){
                Handler handler = new Handler(servSocket.accept());
                handler.start();
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
							break;
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
					output.writeObject(output);
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
		yourTurn = true;
	}

}
}

