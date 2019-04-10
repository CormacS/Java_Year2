package com.topic.modeller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Compare 
{
	
	int i;
	int counter = 0;
	String top10;
	String top10s;
	int Scounter = 0;
	int alike = 0;
	GUI g1;
	List<String[]> list = new ArrayList<String[]>();
	
	
	public List<String[]> sortMap(LinkedHashMap<String,Integer> File1, LinkedHashMap<String,Integer> File2)
	{
		//System.out.println(File2);
		
		
	     LinkedHashMap<String, Integer> SortedFile1 = new LinkedHashMap<>();
	     File1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
	              .forEachOrdered(x -> SortedFile1.put(x.getKey(), x.getValue()));
	        
        LinkedHashMap<String, Integer> SortedFile2 = new LinkedHashMap<>();
        File2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> SortedFile2.put(x.getKey(), x.getValue()));
       
    	
		counter = 0;
		Scounter = 0;

		for(String temp1 : SortedFile2.keySet())
		{		

				if(counter == 10)
				{

					break;
				}   	        	
				
				if(Scounter == 0)
				{	
					top10 = temp1;
				}
				else
				{
					top10 = top10 + " " + temp1;
				}
				counter = counter + 1;
				Scounter += 1;
	       
		}
		
    	String[] top2 = top10.split(" ");
    	
		counter = 0;
		Scounter = 0;
        
    	
		for(String temp : SortedFile1.keySet())
		{		

				if(counter == 10)
				{

					break;
				}   	        	
				
				if(Scounter == 0)
				{	
					top10s = temp;
				}
				else
				{
					top10s = top10s + " " + temp;
				}
				counter = counter + 1;
				Scounter += 1;
	       
		}
		String[] top1 = top10s.split(" ");
		


    		
    		//System.out.println(top10);


    		

    		

    		//System.out.println(top10s);
    		
    		list.add(top2);
    		list.add(top1);
    		return list;
    		

    		
	}
	
	public int Comparision(String[] top1,String[] top2)
	{
		alike = 0;
		for(i=0;i<10;i++)
		{
			for(int j = 0;j<10;j++)
			{
				if(top1[i].equals(top2[j]))
				{
					alike = alike + 1;
				}
			}
		}
		
		return alike;
		
	}
	
	
	

}
