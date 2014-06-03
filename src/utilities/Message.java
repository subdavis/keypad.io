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
    private String purpose;
	
	public Message(String message){
		this.raw = message;
		String[] temp = raw.split("[.]+");
		if (temp.length == 2){
			this.purpose = temp[0];
			this.message= temp[1];
		} else {
			System.out.println(raw);
		}
	}
	
	public String getMessage(){
		return message;
	}
	
	public String getPurpose(){
		return purpose;
	}
	
}
