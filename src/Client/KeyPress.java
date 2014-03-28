package Client;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyPress {
	
	//covert keys from characters to their key events.
	public static int convertKey(String s){
		int realNum = 0;
		switch (s){
		case "a" : realNum= KeyEvent.VK_A; break;
		case "b" : realNum= KeyEvent.VK_B; break;
		case "c" : realNum= KeyEvent.VK_C; break;
		case "d" : realNum= KeyEvent.VK_D; break;
		case "e" : realNum= KeyEvent.VK_E; break;
		case "f" : realNum= KeyEvent.VK_F; break;
		case "g" : realNum= KeyEvent.VK_G; break;
		case "h" : realNum= KeyEvent.VK_H; break;
		case "i" : realNum= KeyEvent.VK_I; break;
		case "j" : realNum= KeyEvent.VK_J; break;
		case "k" : realNum= KeyEvent.VK_K; break;
		case "l" : realNum= KeyEvent.VK_L; break;
		case "m" : realNum= KeyEvent.VK_M; break;
		case "n" : realNum= KeyEvent.VK_N; break;
		case "o" : realNum= KeyEvent.VK_O; break;
		case "p" : realNum= KeyEvent.VK_P; break;
		case "q" : realNum= KeyEvent.VK_Q; break;
		case "r" : realNum= KeyEvent.VK_R; break;
		case "s" : realNum= KeyEvent.VK_S; break;
		case "t" : realNum= KeyEvent.VK_T; break;
		case "u" : realNum= KeyEvent.VK_U; break;
		case "v" : realNum= KeyEvent.VK_V; break;
		case "w" : realNum= KeyEvent.VK_W; break;
		case "x" : realNum= KeyEvent.VK_X; break;
		case "y" : realNum= KeyEvent.VK_Y; break;
		case "z" : realNum= KeyEvent.VK_Z; break;
		case "0" : realNum= KeyEvent.VK_0; break;
		case "1" : realNum= KeyEvent.VK_1; break;
		case "2" : realNum= KeyEvent.VK_2; break;
		case "3" : realNum= KeyEvent.VK_3; break;
		case "4" : realNum= KeyEvent.VK_4; break;
		case "5" : realNum= KeyEvent.VK_5; break;
		case "6" : realNum= KeyEvent.VK_6; break;
		case "7" : realNum= KeyEvent.VK_7; break;
		case "8" : realNum= KeyEvent.VK_8; break;
		case "9" : realNum= KeyEvent.VK_9; break;
		case "right" : realNum= KeyEvent.VK_RIGHT; break;
		case "left" : realNum= KeyEvent.VK_LEFT; break;
		case "enter" : realNum= KeyEvent.VK_ENTER; break;
		case "backspace" : realNum= KeyEvent.VK_BACK_SPACE; break;
		case "space" : realNum= KeyEvent.VK_SPACE; break;
		default : realNum = 0; break;
		}
		return realNum;
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