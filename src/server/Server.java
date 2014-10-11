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
		
		if (full.getPurpose().equals("auth")){
			System.out.println("New Connection.  UUID =" + full.getMessage());
			clientMaster.put(full.getMessage(), conn);
		} else if (full.getPurpose().equals("webauth")) {
			System.out.println("Web auth " + full.getMessage());
			if (clientMaster.containsKey(full.getMessage())){
				webClientMaster.put(conn, clientMaster.get(full.getMessage()));
			}
		} else {
			WebSocket c = webClientMaster.get(conn);
			c.send(message);
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
