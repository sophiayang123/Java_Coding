package company;
import java.util.Scanner;

/**
 * Class CompanyConsole: launches program
 * @author Carolyn MacIsaac, with modifications by Dave Houtman- with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 1: Company Management Tool prototype
 * March 30 2019
 */

public class CompanyConsole {	
	// named constants, used in the menu below
	private static final int ADDEMPLOYEE = 1;
	private static final int DISPLAYEMPLOYEES = 2;
	private static final int DISPLAYSENIOREMPLOYEE = 3;
	private static final int FIND_EMPLOYEE = 4;
	private static final int DELETE_EMPLOYEE = 5;
	private static final int EXIT = 9;
	
	public static int manager  = 1;
	public static int staff = 2;
	public static int temp = 3;
	
	// a variable to hold a company object, itself made up of employees
	private Company startUp;
	
	// used for menu input
	Scanner in = new Scanner(System.in);
	
	// default startup object for the application
	public CompanyConsole() {
		startUp = new Company();
	}

	// starting point of execution for the program; loads a new instance of this
	// class, and runs the menu for user input
	public static void main (String [] args) {	
		CompanyConsole console = new CompanyConsole();
		console.menu();	
	}
	
	// the main interface for the application; the user's choices drive program
	// execution
	public void menu(){	
		int choice;
		do{
		
			System.out.println("********************************************************");
			System.out.println(CompanyConsole.ADDEMPLOYEE + ".  ADD EMPLOYEE");
			System.out.println(CompanyConsole.DISPLAYEMPLOYEES+ ".  DISPLAY EMPLOYEES");
			System.out.println(CompanyConsole.DISPLAYSENIOREMPLOYEE+ ".  DISPLAY SENIOR EMPLOYEE");
			System.out.println(CompanyConsole.FIND_EMPLOYEE+ ".  FIND EMPLOYEE");
			System.out.println(CompanyConsole.DELETE_EMPLOYEE + ".  DELETE EMPLOYEE ");
			System.out.println(CompanyConsole.EXIT + ".  EXIT ");
			System.out.println("*******************************************************\n");
			
			System.out.print("SELECTION: ");
			
			choice = in.nextInt();
			in.nextLine(); //get rid of newline character in buffer
			
			switch(choice){
				case CompanyConsole.ADDEMPLOYEE:
					addEmployee();
					break;
				case CompanyConsole.DISPLAYEMPLOYEES:
					displayEmployees();
					break;
				case CompanyConsole.DISPLAYSENIOREMPLOYEE:
					displaySeniorEmployee();
					break;
				case CompanyConsole.FIND_EMPLOYEE:
					findEmployee();
					break;
				case CompanyConsole.DELETE_EMPLOYEE:
					deleteEmployee();
					break;
				case CompanyConsole.EXIT:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("INVALID CHOICE; PLEASE RE-ENTER");
			}	
		} while(choice != CompanyConsole.EXIT); //end do and exit program
	}//end menu
	
	// outputs senior employee information to the console using findSeniorEmployee
	private void displaySeniorEmployee() {
		if(startUp.getEmployees().size() == 0){
			System.out.println("There are no employees\n");
		}
		else{
			Employee e = startUp.findSeniorEmployee();
			System.out.println("SENIOR EMPLOYEE:\n" +e.toString());
		}
	}

	// loads through the employees array and outputs each Employee's toString() 
	// method in tabular form preceded by table heading for each field presented
	private void displayEmployees() {
		System.out.printf("%-20s%-20s%-20s%-20s%-20s%n%n","NAME", "EMPLOYEE NO.", "START DATE", "SALARY", "EMPLOYEE INFO");
		int size = startUp.currentNumberEmployees();
		for(int i = 0; i < size; i++)
			if (startUp.getEmployees().get(i) !=null)
			   System.out.println(startUp.getEmployees().get(i));
		
	}

	
	private void addEmployee() {	
		if(startUp.isMaximumEmployees())  // check if space available in array first
			System.out.println("Attempt to exceed maximum Employee array size;\n" +
		                       "can't add another employee");
		else{   // prompt user to add new employee information
			
			System.out.println("ENTER NEW EMPLOYEE INFORMATION:\n");
			System.out.print("NAME: ");
			String name = in.nextLine();
			
			System.out.print("EMPLOYEE NUMBER: ");
			int employeeNumber = in.nextInt();
			
			System.out.println("HIRING DATE");
			System.out.print("YEAR: ");
			int year = in.nextInt();
			
			System.out.print("MONTH: ");
			int month = in.nextInt();
			
			System.out.print("DAY: ");
			int day = in.nextInt();
			
			System.out.println("SALARY: ");
			double salary = in.nextDouble();
			
			System.out.println("Employee Type (manager = 1, staff = 2, Temp = 3");
			int employeeType = in.nextInt();
			
			// use Company method to load Employee object to employees array
			Employee employee = startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary, employeeType );
			employee.loadExtraInfo();
				
		}//end else
		
	}//END ADDEMPLOYEE()
	
	private void deleteEmployee() {
		System.out.print("Please enter the employee number that you want to delete");
		int employeeNum = in.nextInt();//prompt user to enter employee number
		Employee somebody = startUp.deleteEmployee(employeeNum); //call startUp.deleteEmployee to implement employee deletion, 
																//get the deleted employee as an Employee object that returned from startUp.deleteEmployee
		if(somebody != null) { //show deleted employee info only if the return result of startUp.deleteEmployee is not null
			System.out.println("The record for "+ somebody.getName()+ ", employee number, " + somebody.getEmployeeNumber()+" has been deleted");
		}else {
			System.out.println("An employee with this number could not be found.");
		}
	}
	
	
	private void findEmployee() {
		System.out.print("Please enter the employee number that you are looking for");
		int employeeNum = in.nextInt();//prompt user to enter employee number to search
		Employee somebody = startUp.findEmployee(employeeNum); //call startUp.findEmployee to implement employee searching
																// get found employee as an Employee object that returned from startUp.findEmployee
		if(somebody!=null) {//show the found employee info only if the return result of startUp.findEmployee is not null.
			System.out.println("The employee you finded is " + somebody.getName());
		}else {
				System.out.println("An employee with that number could not be found.");
		}	
	}
}//END CLASS COMPANYCONSOLE


