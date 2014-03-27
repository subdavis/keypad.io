package Client;

import java.awt.*; 
import java.net.URISyntaxException;
import javax.swing.*;

@SuppressWarnings("serial")
public class Gui extends JFrame{
  JPanel pane = new JPanel();
  
  
  Gui(String uuid) {
    super("FlashRemote"); 
    setBounds(50,50,300,200);
    JLabel identifier = new JLabel("Your UUID is " + uuid);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("FlashRemote");
    Container con = this.getContentPane(); // inherit main frame
    con.add(pane);    // JPanel containers default to FlowLayout
    pane.add(identifier);
    setVisible(true); // make frame visible
}
  
public static void main(String[] args) throws URISyntaxException, InterruptedException {
      //Begin the connection, then wait for it to finish and create the GUI
	  ExampleClient.createClient();
	  delay(2);
	  new Gui(ExampleClient.getUUID());
}
  
private static void delay(double seconds) throws InterruptedException{
	  Thread.sleep((long)seconds*1000);
  }
}