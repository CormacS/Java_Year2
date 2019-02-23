package com.lab3.test;

public class Control {

	public static void main(String[] args) 
	{
		Employee em1 = new Employee("Cormac","Smith",314597,12000);
		System.out.println(em1.calculatePay());
		System.out.println(em1);
		
		HourlyEmployee he1 = new HourlyEmployee("Mac","Riverrock",30,10,12212,0);
		System.out.println(he1);
		System.out.println(he1.calculatePay());
		
		CommissionEmployee ce1 = new CommissionEmployee("Glory","Thirst",1234,1200,20000);
		System.out.println(ce1);
		System.out.println(ce1.calculatePay()+"\n");
		
		
		Employee[] myEmployees = new Employee[3];
		myEmployees[0] = new Employee("Array","0",0000,12012);
		myEmployees[1] = new HourlyEmployee("Array","1",30,10,0001,0);
		myEmployees[2] = new CommissionEmployee("Array","2",0003,1212,20001);
		
		for(int i = 0; i<myEmployees.length;i++)
		{
			System.out.println("Employee "+i+" has a calculated pay of "+myEmployees[i].calculatePay());
		}
		
	}

}
