package clientserver;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import ch.majesty.model.Market;
import ch.majesty.model.Player;
import ch.majesty.model.Players;
import controller.GameController;

public class Client extends Thread {
	//Set player
	
	private static final int PORT = 22322;
	
    private static ObjectInputStream input;
    private static ObjectOutputStream output;
    private static String servAdress;
    private static Socket servSocket;
    private static Thread thread;
    private Player thisPlayer;
    private GameController gc;
    private Players players;
  

    

    private Players playerList;
    private Market market;
    
    private static boolean reset = true;
    
    private boolean yourTurn = false;
    
    private boolean gameStarted = false;
    private boolean isServer = false;
    
    private boolean running = false;


    // After loging in, this client is created. GUI send adress and String
	public Client( String username, String serverAdress){
		try {
			System.out.println("Creating Client");
			this.servAdress = serverAdress;
			servSocket = new Socket(servAdress, PORT);
			
			this.output = new ObjectOutputStream(servSocket.getOutputStream());	
			this.input = new ObjectInputStream(servSocket.getInputStream());
				
			thisPlayer = new Player(username);
			
			this.start();
			running = true;
			sendThisPlayer();
			System.out.println("Player created on client and sent");
			servSocket.close();
			input.close();
			output.close();
			
		}catch (Exception e) {
			running = false;
			System.out.println("running =" + running);
			e.printStackTrace();
		}
	}
	
	public void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	//Client listening for objects
	public void run() {
		while(running) {
			Object obj = null;
			try {
				servSocket = new Socket(servAdress, PORT);
				input = new ObjectInputStream(servSocket.getInputStream());	
				obj =  input.readObject();
				input.close();
				servSocket.close();
				if(obj instanceof GameState) {
				handleGS((GameState)obj);
				}
				else {
					if(obj instanceof Player) {
						handleAdd((Player) obj);
					}
				
				else {
					if(obj instanceof String) {
						handleEnd((String) obj);
					}
				}
				}
			}
			catch (EOFException e) {
                e.printStackTrace();
                
			}
			catch(Exception e){
			e.printStackTrace();
			}
		}
		
	}

	public void sendMove(Move move) throws IOException {
		try {
			thisPlayer.setYourTurn(false); 
			//TODO Update GUI
			this.output = new ObjectOutputStream(servSocket.getOutputStream());
			this.servSocket = new Socket(servAdress, this.PORT);
			output.writeObject(move);
			

		}
		catch(IOException e){
			e.printStackTrace();
			sendMove(move);
		}	
		finally {
			output.reset();
		}
		
	}
	
	public void handleGS(GameState gs) {
		this.playerList = gs.getPlayers();
		this.market = gs.getMarket();
	
		yourTurn = true;
		//TODO run update of GUI
	}
	
	public void handleEnd(String winner) {
		if(winner == this.thisPlayer.getUser()) {
			// Display winner window
		}
		else {
			// display loser window
		
		}
	}
	private void sendThisPlayer()  throws IOException {
			try {
				
		//      this.output = new ObjectOutputStream(servSocket.getOutputStream());
				this.servSocket = new Socket(servAdress, this.PORT);
				output.writeObject(thisPlayer);
				

			}
			catch(IOException e){
				e.printStackTrace();
				sendThisPlayer();
			}	
			finally {
			servSocket.close();
			output.close();
			}
	}
	
	public void handleAdd(Player player) {
		players.getPlayerData().add(player);
	}
}
