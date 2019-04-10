package com.topic.modeller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener
{

	FileProcessing f1 = new FileProcessing();
	Compare c1 = new Compare();
	private JButton button1;
	private JTextField field1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton f1Button;
	private JButton f2Button;
	private JTextArea area1; 
	private JTextArea area2;
	private JFileChooser chooser = new JFileChooser();
	private FileNameExtensionFilter filter;
	List<LinkedHashMap<String,Integer>> list = new ArrayList<LinkedHashMap<String,Integer>>();
	LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();
	List<String[]> list2 = new ArrayList<String[]>();
	String[] top1;
	String[] top2;
	int alike = 0;
	int counter = 0;
	File file1;
	File file2;

	
	public GUI (String title)
	{
		super(title);
		setLayout(new BorderLayout());
		setLayout(new FlowLayout());
		f1Button = new JButton("Select File 1");
		f2Button = new JButton("Select File 2");
		button1 = new JButton("Compare Files");
		field1 = new JTextField("Extra word you want to exlude: ");
		field1.setColumns(10);
		button2 = new JButton("Submit word");
		button3 = new JButton("Clear the extra words list");
		button4 = new JButton("Save to File");
		JPanel panel1= new JPanel();
		JPanel panel2= new JPanel();
		JPanel panel3= new JPanel();
		area1 = new JTextArea("List of Extra words:");
		area2 = new JTextArea();
		area2.setRows(8);
		area2.setColumns(40);
		area1.setRows(8);
		area1.setColumns(40);
		
		filter = new FileNameExtensionFilter("TEXT FILES","txt","text");
		chooser.setFileFilter(filter);

		add(panel1,BorderLayout.NORTH);
		add(panel2,BorderLayout.NORTH);
		add(panel3,BorderLayout.NORTH);

		panel1.add(f1Button);
		panel1.add(f2Button);
		panel1.add(button1);
		panel1.add(field1);
		panel1.add(button2);
		panel2.add(area1);
		panel2.add(button3);
		panel3.add(area2);
		panel3.add(button4);
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);	
		button4.addActionListener(this);
		
		f1Button.addActionListener(this);
		f2Button.addActionListener(this);
		
		setLocation(100,100);
		setSize(1000,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == button1)
		{
			if(counter == 0)
			{
				f1.Clear();
				counter += 1;
			}
			area2.setText("Comparision Results:\n"+"File1" +"\t\t"+"File2"+"\n");
			list.clear();
			File1.clear();
			File2.clear();
			list2.clear();
			top1 = null;
			top2 = null;
			
			//System.out.println(file1 + file2);
			
			
			f1.Connect(file1,file2);
			list = f1.ReadFile();
			
		//	System.out.println(list.get(1));
			
			File1 = list.get(0);
			File2 = list.get(1);
			f1.extraCheck(File1);
			f1.extraCheck(File2);
			//System.out.println(list.get(1));
			list2 = c1.sortMap(list.get(0),list.get(1));
			
			for(int i = 0;i<1;i++)
			{
				String[] tmp = list2.get(0);
				for(int j= 0;j<tmp.length - 1;j++)
				{
					//System.out.println("we din here " + tmp[j]);
				}
				
			}

			
			top1 = list2.get(0);
			top2 = list2.get(1);
			alike = c1.Comparision(top1,top2);
		
			
			for(int i=0;i<10;i++)
			{
					
				area2.append(top2[i]+"\t\t"+top1[i]+"\n");
					
				
			}
			
			alike = alike * 10;
			area2.append("\nThe two documents are " +alike+"%"+" alike."+"\n");
			
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
		if(e.getSource() == f1Button)
		{
			int returnVal = chooser.showOpenDialog(this);
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	String filename1 = chooser.getSelectedFile().getName();
		    	
		    	if(filename1.endsWith(".txt"))
		    	{
		    		file1 = chooser.getSelectedFile().getAbsoluteFile(); 
			    	JOptionPane.showMessageDialog(this,"You chose for File1: " +
				            chooser.getSelectedFile().getName());
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this, "Please select a .txt file!");
		    	}
		    }
		}
		    
		if(e.getSource() == f2Button)
		{
			int returnVal = chooser.showOpenDialog(this);
			
		    if(returnVal == JFileChooser.APPROVE_OPTION) 
		    {
		    	String filename = chooser.getSelectedFile().getName();
		    	System.out.println(filename);
		    	
		    	if(filename.endsWith(".txt"))
		    	{
		    		file2 = chooser.getSelectedFile().getAbsoluteFile(); 
			    	JOptionPane.showMessageDialog(this,"You chose for File2: " +
				            chooser.getSelectedFile().getName());
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this, "Please select a .txt file!");
		    	}

		    }
		}
		if(e.getSource() == button4)
		{
			f1.Write2File(top2,top1,alike);
		}
	}
	

}
