package Client;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_10;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

/** This example demonstrates how to create a websocket connection to a server. Only the most important callbacks are overloaded. */
public class ExampleClient extends WebSocketClient{
	
	private static ExampleClient c;

	public ExampleClient( URI serverUri , Draft draft ) {
		super( serverUri, draft );
	}

	public ExampleClient( URI serverURI ) {
		super( serverURI );
	}

	@Override
	public void onOpen( ServerHandshake handshakedata ) {
		System.out.println( "opened connection" );
		Random r = new Random();
		int uuidNum = r.nextInt(9999);
		String uuid = String.format("%04d", uuidNum);
		System.out.println(uuid);
		c.send("UUID" + uuid);
	}

	@Override
	public void onMessage( String message ) {
		System.out.println( "received: " + message );
		KeyPress.press(message);
	}

	@Override
	public void onFragment( Framedata fragment ) {
		System.out.println( "received fragment: " + new String( fragment.getPayloadData().array() ) );
	}

	@Override
	public void onClose( int code, String reason, boolean remote ) {
		// The codecodes are documented in class org.java_websocket.framing.CloseFrame
		System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );
	}

	@Override
	public void onError( Exception ex ) {
		ex.printStackTrace();
		// if the error is fatal then onClose will be called additionally
	}

	public static void main( String[] args ) throws URISyntaxException {
		c = new ExampleClient(new URI( "ws://localhost:9898" ), new Draft_10() );
		c.connect();
	}

}