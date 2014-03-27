package Client;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.*;

public class Gui extends JFrame{
  JPanel pane = new JPanel();
  JPanel buttons = new JPanel();
  JButton end = new JButton("Close Client");
  
  
  Gui(String uuid) {
    super("FlashRemote"); 
    setBounds(50,50,300,200);
    JLabel identifier = new JLabel("Your UUID is " + uuid);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container con = this.getContentPane(); // inherit main frame
    con.add(pane);    // JPanel containers default to FlowLayout
    pane.add(identifier);
    setVisible(true); // make frame visible
  }
  public static void main(String[] args) throws URISyntaxException {
      //Schedule a job for the event-dispatching thread:
      //creating and showing this application's GUI.
	  ExampleClient.createClient();
	  try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	  
              
		new Gui(ExampleClient.uuid);
		
  }
}