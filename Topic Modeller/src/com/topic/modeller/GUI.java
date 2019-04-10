package com.topic.modeller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUI extends JFrame implements ActionListener
{

	private FileProcessing f1 = new FileProcessing();
	private Compare c1 = new Compare();
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
	private List<LinkedHashMap<String,Integer>> list = new ArrayList<LinkedHashMap<String,Integer>>();
	private LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();
	private List<String[]> list2 = new ArrayList<String[]>();
	private String[] top1;
	private String[] top2;
	private int alike = 0;
	private int counter = 0;
	File file1;
	File file2;
	private static int f1counter = 0;
	private static int f2counter = 0;
	
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
			if(f1counter > 0 && f2counter > 0)
			{
				if(getCounter() == 0)
				{
					getF1().Clear();
					setCounter(getCounter() + 1);
				}
				
				area2.setText("Comparision Results:\n"+"File1" +"\t\t"+"File2"+"\n");
				getList().clear();
				getFile1().clear();
				getFile2().clear();
				getList2().clear();
				setTop1(null);
				setTop2(null);
				
				getF1().Connect(file1,file2);
				setList(getF1().ReadFile());
				
				setFile1(getList().get(0));
				setFile2(getList().get(1));
				
				getF1().extraCheck(getFile1());
				getF1().extraCheck(getFile2());
				
				setList2(getC1().sortMap(getList().get(0),getList().get(1)));
				
				setTop1(getList2().get(0));
				setTop2(getList2().get(1));
				
				setAlike(getC1().Comparision(getTop1(),getTop2()));
			
				for(int i=0;i<10;i++)
				{
					area2.append(getTop2()[i]+"\t\t"+getTop1()[i]+"\n");
				}
				
				setAlike(getAlike() * 10);
				area2.append("\nThe two documents are " +getAlike()+"%"+" alike."+"\n");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Please select the 2 files first");
			}
			
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
			getF1().Clear();
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
			    	f1counter =+ 1;
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
			    	f2counter += 1;
		    	}
		    	else
		    	{
		    		JOptionPane.showMessageDialog(this, "Please select a .txt file!");
		    	}

		    }
		}
		if(e.getSource() == button4)
		{
			getF1().Write2File(getTop2(),getTop1(),getAlike());
		}
	}

	public FileProcessing getF1() {
		return f1;
	}

	public void setF1(FileProcessing f1) {
		this.f1 = f1;
	}

	public Compare getC1() {
		return c1;
	}

	public void setC1(Compare c1) {
		this.c1 = c1;
	}

	public List<LinkedHashMap<String,Integer>> getList() {
		return list;
	}

	public void setList(List<LinkedHashMap<String,Integer>> list) {
		this.list = list;
	}

	public LinkedHashMap<String, Integer> getFile1() {
		return File1;
	}

	public void setFile1(LinkedHashMap<String, Integer> file1) {
		File1 = file1;
	}

	public LinkedHashMap<String, Integer> getFile2() {
		return File2;
	}

	public void setFile2(LinkedHashMap<String, Integer> file2) {
		File2 = file2;
	}

	public List<String[]> getList2() {
		return list2;
	}

	public void setList2(List<String[]> list2) {
		this.list2 = list2;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String[] getTop1() {
		return top1;
	}

	public void setTop1(String[] top1) {
		this.top1 = top1;
	}

	public String[] getTop2() {
		return top2;
	}

	public void setTop2(String[] top2) {
		this.top2 = top2;
	}

	public int getAlike() {
		return alike;
	}

	public void setAlike(int alike) {
		this.alike = alike;
	}
	

}
