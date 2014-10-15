package server;

import org.java_websocket.WebSocket;

public class User {
	
	private String id;
	private String salt;
	private String pass;
	private boolean authed;
	private WebSocket dest;
	
	public User(String id, String pass, WebSocket conn){
		this.id = id;
		this.salt = null;
		this.pass = pass;
		this.dest = conn;
		authed = false;
	}
	public String getID(){
		return id;
	}
	public String getSalt(){
		return salt;
	}
	public String getPass(){
		return pass;
	}
	public WebSocket getDest(){
		return dest;
	}
	public boolean isAuthed(){
		return authed;
	}
	public void setAuthed(boolean change){
		authed = change;
	}
}
