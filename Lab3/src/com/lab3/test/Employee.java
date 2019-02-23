package com.lab3.test;

public class Employee 
{
	
	//Attributes
	private String firstName;
	private String surname;
	private int staffNumber;
	private double annualSalary;
	
	public Employee(String firstName,String surname,int staffNumber,double annualSalary)
	{
		this.setFirstName(firstName);
		this.setSurname(surname);
		this.setStaffNumber(staffNumber);
		this.setAnnualSalary(annualSalary);
	}

	//FirstName
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//Surname
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	//StaffNumber
	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	
	//AnnualSalary
	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	
	public String toString()
	{
		return "\n"
				+ "Employee name is "+getFirstName()+" "+getSurname()+". Staff Number: "+getStaffNumber()+".\n"
				+ "With an annual salary of "+getAnnualSalary();
		
	}
	
	public double calculatePay()
	{
		return annualSalary/12;
	}
	
	

}
