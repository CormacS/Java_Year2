package com.lab3.test;

public class HourlyEmployee extends Employee 
{	
	//Attributes
	private double hoursWorked;
	private double hourlyRate;
	
	public HourlyEmployee(String firstName,String surname,double hoursWorked,double hourlyRate,int staffNumber,int annualSalary)
	{
		super(firstName,surname,staffNumber,annualSalary);
		this.setHoursWorked(hoursWorked);
		this.setHourlyRate(hourlyRate);
	}

	//HoursWorked
	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	//HourlyRate
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public double calculatePay()
	{
		return (hourlyRate * hoursWorked);
	}
	
	public String toString()
	{
		return super.toString()
				+". With an hourly rate of "+getHourlyRate()+" and hours worked of "+getHoursWorked();
		
	}


}
