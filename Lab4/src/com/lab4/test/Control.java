package com.lab4.test;

public class Control {

	public static void main(String[] args)
	{
		Account ac1 = new Account("Cormac","4319D","AIB",true,12000);
		DepositAccount dp1 = new DepositAccount("Maciek","ABC123","BOI",true,23400,4);
		CurrentAccount ca1 = new CurrentAccount("Glory","619BYA","ULSTER BANK",true,1000,1);
		
		ac1.deposit(200.4);
		ac1.withdraw(50);
		
		dp1.deposit(10);
		dp1.withdraw(50);
		
		ca1.withdraw(901);
		ca1.checkCredit();
		
		ca1.valuableAccount();
		ca1.getDetails();
		
		System.out.println(ca1.getAccountNumber());
		

	}

}
