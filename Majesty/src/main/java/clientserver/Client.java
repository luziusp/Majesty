package clientserver;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

import ch.majesty.model.Market;
import ch.majesty.model.Player;
import ch.majesty.model.Players;
import controller.GameController;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Client extends Thread {
	//Set player
	
	private static final int PORT = 22322;
	
    private static ObjectInputStream input;
    private static ObjectOutputStream output;
    private static String servAdress;
    private static Socket socket;
    private static Thread thread;
    private Player thisPlayer;
    private GameController gc;
    private boolean started = false;
    
  

    

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
			socket = new Socket(servAdress, PORT);
			
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
				
			thisPlayer = new Player(username);
			this.start();
			running = true;



			sendThisPlayer();
			
			System.out.println("Player created on client and sent");

			
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

				try {
					obj =  input.readObject();

				} catch (EOFException e) {

				}
/*
				input.close();
				socket.close();*/
				
				if(obj instanceof GameState) {
					handleGS((GameState)obj);
					System.out.println("Gamestate received");
					if(!started) {
						//TODO Client GUI hier öffnen!
						started = true;
					}
				}
				else {

					if(obj instanceof Player) {
						handleAdd((Player) obj);
					}
				
				else {
					if(obj instanceof String) {
						handleEnd((String) obj);

					}
					else {
						if(obj instanceof ChatMessage) {
							handleMessage((ChatMessage) obj);

						}
					}
				}
				}
			}
			catch (SocketException e) {
                e.printStackTrace();       
			}
			catch (EOFException e) {
                e.printStackTrace();
                
			}
			catch(Exception e){
			e.printStackTrace();
			}

		}

		try {
			socket.close();
			input.close();
			output.close();
		} catch (Exception e) {
			System.out.println("Error closing socket or Input/Outputstreams");
			e.printStackTrace();
		}
	}

	public void sendMove(Move move) throws IOException {
		try {
			thisPlayer.setYourTurn(false); 
			String message = new String(thisPlayer.getUser()+" has bought "+ market.getList().get(move.getCardPlayed()));
			//TODO Update GUI
			output.writeObject(move);
			System.out.print("SENT MOVE");
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
		this.playerList =gs.getPlayers();
		this.market = gs.getMarket();
		System.out.println("Gamestate actualised");
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
				output.writeObject(thisPlayer);
				System.out.print("SENT PLAYER");

			}
			catch(IOException e){
				e.printStackTrace();
				sendThisPlayer();
			}	
			finally {
				output.reset();
			}
	}
	
	public void handleAdd(Player player) {
		playerList.getPlayerData().add(player);
	}
	
	private void handleMessage(ChatMessage message) {
		//TODO Display Message
	}
	
	private void sendMessage(String mess) throws IOException {
		ChatMessage message = new ChatMessage();
		message.setMessage(mess);
		message.setColor(thisPlayer.getColor());
		message.setPlayer(thisPlayer);
		try {
			output.writeObject(message);
			System.out.print("SENT MESSAGE");

		}
		catch(IOException e){
			e.printStackTrace();
			sendMessage(mess);
		}	
		finally {
			output.reset();
		}
	}
}
