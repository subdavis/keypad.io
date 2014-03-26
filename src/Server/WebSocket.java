package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.util.Collection;

import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WebSocket extends WebSocketServer{

	public WebSocket(int port) {
		super(new InetSocketAddress(port));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onOpen(org.java_websocket.WebSocket conn,
			ClientHandshake handshake) {
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!" );
		
	}

	@Override
	public void onClose(org.java_websocket.WebSocket conn, int code,
			String reason, boolean remote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(org.java_websocket.WebSocket conn, String message) {
		System.out.println(message);
		
	}

	@Override
	public void onError(org.java_websocket.WebSocket conn, Exception ex) {
		// TODO Auto-generated method stub
		
	}
	public void send(String text){
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
		WebSocket s = new WebSocket( port );
		s.start();
		System.out.println( "ChatServer started on port: " + s.getPort() );

		BufferedReader sysin = new BufferedReader( new InputStreamReader( System.in ) );
		while ( true ) {
			String in = sysin.readLine();
			s.send( in );
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
