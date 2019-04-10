package com.topic.modeller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileProcessing 
{
	static int yeet = 0;
	int i = 0;
	File fleName;
	File fleName2;
	File fleName3;
	File fleName4;
	Scanner Scanners;
	Scanner Scanners2;
	Scanner myScanner;
	Scanner myScanner2;
	Scanner myScanner3;
	String temp;
	String nonowords;
	boolean stopped = false;
	File extra = new File("specific.txt");

	
	List<LinkedHashMap<String,Integer>> list = new ArrayList<LinkedHashMap<String,Integer>>();
	//HashMap to get a key and a value
	LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();

	public void Connect(File fleName,File fleName2)
	{
		String stop = "stopwords.txt";
		
		try
		{
		    fleName3 = new File(stop);
			myScanner = new Scanner(fleName);
			myScanner2 = new Scanner(fleName2);
			myScanner3 = new Scanner(fleName3);
			
		}
		catch(Exception e)
		{
			System.out.println("I want to Die");
		}
		
		//ReadFile();
	}

	
	public List<LinkedHashMap<String,Integer>> ReadFile()
	{
		if(File1.isEmpty() == false)
		{
			File1.clear();
			
		}
		if(File2.isEmpty() == false)
		{
			File2.clear();
			
		}
		if(list.isEmpty() == false)
		{
			list.clear();
			
		}
		/*
		for(String temp : File2.keySet())
		{
			System.out.println(temp+"\n\n\n yeet");
		}
		*/
		int counter = 0;
		//Reading in all the stop words into a string
		try
		{
			while(myScanner3.hasNext())
			{
				String str = myScanner3.nextLine();
				if(counter == 0)
				{
					nonowords = str;
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.!,'])","").toLowerCase();
					counter += 1;
				}
				else
				{					
					nonowords = nonowords + " "+str;
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.!,'])","").toLowerCase();
					
				}
				
			}
			//Checking the words in file 2 and passing them to the Validate method 
			while(myScanner2.hasNext())
			{
				temp = myScanner2.next();
				temp = temp.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
				
				boolean extracheck = ValidateWord(temp);
				if(extracheck == true)
				{
					//System.out.println("in hereee :o");
					if(File2.keySet().contains(temp))
					{
						File2.put(temp,File2.get(temp)+1);
					}
					else
					{
						File2.put(temp,1);
					}
				}
			}
			
			//Checking the words in file 1 and passing them to the Validate method 			
			while(myScanner.hasNext())
			{
				temp = myScanner.next();
				temp = temp.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();

				if(ValidateWord(temp) == true)
				{
					if(File1.keySet().contains(temp))
					{
						File1.put(temp,File1.get(temp)+1);
					}
					else
					{
						File1.put(temp,1);
					}
				}
				
				
			}
			
			myScanner.close();
			myScanner2.close();
			myScanner3.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		list.clear();
		//Calls the Class Compare to Compare the two validate hashmaps
		list.add(File1);
		list.add(File2);
		return list;
		//Compare compare= new Compare();
		//compare.sortMap(File1,File2);
	}
	
	public boolean ValidateWord(String word)
	{
		String[] stopwords = nonowords.split(" ");
		boolean Valid = true;
		i = 0;
		for(i=0;i<stopwords.length;i++)
		{
			stopwords[i] = stopwords[i].replace(",","");
			if(word.equals(stopwords[i]))
			{
				Valid = false;
			}
		}
		
		return Valid;
	}
	
	public void extraWords(String word)
	{
		try
		{
			yeet = yeet + 1;
            BufferedWriter out = new BufferedWriter(new FileWriter(extra, true)); 
            out.write(word);
            out.newLine();
            out.close(); 
		}
		catch(Exception e)
		{
			System.out.println("Error writing/creating names.txt");
		}
		
	}
	
	public void extraCheck(LinkedHashMap<String,Integer> File)
	{
		String check;
		try
		{
			//System.out.println("IN here");
			Scanners = new Scanner(extra);
			//Scanners2 = new Scanner(extra);
			
			while(Scanners.hasNextLine())
			{
				check = Scanners.next();
				//System.out.println(check + word);
				if(File.containsKey(check))
				{
					File.remove(check);
					System.out.println("\n\n Removing " + check);
				}
			}
			
			
			Scanners.close();

		}
		catch(Exception e)
		{

		}
		
	}
	
	public void Write2File(String[] top2,String[] top1,int alike)
	{
		try
		{
		    String str = "Output.txt";
		    fleName4 = new File(str);
		    BufferedWriter writer = new BufferedWriter(new FileWriter(fleName4, false));
		    writer.write("");
		    for(int i = 0;i<10;i++)
		    {
		    	writer.write(top2[i]+"\t\t"+top1[i]+"\n");
		    }
		    
		    writer.append("\nThe files are "+alike+"% alike\n");
		    
		    writer.close();
		}
		catch(Exception e)
		{
			System.out.println("Can't write to file");
		}
	     

	}
	
	
	
	
	public void Clear()
	{
		try
		{
			PrintWriter writer = new PrintWriter(extra);
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}
		
}

