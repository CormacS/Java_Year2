package com.lab4.test;

public class DepositAccount extends Account implements ValidateAccount
{
	private double intrestRate;
	
	public DepositAccount(String name,String code,String branch,boolean credit,double balance,double rate)
	{
		super(name,code, branch, credit, balance);
		setIntrestRate(rate) ;
	}

	public double getIntrestRate() 
	{
		return intrestRate;
	}

	public void setIntrestRate(double intrestRate) 
	{
		this.intrestRate = intrestRate;
	}
	
	public void withdraw(double money)
	{
		System.out.println("You cannot withdraw money from a deposit account. ");
	}
	
	public void getDetails()
	{
		System.out.println("Account type: Deposit");
		System.out.println(getAccountName());
		System.out.println(getAccBalance());
		
	}
	public void valuableAccount()
	{
		System.out.println("Account balance is "+getAccBalance());
	
	}


}
