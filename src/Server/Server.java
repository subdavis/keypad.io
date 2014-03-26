package Server;

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

public class Server extends WebSocketServer{
	HashMap<String, WebSocket> master = new HashMap<String, WebSocket>();
	int clientNum = 0;
	

	public Server( int port ) throws UnknownHostException {
		super( new InetSocketAddress( port ) );
	}

	public Server( InetSocketAddress address ) {
		super( address );
	}

	@Override
	public void onOpen(org.java_websocket.WebSocket conn,
			ClientHandshake handshake) {
		System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room as client " + clientNum + " " + conn);
		String Dest = String.format("%04d", clientNum++);
		System.out.println(Dest);
		master.put(Dest, conn);
	}

	@Override
	public void onClose(org.java_websocket.WebSocket conn, int code,
			String reason, boolean remote) {
		System.out.println("Con " + conn + "Closed");
		
	}

	@Override
	public void onMessage(org.java_websocket.WebSocket conn, String message) {
        String Dest = message.substring(0, 4);
        System.out.println(Dest + " " + message.substring(4));
        if (Dest.equals(String.format("%04d", 1))) System.out.println("True");
        WebSocket c = master.get(Dest);
        System.out.println(c.toString());
        c.send(message.substring(4));
        //sendAll(message.substring(4));
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
