package Server;

import java.util.*;

import org.java_websocket.WebSocket;

/* Name of the class has to be "Main" only if the class is public. */
class HashMap{
    static Hashtable<String, WebSocket> map = new Hashtable<String, WebSocket>();    

    public static void insert(WebSocket con, String UUID){
    	map.put(UUID, con);
    }
    
    public static WebSocket getCon(String UUID){
    	return map.get(UUID);
    }
    
    
}
