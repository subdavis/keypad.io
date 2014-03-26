package Client;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyPress {
	
	public static int convertKey(char k){
		int realNum = 0;
		switch (k){
		case 'a' : realNum= KeyEvent.VK_A; break;
		case 'b' : realNum= KeyEvent.VK_B; break;
		case 'c' : realNum= KeyEvent.VK_C; break;
		case 'd' : realNum= KeyEvent.VK_D; break;
		case 'e' : realNum= KeyEvent.VK_E; break;
		case 'f' : realNum= KeyEvent.VK_F; break;
		case 'g' : realNum= KeyEvent.VK_G; break;
		case 'h' : realNum= KeyEvent.VK_H; break;
		case 'i' : realNum= KeyEvent.VK_I; break;
		case 'j' : realNum= KeyEvent.VK_J; break;
		case 'k' : realNum= KeyEvent.VK_K; break;
		case 'l' : realNum= KeyEvent.VK_L; break;
		case 'm' : realNum= KeyEvent.VK_M; break;
		case 'n' : realNum= KeyEvent.VK_N; break;
		case 'o' : realNum= KeyEvent.VK_O; break;
		case 'p' : realNum= KeyEvent.VK_P; break;
		case 'q' : realNum= KeyEvent.VK_Q; break;
		case 'r' : realNum= KeyEvent.VK_R; break;
		case 's' : realNum= KeyEvent.VK_S; break;
		case 't' : realNum= KeyEvent.VK_T; break;
		case 'u' : realNum= KeyEvent.VK_U; break;
		case 'v' : realNum= KeyEvent.VK_V; break;
		case 'w' : realNum= KeyEvent.VK_W; break;
		case 'x' : realNum= KeyEvent.VK_X; break;
		case 'y' : realNum= KeyEvent.VK_Y; break;
		case 'z' : realNum= KeyEvent.VK_Z; break;
		default : realNum = (int)k; break;
		}
		return realNum;
	}
	
	public static void press(String s){
	try {
		System.out.println(s.charAt(0));
        Robot robot = new Robot();
		robot.delay(3000);
        robot.keyPress(convertKey(s.charAt(0)));
        robot.keyRelease(convertKey(s.charAt(0)));
        
    } catch (AWTException e) {
        e.printStackTrace();
    }

}
}