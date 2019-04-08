package com.topic.modeller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{

	FileProcessing f1 = new FileProcessing();
	Compare c1 = new Compare();
	private JButton button1;
	private JTextField field1;
	private JButton button2;
	private JButton button3;
	private JTextArea area1; 
	private JTextArea area2;
	List<LinkedHashMap<String,Integer>> list = new ArrayList<LinkedHashMap<String,Integer>>();
	LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();
	List<String[]> list2 = new ArrayList<String[]>();
	String[] top1;
	String[] top2;
	int alike = 0;

	
	public GUI (String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		button1 = new JButton("Compare Files");
		field1 = new JTextField("Extra word you want to exlude: ");
		field1.setColumns(10);
		button2 = new JButton("Submit word");
		button3 = new JButton("Clear the extra words list");
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		area1 = new JTextArea("List of Extra words:");
		area2 = new JTextArea();
		area2.setRows(8);
		area2.setColumns(40);
		area1.setRows(8);
		area1.setColumns(40);
		

		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.NORTH);
		add(panel3,BorderLayout.NORTH);

		
		panel1.add(button1);
		panel1.add(field1);
		panel1.add(button2);
		panel2.add(area1);
		panel2.add(button3);
		panel3.add(area2);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);		
		
		setLocation(100,100);
		setSize(1000,600);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == button1)
		{
			area2.setText("Comparision Results:\n"+"File1" +"\t\t"+"File2"+"\n");
			
			f1.Connect();
			list = f1.ReadFile();
			File1 = list.get(0);
			File2 = list.get(1);
			list2 = c1.sortMap(File1,File2);
			
			top1 = list2.get(0);
			top2 = list2.get(1);
			alike = c1.Comparision(top1,top2);
			
			for(int i=0;i<10;i++)
			{
					
				area2.append(top1[i]+"\t\t"+top2[i]+"\n");
					
				
			}
			
			area2.append("\nThe two documents are " +alike*10+"%"+" alike."+"\n");
			
		}
		
		if(e.getSource() == button2)
		{
			String extra = field1.getText();
			FileProcessing f2 = new FileProcessing();
			f2.extraWords(extra);
			area1.append("\n"+field1.getText());
		}
		if(e.getSource() == button3)
		{
			f1.Clear();
			area1.setText("List of Extra words:");
		}
		
		
	}
	

}
