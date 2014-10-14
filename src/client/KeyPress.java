package client;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyPress {
	private static Map<String, Integer> keyPressMap = new HashMap<>();
	static {
		keyPressMap.put("65", KeyEvent.VK_A);
		keyPressMap.put("66", KeyEvent.VK_B);
		keyPressMap.put("67", KeyEvent.VK_C);
		keyPressMap.put("68", KeyEvent.VK_D);
		keyPressMap.put("69", KeyEvent.VK_E);
		keyPressMap.put("70", KeyEvent.VK_F);
		keyPressMap.put("71", KeyEvent.VK_G);
		keyPressMap.put("72", KeyEvent.VK_H);
		keyPressMap.put("73", KeyEvent.VK_I);
		keyPressMap.put("74", KeyEvent.VK_J);
		keyPressMap.put("75", KeyEvent.VK_K);
		keyPressMap.put("76", KeyEvent.VK_L);
		keyPressMap.put("77", KeyEvent.VK_M);
		keyPressMap.put("78", KeyEvent.VK_N);
		keyPressMap.put("79", KeyEvent.VK_O);
		keyPressMap.put("80", KeyEvent.VK_P);
		keyPressMap.put("81", KeyEvent.VK_Q);
		keyPressMap.put("82", KeyEvent.VK_R);
		keyPressMap.put("83", KeyEvent.VK_S);
		keyPressMap.put("84", KeyEvent.VK_T);
		keyPressMap.put("85", KeyEvent.VK_U);
		keyPressMap.put("86", KeyEvent.VK_V);
		keyPressMap.put("87", KeyEvent.VK_W);
		keyPressMap.put("88", KeyEvent.VK_X);
		keyPressMap.put("89", KeyEvent.VK_Y);
		keyPressMap.put("90", KeyEvent.VK_Z);
		keyPressMap.put("48", KeyEvent.VK_0);
		keyPressMap.put("49", KeyEvent.VK_1);
		keyPressMap.put("50", KeyEvent.VK_2);
		keyPressMap.put("51", KeyEvent.VK_3);
		keyPressMap.put("52", KeyEvent.VK_4);
		keyPressMap.put("53", KeyEvent.VK_5);
		keyPressMap.put("54", KeyEvent.VK_6);
		keyPressMap.put("55", KeyEvent.VK_7);
		keyPressMap.put("56", KeyEvent.VK_8);
		keyPressMap.put("57", KeyEvent.VK_9);
		keyPressMap.put("39", KeyEvent.VK_RIGHT);
		keyPressMap.put("37", KeyEvent.VK_LEFT);
		keyPressMap.put("13", KeyEvent.VK_ENTER);
		keyPressMap.put("8", KeyEvent.VK_BACK_SPACE);
		keyPressMap.put("32", KeyEvent.VK_SPACE);
	}
	
	//covert keys from characters to their key events.
	public static int convertKey(String s){
		Integer key = keyPressMap.get(s);
		if(key == null)
			return 0;
		else
			return key;
	}
	
	public static void press(String s){
	try {
		System.out.println(s);
        Robot robot = new Robot();
		robot.delay(10);
        robot.keyPress(convertKey(s));
        robot.delay(50);
        robot.keyRelease(convertKey(s));
        
    } catch (AWTException e) {
        e.printStackTrace();
    }

}
}