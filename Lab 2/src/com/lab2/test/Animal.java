 /**********
 * Author: Cormac Smith
 * Date: 07/02/19
 * Task: Encapsulating attributes and using getters and setters
 *//////////////////



package com.lab2.test;

public class Animal 
{
	
	//Attributes
	private String name;
	private String breed;
	private int age;
	private boolean domesticAnimal;
	private String colour;
	
	//1st Constructor
	public Animal(String name)
	{
		this.name = name;
	}
	
	//2nd Constructor
	public Animal(String name, String breed, int age, boolean domesticAnimal, String colour)
	{
		this.setName(name);
		this.setBreed(breed);
		this.setAge(age);
		this.setDomesticAnimal(domesticAnimal);
		this.setColour(colour);
		
	}
	
	//Method?

	
	public String toString()
	{
		return "\n"
				+ "Animal name is "+getName()+". Its breed is "+getBreed()+".\n"
				+ "With an age of "+getAge()+". Its colour is "+getColour()+".\n"
						+ "Domestic: "+getDomesticAnimal()+".";
		
	}
	
	//Setters and Getters for Name
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	//Setters and Getters for Breed
	public String getBreed() 
	{
		return breed;
	}

	public void setBreed(String breed) 
	{
		this.breed = breed;
	}

	//Setters and Getters for Age
	public int getAge() 
	{
		return age;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}
	
	//Setters and Getters for Domestic Animal
	public boolean getDomesticAnimal() 
	{
		return domesticAnimal;
	}

	public void setDomesticAnimal(boolean domesticAnimal) 
	{
		this.domesticAnimal = domesticAnimal;
	}
	
	//Setters and Getters for Colour
	public String getColour() 
	{
		return colour;
	}

	public void setColour(String colour) 
	{
		this.colour = colour;
	}
	
	public void makeNoise()
	{
		if(getBreed().equals("dog"))
		{
			System.out.println("Woof");
		}
		else if(getBreed().equals("cat"))
		{
			System.out.println("Meow");
		}
		else if(getBreed().contentEquals("cow"))
		{
			System.out.println("Moo");
		}
		
	}
	
	public void makeNoise(boolean old)
	{
		if(old)
		{
			System.out.println("Quiet Animal");
		}
		else
		{
			makeNoise();
		}
	}
	

}
