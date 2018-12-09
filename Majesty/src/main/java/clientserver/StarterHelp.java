package clientserver;



public class StarterHelp  extends Thread {
	 
	    private Server server;

	    public StarterHelp(){
	    }

	    public void run(){
	        try {
	            server = new Server();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void start(){
	        Thread thread = new Thread(this);
	        thread.start();
	    }

	}


