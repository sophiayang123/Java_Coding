package company;

/**
 * Class Employee: abstracts a Company employee
 * @author Carolyn MacIsaac, with modifications by Dave Houtman - with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 2: Company Management Tool prototype
 * March 30 2019
 */

public abstract class Employee {
	// private fields to hold relevant Employee information
    private String name;         // Employee's full name
    private int employeeNumber;  // Employee's work number
    private OurDate startDate;   // Employee's first day of work
    private double salary;       // Employee's current salary
    
    // default constructor; uses values that clearly indicate default conditions;
    // chained to (String, int, OurDate, double) Employee constructor below
    public Employee() { this("unknown", -9, new OurDate(), -1);  }
	
    // load constructor using Employee's full name, work number, start date and salary
    public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}
	
    // return's the Employee's full name as a String
	public String getName() { return name;  }
	
	// return's the Employee number, as an int
	public int getEmployeeNumber() {  return employeeNumber;  }
	
	// return's the Employee's starting date, as an OurDate object
	public OurDate getStartDate() {  return startDate;  }
	
	// return's the Employee's salary, as a double
	public double getSalary() {  return salary; }
	
	// Note: all setters in this class are private; all Employee properties
	// must be set through the class constructor only
	public void setName(String name) {  this.name = name;  }
	public void setEmployeeNumber(int employeeNumber) {  this.employeeNumber = employeeNumber;  }
	public void setStartDate(OurDate startDate) {  this.startDate = startDate;  }
	public void setSalary(double salary) {  this.salary = salary;  }

	public abstract void loadExtraInfo();
	
	// Display employee information to the console
	@Override
	public String toString() {
		return String.format("%-20s%-20d%-20s%-20.1f",name, employeeNumber,startDate, salary);
	}
	
	// Compare two employees for equality by comparing their relevant properties
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;	
		
		return (this.getName().equals(other.getName()) && 
				this.getEmployeeNumber() == other.getEmployeeNumber() && 
				this.getStartDate().equals(other.getStartDate())); 
				
	}//END EQUALS METHOD 
	

}//END CLASS EMPLOYEE



