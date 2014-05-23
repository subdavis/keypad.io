package utilities;

/*
 * New Message format for all messages sent:
 * web/client.auth/send/alert.message
 * 
 * in the event of an auth message FROM THE CLIENT, the message portion will be formatted:
 * id.passhash.salt
 * 
 * auth messages from web will appear:
 * id.password
 * 
 * This class will handle message breakdown for both the server and the client.
 */

public class Message {
	private String raw;
	private String message;
	private String origin;
	private String purpose;
	
	private String id;
	private String passhash;
	private String salt;
	private String password;
	
	public Message(String message){
		this.raw = message;
		String[] temp = raw.split("[.]+");
		if (temp.length == 3){
			this.origin = temp[0];
			this.purpose= temp[1];
			this.message = temp[2];
			if (this.purpose.equals("auth") && this.origin.equals("client")){
				String authInfo[] = this.message.split("[,]+");
				if (authInfo.length == 3){
					this.id = authInfo[0];
					this.passhash = authInfo[1];
					this.salt = authInfo[2];
				}
				else throw new RuntimeException("invalid Auth Data");
			}
			if (this.purpose.equals("auth") && this.origin.equals("web")){
				String authData[] = this.message.split("[,]+");
				if (authData.length == 2){
					this.id = authData[0];
					this.password = authData[1];
				}
				else throw new RuntimeException("invalid Auth Data");
			}
		} else {
			throw new RuntimeException("invalid message");
		}
	}
	
	public String getMessage(){
		return message;
	}
	public String getOrigin(){
		return origin;
	}
	public String getPurpose(){
		return purpose;
	}
	public String getID(){
		return  id;
	}
	public String getPasshash(){
		return passhash;
	}
	public String getSalt(){
		return salt;
	}
	public String getPassword(){
		return password;
	}
	
	
}
