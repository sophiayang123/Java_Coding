package company;

/**
 * Class Staff: implementation of abstract employee class as a staff
 * @author Carolyn MacIsaac, with modifications by Dave Houtman - with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 2: Company Management Tool prototype
 * March 30 2019
 */

import java.util.Scanner;

public class Staff extends Employee{
	
	private String department;
	
	//default constructor that chains constructor Staff(String name, 
	//int employeeNumber, OurDate startDate, double salary, String department) below
	public Staff() {
		this("unknown", -9, new OurDate(), -1, "unknown");
	}
	
	//constructor that inherits name, employee number, start date and salary 
	//from its super class, and set the department for staff.
	public Staff(String name, int employeeNumber, OurDate startDate, double salary, String department) {
		super(name, employeeNumber, startDate, salary);
		setDepartment(department);

	}
	
	//public getter for department of each staff
	public String getDepartment() {
		return department;
	}
	
	//public setter for depart of each staff
	public void setDepartment(String department) {
			this.department = department;

	}

	//method that prompts the user to finish the business of initializing the staff fields which not 
	//present in the superclass
	public void loadExtraInfo(){
		System.out.print("Please enter the department of staff");
		Scanner in = new Scanner(System.in);
		String d = in.nextLine();
		
		setDepartment(d);
	}
	
	// prints staff information on console 
	@Override
	public String toString() {
		return super.toString()+"Staff [Department:" + getDepartment() + "]";
	}
	
	// compares two staff objects for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Staff other = (Staff) obj;
		
		return super.equals(obj) && this.getDepartment().equals(other.getDepartment());
		/*
		 * if (department == null) { if (other.department != null) return false; } else
		 * if (!department.equals(other.department)) return false; return true;
		 */
	}

}
