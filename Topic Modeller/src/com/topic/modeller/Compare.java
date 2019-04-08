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
        LinkedHashMap<String, Integer> SortedMap = new LinkedHashMap<>();
        File1.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> SortedMap.put(x.getKey(), x.getValue()));
        
        LinkedHashMap<String, Integer> SortedMap1 = new LinkedHashMap<>();
        File2.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> SortedMap1.put(x.getKey(), x.getValue()));
		
        
        

    		for(String temp : SortedMap1.keySet())
    		{		

					if(counter == 10)
					{

						break;
					}   	        	
    				
    				if(Scounter == 0)
    				{	
    					top10 = temp;
    				}
    				else
    				{
    					top10 = top10 + " " + temp;
    				}
    				counter = counter + 1;
    				Scounter += 1;
    	       
    		}
    		String[] top1 = top10.split(" ");
    		 		
    		
    		counter = 0;
    		Scounter= 0;
    		
    		for(String temp : SortedMap.keySet())
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
    		
    		String[] top2 = top10s.split(" ");
    		System.out.println(top10);
    		
    		list.add(top1);
    		list.add(top2);
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
