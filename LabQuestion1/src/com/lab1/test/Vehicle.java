package com.lab1.test;

/*********************************************************************************
 * This is a class for registering a vehicle
 * Author: Cormac Smith C17723185
 * Date: 31/1/2019
 ********************************************************************************/


public class Vehicle 
{
	private String owner;
	private String regNum;
	private Integer maxSpeed;
	private String colour;
	private Integer numOfWheels;
	
	//1st Constructor
	Vehicle(String owner)
	{
		this.owner = owner;
	}
	
	//2nd Constructor 
	Vehicle(String owner,String regNum,Integer maxSpeed,String colour,Integer numOfWheels)
	{
		this.owner = owner;
		this.regNum = regNum;
		this.maxSpeed = maxSpeed;
		this.colour = colour;
		this.numOfWheels = numOfWheels;
		
		//System.out.println(owner,regNum,maxSpeed,colour,numOfWheels);
		System.out.println("Owner is "+owner);
		System.out.println(regNum);
		System.out.println(maxSpeed);
		System.out.println(colour);
		System.out.println(numOfWheels);
	}
	
	//Used for printing out a string
	public String toString()
	{
		return "The owner is "+owner+",with a Reg Number of "+regNum+".\n"
				+ "The car has a max speed of "+maxSpeed+" and its colour is "+colour+".\n"
						+ "The car has "+numOfWheels+" wheels.";
	}

}
