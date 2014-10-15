/*
 * KeyPress server for relaying keys from the web client to the desktop client, ad keeping track of multiple pairs with a very simple protocol.
 * Written by suBDavis (bdavis@redspin.net)
 * WebSocket Library by github.com/tootallnate
 */
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import utilities.Message;

public class Server extends WebSocketServer{
	
	//Stores new desktop connections in a hash map with their UUID as the key.
	//When web clients send messages, they are prefaced by the same UUID for lookup by the server.
	private HashMap<String, WebSocket> clientMaster = new HashMap<String, WebSocket>();
	private HashMap<WebSocket, WebSocket> webClientMaster = new HashMap<WebSocket, WebSocket>();
	private HashMap<WebSocket, User> webUserMaster = new HashMap<WebSocket, User>();
	private HashMap<String, User> userMaster = new HashMap<String, User>();
	private User tempuser;
	

	public Server( int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
	}

	public Server( InetSocketAddress address ) {
		super( address );
	}

	@Override
	public void onOpen(org.java_websocket.WebSocket conn, ClientHandshake handshake) {		
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " started a connection");
	}

	@Override
	public void onClose(org.java_websocket.WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("Con " + conn + "Closed");
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		
		Message full = new Message(message);
		
		if (full.getPurpose().equals("auth")){										//Do this if a new connection comes from the desktop
			System.out.println("New Client Connection.  ID = " + full.getID());
			
			//new way with password storage and User creation
			tempuser = new User(full.getID(), full.getPassword(), conn);
			userMaster.put(full.getID(), tempuser);
			
			//old way with shit
//			clientMaster.put(full.getID(), conn);
			
		} else if (full.getPurpose().equals("webauth")) {							//Do this if a new connection comes from Web
			System.out.println("New Web Connection.  ID = " + full.getID());
			
			//new way with password checking
			if (userMaster.containsKey(full.getID())){
				String passTest = userMaster.get(full.getID()).getPass();
				if (full.getPassword().equals(passTest)){
					webUserMaster.put(conn, userMaster.get(full.getID()));
				} else conn.send("Wrong Password");
			}
			// Old way without password checking
//			if (clientMaster.containsKey(full.getID())){
//				webClientMaster.put(conn, clientMaster.get(full.getID()));
//			}
		} else if (webUserMaster.containsKey(conn)) {																	//If neither of those, it must be a previously authed message to be sent
			WebSocket c = webUserMaster.get(conn).getDest();
			c.send(message);
		} else {
			System.out.println("User not in the map tried to connect");
		}
	}

	@Override
	public void onError(org.java_websocket.WebSocket conn, Exception ex) {
		ex.printStackTrace();
		
	}
	public void sendAll(String text){
		Collection<org.java_websocket.WebSocket> con = connections();
		synchronized (con){
			for( org.java_websocket.WebSocket c : con ) {
				c.send( text );
			}
		}
	}
	
	
	public static void main( String[] args ) throws InterruptedException , IOException {
		int port = 9898;
		try {
			port = Integer.parseInt( args[ 0 ] );
		} catch ( Exception ex ) {
		}
		Server s = new Server( port );
		s.start();
		System.out.println( "Keypad.io Server started on port: " + s.getPort() );

		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		
		while ( true ) {
			String in = sysin.readLine();
			//s.send( in );
			if( in.equals( "exit" ) ) {
				s.stop();
				break;
			} else if( in.equals( "restart" ) ) {
				s.stop();
				s.start();
				break;
			}
		}
	}

}
