package client;

import java.net.URISyntaxException;

public class Main {
	public static void main(String[] args) throws URISyntaxException, InterruptedException {
	      //Begin the connection, then wait for it to connect and create the GUI
		  Client.createClient();
		  Gui g = new Gui();
		  Client.addObserver(g);
		  Client.notifyObservers();
	}
}
