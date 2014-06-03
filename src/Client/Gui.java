package client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Gui extends JFrame{
  JFrame main_frame = new JFrame();
  private String lastKeyPressed;
  private JLabel info;
  private JLabel showLastKey;
  private JButton toggle;
  private String password;
  
  Gui() {
	lastKeyPressed = null;
	main_frame = new JFrame();
	main_frame.setTitle("FlashRemote");
	main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	main_frame.setLayout(new BorderLayout());
	main_frame.setSize(200, 100);
	main_frame.setResizable(false);
	
	JPanel top_panel = new JPanel();
	top_panel.setLayout(new BorderLayout());
	
	showLastKey = new JLabel("n/a");
	info = new JLabel("Your UUID is " + null);
	toggle = new JButton("Open Connection");
	
	main_frame.add(top_panel, BorderLayout.CENTER);
	top_panel.add(info, BorderLayout.CENTER);
	top_panel.add(showLastKey, BorderLayout.SOUTH);
	main_frame.add(toggle, BorderLayout.SOUTH);
	
    toggle.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Autos-generated method stub
			if(Client.getStatus()){
				Client.togglePaused();
			}
			else{
			password = (String)JOptionPane.showInputDialog("Please enter a password");
				try {
					Client.createClient(password);
					setGUI();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    });   
	
	main_frame.setVisible(true);
  }
  
  public void setID(String id){
	  info.setText("Your ID is " + id);

	  this.repaint();
	  this.validate();
  }
  
  public void togglePaused(){
	  if (Client.isPaused()){
		  toggle.setText("Pause");
	  }
	  else toggle.setText("Resume");
	  
	  this.repaint();
	  this.validate();
  }
  private void setGUI(){
	  Client.setGUI(this);
  }
  
}