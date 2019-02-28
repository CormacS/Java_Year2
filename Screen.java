package com.test.lab5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Screen extends JFrame implements ActionListener, MouseListener
{
	  //Attributes
	  private JLabel label1;
	  private JLabel label2;
	  private JButton button1;
	  private JButton button2;
	  private JTextField field1;
	  private JSlider slider1;
	  
	  // Constructors
	  public Screen(String title)
	  {
		  //Initilizing
		  super(title);
		  setLayout(new BorderLayout());
		  setLayout(new FlowLayout());
		  
		  label1 = new JLabel("What's your favourite pizza topping?");
		  label2 = new JLabel("Panel is here");
		  button1 = new JButton("Press if you like pepperoni");
		  button2 = new JButton("Press if you pineapple");
		  slider1 = new JSlider();
		  field1 = new JTextField("Name");
		  field1.setColumns(20);
		  
		  
		  //Setting the Labels for the Table
		  slider1.setPaintLabels(true);
		  Hashtable<Integer,JLabel> table = new Hashtable<Integer,JLabel>();
		  table.put(0, new JLabel("I hate pizza"));
		  table.put(100, new JLabel("I love pizza"));
		  slider1.setLabelTable(table);  	
		  //slider1.setLabelTable(slider1.createStandardLabels(25));
	
		  //Creating Panels
		  JPanel Panel1 = new JPanel();
		  JPanel Panel2 = new JPanel();
		  
		  //Adding Layout to Panels
		  add(Panel1, BorderLayout.CENTER);
		  add(Panel2, BorderLayout.CENTER);
		  
		  //Adding the components to the Panels
		  Panel1.add(label1);
		  Panel1.add(button1);
		  Panel1.add(button2);
		  Panel1.add(field1);
		  Panel1.add(slider1);
		  Panel2.add(label2);
		  
		  //Setting backgroud colour of the label to red
		  Panel2.setBackground(Color.red);
		  
		  
		  //Event Programming
		  button1.addActionListener(this);
		  button2.addActionListener(this);
		  field1.addActionListener(this);
		  Panel2.addMouseListener(this);
		  

		  setLocation(100,100);
		  
		  setSize(1100,400);
		  
		  setVisible(true);
		  
	  }



	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == button1)
		{
			JOptionPane.showMessageDialog(this, "Of course you do! Everyone loves pepperoni!");
		}
		if(anything.getSource() == button2)
		{
			JOptionPane.showMessageDialog(this, "... please exit the program immeditaly");
		}
		if(anything.getSource() == field1)
		{
			JOptionPane.showMessageDialog(this,"You Entered: "+field1.getText());
			
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			JOptionPane.showMessageDialog(this,"Left Click");
		}

		if(e.getButton() == MouseEvent.BUTTON3)
		{
			JOptionPane.showMessageDialog(this,"Right Click");
		}
	}



	@Override
	public void mouseEntered(MouseEvent e) 
	{
		JOptionPane.showMessageDialog(this,"Mouse Entered the Panel");
		
		
	}



	@Override
	public void mouseExited(MouseEvent e) 
	{
		JOptionPane.showMessageDialog(this,"Mouse Exited the Panel");
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}
	  
	  
