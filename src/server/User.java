package server;

public class User {
	
	private String uuid;
	private String salt;
	private String hashedPass;
	private boolean authed;
	
	public User(String uuid, String salt, String hashedPass){
		this.uuid = uuid;
		this.salt = salt;
		this.hashedPass = hashedPass;
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
