package company;

/**
 * Class Temp: implementation of abstracts employee class as a temp employee
 * @author Carolyn MacIsaac, with modifications by Dave Houtman - with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 2: Company Management Tool prototype
 * March 30 2019
 */

import java.util.Scanner;

public class Temp extends Employee{
	//private field to set end date of contract for temp employee
	private OurDate endContractDate;
	
	//default constructor chains constructor Temp(String name, int employeeNumber, OurDate startDate,
	//double salary, OurDate endContractDate) below
	public Temp() {
		this("unknown", -9, new OurDate(), -1, new OurDate());
	}
	
	//constructor inherits the name, employee number, start date and salary from the parent class, 
	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endContractDate) {
		super(name, employeeNumber, startDate, salary);
		setEndContractDate(endContractDate);		
	}
	
	//public getter to get end date of contract
	public OurDate getEndContractDate() {
		return endContractDate;
	}
	
	// public setter for setting contract ended date of each temp worker
	public void setEndContractDate(OurDate endContractDate) {
			this.endContractDate = endContractDate;
	}
	
	//method that prompts the user to finish the business of initializing the Temp fields not
	//present in the superclass
	public void loadExtraInfo(){
		System.out.print("Please enter the ended contract date");
		Scanner in = new Scanner(System.in);
		System.out.println("End contract DATE");
		System.out.print("YEAR: ");
		int year = in.nextInt();
		
		System.out.print("MONTH: ");
		int month = in.nextInt();
		
		System.out.print("DAY: ");
		int day = in.nextInt();

		//call setter to override end contract date
		setEndContractDate(new OurDate(day, month, year));
	}
	
	//print out temp worker information
	@Override
	public String toString() {
		return super.toString()+ "Temp [End of contract:" + getEndContractDate() + "]";
	}
	
	// compares two Temp objects for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Temp other = (Temp) obj;
		
		return super.equals(obj) && this.getEndContractDate().equals(other.getEndContractDate());
		/*
		 * if (endContractDate == null) { if (other.endContractDate != null) return
		 * false; } else if (!endContractDate.equals(other.endContractDate)) return
		 * false; return true;
		 */
	}
}
