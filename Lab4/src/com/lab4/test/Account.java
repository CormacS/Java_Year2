package com.lab4.test;

public class Account implements ValidateAccount
{
	private String accountName;
	private int accountNumber;
	private String sortCode;
	private String branchName;
	private boolean inCredit;
	private double accBalance;
	private static int currentNumber = 0;
	
	public Account(String name,String code,String branch,boolean credit,double balance)
	{
		setAccountName(name);
		setSortCode(code);
		setBranchName(branch);
		setInCredit(credit);
		setAccBalance(balance);
		currentNumber = currentNumber + 1;
		this.accountNumber = currentNumber;
		System.out.println(accountNumber);
		
	}
	

	public void deposit(double money)
	{
		setAccBalance(getAccBalance() + money);
		
	}
	
	public void withdraw(double moneyout)
	{
		setAccBalance(getAccBalance() - moneyout);
		if(getAccBalance() == 0)
		{
			setInCredit(false);
		}
		else
		{
			System.out.println("Your balance is "+getAccBalance() +"\n");
		}
	}

	public String getAccountName()
	{
		return accountName;
	}

	public void setAccountName(String accountName)
	{
		this.accountName = accountName;
	}

	public int getAccountNumber() 
	{
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber = accountNumber;
		
	}

	public String getSortCode() 
	{
		return sortCode;
	}

	public void setSortCode(String sortCode)
	{
		this.sortCode = sortCode;
	}

	public String getBranchName() 
	{
		return branchName;
	}

	public void setBranchName(String branchName)
	{
		this.branchName = branchName;
	}

	public boolean getInCredit()
	{
		return inCredit;
	}

	public void setInCredit(boolean inCredit) 
	{
		this.inCredit = inCredit;
	}

	public double getAccBalance() 
	{
		return accBalance;
	}

	public void setAccBalance(double accBalance) 
	{
		this.accBalance = accBalance;
	}
	
	public void getDetails()
	{
		System.out.println("Account type Account");
		System.out.println(getAccountName());
		System.out.println(getAccBalance());
		
	}
	
	public void valuableAccount()
	{
		System.out.println("Account balance is "+getAccBalance());
	
	}
	
}
