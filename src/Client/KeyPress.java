package client;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeyPress {
	private static Map<String, Integer> keyPressMap = new HashMap<>();
	static {
		keyPressMap.put("a", KeyEvent.VK_A);
		keyPressMap.put("b", KeyEvent.VK_B);
		keyPressMap.put("c", KeyEvent.VK_C);
		keyPressMap.put("d", KeyEvent.VK_D);
		keyPressMap.put("e", KeyEvent.VK_E);
		keyPressMap.put("f", KeyEvent.VK_F);
		keyPressMap.put("g", KeyEvent.VK_G);
		keyPressMap.put("h", KeyEvent.VK_H);
		keyPressMap.put("i", KeyEvent.VK_I);
		keyPressMap.put("j", KeyEvent.VK_J);
		keyPressMap.put("k", KeyEvent.VK_K);
		keyPressMap.put("l", KeyEvent.VK_L);
		keyPressMap.put("m", KeyEvent.VK_M);
		keyPressMap.put("n", KeyEvent.VK_N);
		keyPressMap.put("o", KeyEvent.VK_O);
		keyPressMap.put("p", KeyEvent.VK_P);
		keyPressMap.put("q", KeyEvent.VK_Q);
		keyPressMap.put("r", KeyEvent.VK_R);
		keyPressMap.put("s", KeyEvent.VK_S);
		keyPressMap.put("t", KeyEvent.VK_T);
		keyPressMap.put("u", KeyEvent.VK_U);
		keyPressMap.put("v", KeyEvent.VK_V);
		keyPressMap.put("w", KeyEvent.VK_W);
		keyPressMap.put("x", KeyEvent.VK_X);
		keyPressMap.put("y", KeyEvent.VK_Y);
		keyPressMap.put("z", KeyEvent.VK_Z);
		keyPressMap.put("0", KeyEvent.VK_0);
		keyPressMap.put("1", KeyEvent.VK_1);
		keyPressMap.put("2", KeyEvent.VK_2);
		keyPressMap.put("3", KeyEvent.VK_3);
		keyPressMap.put("4", KeyEvent.VK_4);
		keyPressMap.put("5", KeyEvent.VK_5);
		keyPressMap.put("6", KeyEvent.VK_6);
		keyPressMap.put("7", KeyEvent.VK_7);
		keyPressMap.put("8", KeyEvent.VK_8);
		keyPressMap.put("9", KeyEvent.VK_9);
		keyPressMap.put("right", KeyEvent.VK_RIGHT);
		keyPressMap.put("left", KeyEvent.VK_LEFT);
		keyPressMap.put("enter", KeyEvent.VK_ENTER);
		keyPressMap.put("backspace", KeyEvent.VK_BACK_SPACE);
		keyPressMap.put("space", KeyEvent.VK_SPACE);
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