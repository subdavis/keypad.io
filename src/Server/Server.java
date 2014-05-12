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
	private HashMap<String, WebSocket> master = new HashMap<String, WebSocket>();
	private HashMap<WebSocket, String> webmaster = new HashMap<WebSocket, String>();
	

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
		if (full.getPurpose().equals("auth") && !full.getOrigin().equals("web")){
			//Auth process being ignored at the moment
			System.out.println("New Connection.  ID =" + full.getOrigin());
			master.put(full.getOrigin(), conn);
		} 
		else if (full.getPurpose().equals("auth")){
			//Auth process being ignored at the moment.
			webmaster.put(conn, full.getMessage());
		}
		else {
			master.get(webmaster.get(conn)).send(message);
		}
		/*
		String header = message.substring(0, 4);
		//Test the header to see if its a normal message or a new desktop client that needs storing
		if (header.equals("UUID")){
			System.out.println("New Connection.  UUID =" + message.substring(4));
			master.put(message.substring(4), conn);
		} else {
			System.out.println("Message addressed to " + header + " = " + message.substring(4));
			WebSocket c = master.get(header);
			c.send(message.substring(4));
		}
		*/
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
		System.out.println( "ChatServer started on port: " + s.getPort() );

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
