package utilities;

/*
 * New Message format for all messages sent:
 * SenderID.RecipientID.Message.SenderSignature
 * 
 * This class will handle message breakdown for both the server and the client.
 * 
 * Sender Signature will be a salted Sha1 Hash
 * 
 * For Example
 * 1234.5678.m.474ba67bdb289c6263b36dfd8a7bed6c85b04943
 * 
 * Special messages for the server will be addressed to 0000 (Impossible for the random number generator to make)
 * 
 * They will be broken by the periods so any part can be any length
 */

public class Message {
	private String raw;
	private String message;
    private String hash;
	private String origin;
	private String destination;
	
	public Message(String message){
		this.raw = message;
		String[] temp = raw.split("[.]+");
		if (temp.length == 4){
			this.origin = temp[0];
			this.destination= temp[1];
			this.message = temp[2];
			this.hash = temp[3];
		} else {
			System.out.println(raw);
		}
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getOrigin(){
		return origin;
	}
	public String getDestination(){
		return destination;
	}
	public String getHash(){
		return hash;
	}
	
}
