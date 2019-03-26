package com.topic.modeller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	private JButton button1;

	
	public GUI (String title)
	{
		super(title);
		setLayout(new BorderLayout());
		//setLayout(new FlowLayout());
		button1 = new JButton("Compare Files");
		JPanel panel1= new JPanel();

		add(panel1,BorderLayout.NORTH);

		
		panel1.add(button1);

		button1.addActionListener(this);

		
		
		setLocation(100,100);
		setSize(400,400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == button1)
		{
			FileProcessing f1 = new FileProcessing();
			f1.Connect();
		}
		
		
		
	}
	

}
