package com.lab2.test;

import java.util.Scanner;

public class Control {

	public static void main(String[] args) 
	{
		Animal a1 = new Animal("Leo","cat",4,false,"Ginger");
		Animal a2 = new Animal("Spot","dog",6,true,"Brown");
		
		Animal a3 = new Animal("Betty");
		a3.setBreed("cow");
		a3.setColour("Black");
		a3.setDomesticAnimal(true);
		a3.setAge(6);
		
		Animal a4 = new Animal("Glory","dog",10,true,"Red");
		
		//These NO longer work as the attributes are now private
		
		//System.out.println(a1.name)
		//System.out.println(a2.age)
		//System.out.println(a2.colour)
		

		a1.setName("Sandy");
		System.out.println(a1.getName());
		
		
		System.out.println(a2);
		System.out.println(a3);
		
		a2.setBreed("dog");
		System.out.println(a2.getBreed());
		
		a1.makeNoise(true);
		a2.makeNoise(false);
		a3.makeNoise(false);
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Something: ");
		String inputString = input.nextLine();
		System.out.print("You Entered: ");
		System.out.print(inputString);
		
		a4.setName(inputString);
		System.out.println(a4.getName());
		
	}

}
