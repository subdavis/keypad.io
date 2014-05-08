/*
 * This is a Client for FlashRemote which receives characters from the server and presses the corresponding key.
 * Written by suBDavis (bdavis@redspin.net)
 * WebSocket Library by github.com/tootallnate
 * 
 */
package client;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

import utilities.Message;


public class Client extends WebSocketClient{
	
	private static Client c;
	private static String uuid;
	private static String lastKey;
	private static Observer cliObserver;

	public Client( URI serverUri , Draft draft ) {
		super( serverUri, draft );
	}

	public Client( URI serverURI ) {
		super( serverURI );
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		System.out.println( "opened connection" );
		
		//Generate a four digit number, fill the left with 0s if shorter than 4 digits, and pass it to the server as the client UUID.
		//Server will record the UUID with the connection in a hashmap so the web client can find the right desktop.
		
		Random r = new Random();
		int uuidNum = r.nextInt(9999);
		uuid = String.format("%04d", uuidNum);
		System.out.println(uuid);
		c.send( uuid + ".0000.null.1313");
		lastKey = null;
	}

	@Override
	public void onMessage( String message ) {
		Message full = new Message(message);
		System.out.println( "received: " + full.getMessage() + " from " + full.getOrigin());
		//Send the message to the KeyPress class for pressing :)
		lastKey = full.getMessage();
		KeyPress.press(full.getMessage());
		notifyObservers();
	}

	@Override
	public void onFragment( Framedata fragment ) {
		System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}
	
	public static String getUUID(){
		while (uuid==null){
			try {
			    Thread.sleep(50);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		}
		return uuid;
	}
	
	public static String getLastKey(){
		return lastKey;
	}

	public synchronized static void createClient() throws URISyntaxException {
		
		//c is class private so all methods can acces her for sending messages if this is later necessary.
		c = new Client(new URI( "ws://redspin.net:9898" ), new Draft_10() );
		c.connect();
	}

	public static void addObserver(Gui g) {
		cliObserver = g;
	}
	
	public static void notifyObservers(){
		cliObserver.update(uuid, lastKey);
	}

}