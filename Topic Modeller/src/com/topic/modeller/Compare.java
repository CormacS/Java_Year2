package com.topic.modeller;

/*
 * Author: Cormac Smith
 * Date Due: 12th April 2019
 * Description: 
 * This project reads in two files and based on the top 10 most common words in each, checks to see if they are
 * alike by comparing how many in common the 2 files. Users can then manually select words to be removed and can output the results
 * to a file	
 * 
 * Class Description:
 * This is my Compare class, here the HashMaps are ordered by highest value and then the top 10 of each hashmap are put into an array
 * and compared against eachother
 */



import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Compare 
{
	//Attributes
	private int i;
	private int counter = 0;
	private String top10;
	private String top10s;
	private int Scounter = 0;
	private int alike = 0;
	private GUI g1;
	private List<String[]> list = new ArrayList<String[]>();
	
	
	public List<String[]> sortMap(LinkedHashMap<String,Integer> File1, LinkedHashMap<String,Integer> File2)
	{
		
	     LinkedHashMap<String, Integer> SortedFile1 = new LinkedHashMap<>();
	     
	     //The follow code for sorting a hashmap is not mine and was taken from codippa.com
	     File1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	              .forEachOrdered(x -> SortedFile1.put(x.getKey(), x.getValue()));
	        
	     LinkedHashMap<String, Integer> SortedFile2 = new LinkedHashMap<>();
	     File2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                  .forEachOrdered(x -> SortedFile2.put(x.getKey(), x.getValue()));
	     //Borrowed code ends here
       
		setCounter(0);
		setScounter(0);

		//For loop to go through the sorted hashmap and put the top 10 into an array
		for(String temp1 : SortedFile2.keySet())
		{		

				if(getCounter() == 10)
				{

					break;
				}   	        	
				
				if(getScounter() == 0)
				{	
					setTop10(temp1);
				}
				else
				{
					setTop10(getTop10() + " " + temp1);
				}
				setCounter(getCounter() + 1);
				setScounter(getScounter() + 1);
	       
		}
		
    	String[] top2 = getTop10().split(" ");
    	
		setCounter(0);
		setScounter(0);
        
		//For loop to go through the sorted hashmap and put the top 10 into an array
		for(String temp : SortedFile1.keySet())
		{		

				if(getCounter() == 10)
				{

					break;
				}   	        	
				
				if(getScounter() == 0)
				{	
					setTop10s(temp);
				}
				else
				{
					setTop10s(getTop10s() + " " + temp);
				}
				setCounter(getCounter() + 1);
				setScounter(getScounter() + 1);
	       
		}
		String[] top1 = getTop10s().split(" ");
		
		//Adding the top10 of each file to the a list and returning it back
    	getList().add(top2);
    	getList().add(top1);
    	return getList();
    		

    		
	}
	
	//Here is where the top10 of each file are compared against eachother
	public int Comparision(String[] top1,String[] top2)
	{
		setAlike(0);
		for(setI(0);getI()<10;i++)
		{
			for(int j = 0;j<10;j++)
			{
				if(top1[getI()].equals(top2[j]))
				{
					setAlike(getAlike() + 1);
				}
			}
		}
		
		return getAlike();
		
	}

	
	
	//Setters and Getters
	
	public int getI() {
		return i;
	}

	public int setI(int i) {
		this.i = i;
		return i;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public String getTop10() {
		return top10;
	}

	public void setTop10(String top10) {
		this.top10 = top10;
	}

	String getTop10s() {
		return top10s;
	}

	void setTop10s(String top10s) {
		this.top10s = top10s;
	}

	public int getScounter() {
		return Scounter;
	}

	public void setScounter(int scounter) {
		Scounter = scounter;
	}

	public int getAlike() {
		return alike;
	}

	public void setAlike(int alike) {
		this.alike = alike;
	}

	public GUI getG1() {
		return g1;
	}

	public void setG1(GUI g1) {
		this.g1 = g1;
	}

	public List<String[]> getList() {
		return list;
	}

	public void setList(List<String[]> list) {
		this.list = list;
	}
	
	
	

}
