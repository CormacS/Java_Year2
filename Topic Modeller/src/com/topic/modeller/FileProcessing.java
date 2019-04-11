package com.topic.modeller;

/*
 * Author: Cormac Smith
 * Date Due: 12th April 2019
 * Project Description:
 * This project reads in two files and based on the top 10 most common words in each, checks to see if they are
 * alike by comparing how many in common the 2 files. Users can then manually select words to be removed and can output the results
 * to a file	
 * 
 * Class Description:
 * This is my File Processing class, it connects to the files, reads the files,checks the words in each file against a list of stop words
 * and words the user has manually selected. It also writes the results out to a file and clears the contents of the extra words
 * file the User can enter into.
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class FileProcessing 
{
	//Attributes used in this class. 
	private static int yeet = 0;
	private int i = 0;
	private File fleName;
	private File fleName2;
	private File fleName3;
	private File fleName4;
	private Scanner Scanners;
	private Scanner Scanners2;
	private Scanner myScanner;
	private Scanner myScanner2;
	private Scanner myScanner3;
	private String temp;
	private String nonowords;
	private boolean stopped = false;
	private File extra = new File("specific.txt");

	//HashMaps used to store the results and a List of Hashmaps to pass them between classes.
	private List<LinkedHashMap<String,Integer>> list = new ArrayList<LinkedHashMap<String,Integer>>();
	private LinkedHashMap<String, Integer> File1 = new LinkedHashMap<>();
	private LinkedHashMap<String, Integer> File2 = new LinkedHashMap<>();

	//This method is used to connect the files
	public void Connect(File fleName,File fleName2)
	{
		String stop = "stopwords.txt";
		
		try
		{
		    setFleName3(new File(stop));
			setMyScanner(new Scanner(fleName));
			setMyScanner2(new Scanner(fleName2));
			setMyScanner3(new Scanner(getFleName3()));
		}
		catch(Exception e)
		{
			System.out.println("Can't connect to File");
		}
	}

	// This method is used to read through the contents of each File and store the results in the Hashmaps
	// Everytime a word is read, it is passed to the ValidateWord method to check if the word is in stopwords file.
	public List<LinkedHashMap<String,Integer>> ReadFile()
	{
		//Clearing the contents of the files.
		if(getFile1().isEmpty() == false)
		{
			getFile1().clear();
			
		}
		if(getFile2().isEmpty() == false)
		{
			getFile2().clear();
			
		}
		if(getList().isEmpty() == false)
		{
			getList().clear();
			
		}

		int counter = 0;
		
		//Reading in all the stop words into a string
		try
		{
			while(getMyScanner3().hasNext())
			{
				String str = getMyScanner3().nextLine();
				// If its the first word just add it to the string, any word after that needs to be appended onto the string, which is why
				// I used the counter.
				if(counter == 0)
				{
					setNonowords(str);
					//Replacing all special characters and capital letters from the word
					getNonowords().replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.!,'])","").toLowerCase();
					counter += 1;
				}
				else
				{					
					setNonowords(getNonowords() + " "+str);
					getNonowords().replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.!,'])","").toLowerCase();
					
				}
				
			}
			//Checking the words in file 2 and passing them to the Validate method 
			while(getMyScanner2().hasNext())
			{
				setTemp(getMyScanner2().next());
				setTemp(getTemp().replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase());
				
				//Here we pass the word to the validate class to see if its okay to add to the Hashmap
				boolean extracheck = ValidateWord(getTemp());
				if(extracheck == true)
				{
					//Here I am checking if the Hashmap already contains the word, if it does increase the value by 1, else add the key
					// and set the default to 1
					if(getFile2().keySet().contains(getTemp()))
					{
						getFile2().put(getTemp(),getFile2().get(getTemp())+1);
					}
					else
					{
						getFile2().put(getTemp(),1);
					}
				}
			}
			
			//Checking the words in file 1 and passing them to the Validate method 			
			while(getMyScanner().hasNext())
			{
				setTemp(getMyScanner().next());
				setTemp(getTemp().replaceAll("(?:--|[\\\\[\\\\]{}()+/\\\\\\\\.,'])","").toLowerCase());

				//Here I am checking if the Hashmap already contains the word, if it does increase the value by 1, else add the key
				// and set the value to 1
				if(ValidateWord(getTemp()) == true)
				{
					if(getFile1().keySet().contains(getTemp()))
					{
						getFile1().put(getTemp(),getFile1().get(getTemp())+1);
					}
					else
					{
						getFile1().put(getTemp(),1);
					}
				}
				
				
			}
			
			getMyScanner().close();
			getMyScanner2().close();
			getMyScanner3().close();
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		getList().clear();
		
		//Adding the Hashmaps to the List so I can return them both back
		getList().add(getFile1());
		getList().add(getFile2());
		return getList();
	}
	
	//This method is used to check if a word is on the list of stopwords, if it is return false so it doesnt get added to the Hashmap
	public boolean ValidateWord(String word)
	{
		//Adding the string of bad words to an array. As far as I know, doing it this way is the only way you can initilize an array
		//Without defining the size in advance
		String[] stopwords = getNonowords().split(" ");
		boolean Valid = true;
		setI(0);
		//Checks if the word is in the array of stop words
		for(setI(0);getI()<stopwords.length;i++)
		{
			stopwords[getI()] = stopwords[getI()].replace(",","");
			if(word.equals(stopwords[getI()]))
			{
				Valid = false;
			}
		}
		
		return Valid;
	}
	
	//This class is used to write the Extra stop words the user wants to a new file. I chose to use a file instead of an array
	//Because I mainly wanted to practise writing to files more.
	public void extraWords(String word)
	{
		try
		{
			setYeet(getYeet() + 1);
            BufferedWriter out = new BufferedWriter(new FileWriter(getExtra(), true)); 
            out.write(word);
            out.newLine();
            out.close(); 
		}
		catch(Exception e)
		{
			System.out.println("Error writing/creating names.txt");
		}
		
	}
	
	//This checks if the extra words the user has entered are in the hashmap, if they are, remove the key.
	public void extraCheck(LinkedHashMap<String,Integer> File)
	{
		String check;
		try
		{
			setScanners(new Scanner(getExtra()));
			
			while(getScanners().hasNextLine())
			{
				check = getScanners().next();
				//Here is where we check if the word is in the hashmap
				if(File.containsKey(check))
				{
					File.remove(check);
					System.out.println("\n\n Removing " + check);
				}
			}
			
			getScanners().close();

		}
		catch(Exception e)
		{

		}
		
	}
	
	//Here we write the results of the comparison to a file.
	public void Write2File(String[] top2,String[] top1,int alike)
	{
		try
		{
		    String str = "Output.txt";
		    setFleName4(new File(str));
		    //Set the BufferedWriter to False to stop appending to the file and just write over the previous contents
		    BufferedWriter writer = new BufferedWriter(new FileWriter(getFleName4(), false));
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
	
	//This is used to clear the extra words file incase the user no longer wants to ignore those words
	public void Clear()
	{
		try
		{
			PrintWriter writer = new PrintWriter(getExtra());
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println("error");
		}
	}


	//Setters and Getters
	
	public static int getYeet() {
		return yeet;
	}

	public static void setYeet(int yeet) {
		FileProcessing.yeet = yeet;
	}


	public int getI() {
		return i;
	}


	public int setI(int i) {
		this.i = i;
		return i;
	}


	public File getFleName() {
		return fleName;
	}


	public void setFleName(File fleName) {
		this.fleName = fleName;
	}


	public File getFleName2() {
		return fleName2;
	}


	public void setFleName2(File fleName2) {
		this.fleName2 = fleName2;
	}


	public File getFleName3() {
		return fleName3;
	}


	public void setFleName3(File fleName3) {
		this.fleName3 = fleName3;
	}


	public File getFleName4() {
		return fleName4;
	}


	public void setFleName4(File fleName4) {
		this.fleName4 = fleName4;
	}


	public Scanner getScanners() {
		return Scanners;
	}


	public void setScanners(Scanner scanners) {
		Scanners = scanners;
	}


	public Scanner getScanners2() {
		return Scanners2;
	}


	public void setScanners2(Scanner scanners2) {
		Scanners2 = scanners2;
	}


	public Scanner getMyScanner() {
		return myScanner;
	}


	public void setMyScanner(Scanner myScanner) {
		this.myScanner = myScanner;
	}


	public Scanner getMyScanner2() {
		return myScanner2;
	}


	public void setMyScanner2(Scanner myScanner2) {
		this.myScanner2 = myScanner2;
	}


	public Scanner getMyScanner3() {
		return myScanner3;
	}


	public void setMyScanner3(Scanner myScanner3) {
		this.myScanner3 = myScanner3;
	}


	public String getTemp() {
		return temp;
	}


	public void setTemp(String temp) {
		this.temp = temp;
	}


	public String getNonowords() {
		return nonowords;
	}


	public void setNonowords(String nonowords) {
		this.nonowords = nonowords;
	}


	public boolean isStopped() {
		return stopped;
	}


	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}


	public File getExtra() {
		return extra;
	}


	public void setExtra(File extra) {
		this.extra = extra;
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
		
}

