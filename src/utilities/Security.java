package utilities;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
	
	public static String makeHash(String base){
	    String sha256hex = org.apache.commons.codec.digest.DigestUtils.sha256Hex(base);
		return sha256hex;
	    
	}
}
