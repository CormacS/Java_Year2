package button.lab4.com;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFirstGUI extends JFrame implements ActionListener
{


		  private JLabel label1;
		  private JButton button1;

		  		  	 
		  // Constructor
	  
		  public MyFirstGUI (String title)
		  {
			  // set the title
			   super(title);
			
			   // sets the screen layout  - in this case, border layout
			   setLayout(new BorderLayout());
			   
			   // create a label
			   label1  = new JLabel("Just this label on screen");
			   button1 = new JButton("Press for a surprise.");
			   
			   // create a section of screen (panel) that will hold some GUI components 
			   JPanel myPanel = new JPanel();
			   
			   // add the label we created to the panel 
			   myPanel.add(label1); 
			   myPanel.add(button1);
			   
			   // add the panel to the screen  - uses the add() method of JFrame to do this. 
			   add(myPanel, BorderLayout.CENTER);

				// set the location of the screen  
			   setLocation(100,100);

			   // Define the size of the frame  
			   setSize(300,400);
			   
			   // make the screen appear - without this, it doesn't!  
			   setVisible(true);
			   
			   button1.addActionListener(this);
			   	   
		 }
		
		 public void actionPerformed(ActionEvent anything)
		 {
			 System.out.println("SURPRISE!");
		 }

			
}