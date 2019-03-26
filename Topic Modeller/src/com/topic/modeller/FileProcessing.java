package com.topic.modeller;

import java.io.File;
//import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileProcessing 
{
	int i = 0;
	File fleName;
	File fleName2;
	File fleName3;
	Scanner myScanner;
	Scanner myScanner2;
	Scanner myScanner3;
	String temp;
	String nonowords;
	boolean stopped = false;

	//HashMap to get a key and a value
	LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();
	
	public void Connect()
	{
		String file = "PokemonHG.txt";
		String file2 = "League.txt";
		String stop = "stopwords.txt";
		
		try
		{
			fleName = new File(file);
		    fleName2 = new File(file2);
		    fleName3  = new File(stop);
			myScanner = new Scanner(fleName);
			myScanner2 = new Scanner(fleName2);
			myScanner3 = new Scanner(fleName3);
		}
		catch(Exception e)
		{
			System.out.println("No File Exists");
		}
		ReadFile();
	}
	

	
	
	
	public void ReadFile()
	{
		int counter = 0;
		try
		{
			while(myScanner3.hasNextLine())
			{
				if(counter == 0)
				{
					nonowords = myScanner3.next();
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
					counter += 1;
				}
				else
				{					
					nonowords = nonowords + " " + myScanner3.next();
					nonowords.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
					
				}
				
			}
			//System.out.println(nonowords);
			while(myScanner2.hasNextLine())
			{
				temp = myScanner2.next();
				temp = temp.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();
				
				if(ValidateWord(temp,myScanner3))
				{
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
			
			while(myScanner.hasNextLine())
			{
				temp = myScanner.next();
				temp = temp.replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase();

				if(ValidateWord(temp,myScanner3))
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
			System.out.println("Please Connect to a file first");
		}
		
		Compare compare= new Compare();
		compare.sortMap(File1,File2);
		
		/*
		for(String temp : File1.keySet())
		{
			int counter1 = File1.get(temp);
			System.out.println(counter1+" "+temp);
		}
		*/
			
	/*	for(i=0;i<429;i++)
		{
			System.out.println(stopwords[i]);
		}
		*/
	}
	
	public boolean ValidateWord(String word, Scanner myScanner3)
	{
		String[] stopwords = nonowords.split(" ");
		boolean Valid = true;
		i = 0;
		while(myScanner3.hasNextLine())
		{
			stopwords[i] = myScanner3.next();
			i += 1;

		}
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
}
