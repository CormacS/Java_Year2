package com.lab3.test;

public class CommissionEmployee extends Employee 
{

	//Attributes
	private double commissionEarned;

	public CommissionEmployee(String firstName, String surname, int staffNumber, double annualSalary,double commissionEarned) 
	{
		super(firstName, surname, staffNumber, annualSalary);
		this.setCommissionEarned(commissionEarned);
	}

	
	//Commission Earned
	public double getCommissionEarned() {
		return commissionEarned;
	}

	public void setCommissionEarned(double commissionEarned) {
		this.commissionEarned = commissionEarned;
	}

	public String toString()
	{
		return super.toString()
				+". With an commission of "+getCommissionEarned();
		
	}
	
	public double calculatePay()
	{
		return (getAnnualSalary()/12)+commissionEarned;
		
		
	}

	

}
