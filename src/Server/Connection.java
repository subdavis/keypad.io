package server;

public class Connection {
	
	private String uuid;
	private String salt;
	private String hashedPass;
	private boolean authed;
	
	public Connection(String uuid, String passhash, String salt){
		this.uuid = uuid;
		this.salt = salt;
		this.hashedPass = passhash;
		authed = false;
	}
	public String getUUID(){
		return uuid;
	}
	public String getSalt(){
		return salt;
	}
	public String getHashedPass(){
		return hashedPass;
	}
	public boolean isAuthed(){
		return authed;
	}
	public void setAuthed(boolean change){
		authed = change;
	}
}
