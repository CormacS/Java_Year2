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
	Scanner Scanners;
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

	public void Connect()
	{
		String file = "ScottPilgrim.txt";
		String file2 = "Scotty.txt";
		String stop = "stopwords.txt";
		
		try
		{
			fleName = new File(file);
		    fleName2 = new File(file2);
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
		for(String temp : File2.keySet())
		{
			System.out.println(temp+"\n\n\n yeet");
		}
		int counter = 0;
		//Reading in all the stop words into a string
		try
		{
			while(myScanner3.hasNextLine())
			{
				String str = myScanner3.nextLine();
				if(counter == 0)
				{
					nonowords = str;
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
					counter += 1;
				}
				else
				{					
					nonowords = nonowords + " "+str;
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
					
				}
				
			}
			//Checking the words in file 2 and passing them to the Validate method 
			while(myScanner2.hasNextLine())
			{
				temp = myScanner2.next();
				temp = temp.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
				
				boolean extracheck = ValidateWord(temp);
				if(extracheck == true)
				{
					System.out.println("in hereee :o");
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
			while(myScanner.hasNextLine())
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
		if(yeet != 0 && Valid == true)
		{
			String check;
			try
			{
			//	System.out.println("IN here");
				Scanners = new Scanner(extra);
				
				while(Scanners.hasNextLine())
				{
					check = Scanners.next();
					System.out.println(check + word);
					if(word.equals(check))
					{
						Valid = false;
						System.out.println("\n\n Falseee wrd \n\n" + Valid);
					}
				}
				
				Scanners.close();

			}
			catch(Exception e)
			{

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

