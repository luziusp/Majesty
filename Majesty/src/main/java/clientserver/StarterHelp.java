package clientserver;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StarterHelp  extends Thread {
	 
	    private Server server;

	    public StarterHelp(){
	    }

	    public void run(){
	        try {
	            server = new Server();
	            System.out.println("Server created");
	            //TODO is this correct????
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void start(){
	        Thread thread = new Thread(this);
	        thread.start();
	       System.out.println("Serverthread started");
	    }

	}


