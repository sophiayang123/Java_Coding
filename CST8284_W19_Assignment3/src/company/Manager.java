package company;
/**
 * Class Temp: implementation of abstracts employee class as a manager employee
 * @author Carolyn MacIsaac, with modifications by Dave Houtman - with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 2: Company Management Tool prototype
 * March 30 2019
 */
import java.util.Scanner;

public class Manager extends Employee {
	//private field for title
	private String title;
	
	//the default manager constructor chains Manager(String name,int employeeNumber, OurDate startDate, 
	//double salary, String title) constructor below 
	public Manager() {
		this("unknown", -9, new OurDate(), -1, "unknown");		
	}
	
	//constructor that inherits name, employeeNumber, startDate, salary from its parent constructor, 
	//and uses set method to set title value.
	public Manager(String name,int employeeNumber, OurDate startDate, double salary, String title) {
		super(name,employeeNumber,startDate, salary);
		setTitle(title);
	}
	
	//public getter that get title of manager
	public String getTitle() {
		return title;
	}
	
	// public setter for title of each manager
	public void setTitle(String title) {
		this.title = title;
	}

	////method that prompts the user to finish the business of initializing the manager fields not present 
	//in the superclass
	public void loadExtraInfo(){
		System.out.println("Please enter manager's title");
		Scanner in = new Scanner(System.in);
		String t = in.nextLine();
		setTitle(t);	
	}
	
	//print manager information on console
	@Override
	public String toString() {
		return super.toString()+"Manager [Title:" + getTitle() + "]";
	}
	
	// compares two manager objects for equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		
		return super.equals(obj) && title.equals(other.getTitle()) ;
		/*
		 * if (title == null) { if (other.title != null) return false; } else if
		 * (!title.equals(other.title)) return false; return true;
		 */
	}
}
