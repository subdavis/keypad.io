package client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Gui extends JFrame implements Observer{
  JFrame main_frame = new JFrame();
  private String lastKeyPressed;
  private JLabel info;
  private JLabel showLastKey;
  
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
	JButton pause = new JButton("Pause Connection");
	pause.addActionListener(new ActionListener(){ 
		  public void actionPerformed(ActionEvent e) { 
			    pausePressed();
			  }
			});
	
	main_frame.add(top_panel, BorderLayout.CENTER);
	top_panel.add(info, BorderLayout.CENTER);
	top_panel.add(showLastKey, BorderLayout.SOUTH);
	main_frame.add(pause, BorderLayout.SOUTH);
	
	main_frame.setVisible(true);
  }

  @Override
  public void update() {
	info.setText(Client.getUUID());
	showLastKey.setText(Client.getLastKey());
	this.validate();
	this.repaint();
  }
  private void pausePressed() {
		System.out.println("Paused");
	} 
  
}