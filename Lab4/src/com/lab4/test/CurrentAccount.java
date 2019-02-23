package com.lab4.test;

public class CurrentAccount extends Account implements ValidateAccount
{

	private double penaltyAmount;
	
	
	public CurrentAccount(String name, String code, String branch, boolean credit, double balance,double penalty)
	{
		super(name,code,branch,credit,balance);
		penaltyAmount = penalty;
	}
	
	public void withdraw(double money)
	{
		if( getAccBalance() < money)
		{
			System.out.println("Insufficent Funds");
		}
		else
		{
			double newbalance; 
			newbalance = getAccBalance() - money;
			setAccBalance(newbalance);
			System.out.println("Account balance is "+getAccBalance());
		}
		
	}
	
	public void checkCredit()
	{
		if(getAccBalance() <= 0)
		{
			setInCredit(false);
		}
		if(getInCredit() == false)
		{
			System.out.println("Your account is not in credit");
		}
		else
		{
			System.out.println("Your account is in credit");
		}
		if(getAccBalance() < 100 && getAccBalance() > 0)
		{
			String warningMessage;
			warningMessage = "WARNING! Your balance is getting low ";
			checkCredit(warningMessage);
		}
		
	}
	
	public void checkCredit(String Message)
	{
		System.out.println(Message);
	}
	
	public void getDetails()
	{
		System.out.println("Account type Current");
		System.out.println(getAccountName());
		System.out.println(getAccBalance());
	}
	public void valuableAccount()
	{
		System.out.println("Account balance is "+getAccBalance());
	
	}
	
}
