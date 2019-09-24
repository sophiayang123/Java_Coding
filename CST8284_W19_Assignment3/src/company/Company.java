/**
 * Class Company: abstracts a company
 * @author Carolyn MacIsaac, with modifications by Dave Houtman - with modifications by Shuting Yang
 * student number: 040933020
 * CST8284 lab Sec304
 * Assignment 2: Company Management Tool prototype
 * March 30 2019
 */
package company;
import java.util.Calendar;
import java.util.ArrayList;
public class Company {

	// an array to hold the employees of the company
	private ArrayList<Employee> employees = new ArrayList<>();

	// default constructor; it instantiates the Employee array and pre-loads
	// three employees, to be used for demonstration purposes
	public Company() {	
		addEmployee( "Alvin Spring", 14, new OurDate(2, 12, 2014), 150000, 1);
		addEmployee("Grant Barge", 21, new OurDate(18, 5, 2009), 40000, 2);
		addEmployee("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269, 3);
	}

	// a getter; it returns the current number of Employees loaded in the employee
	// array
	public int currentNumberEmployees() {
		return employees.size();
	}

	// returns a true value if the number of non-null Employees loaded in the
	// employees array is equal to or greater than the array size
	public boolean isMaximumEmployees() {
		return (employees.size() >= 10);
	}

	// return a reference to the array of Employees
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	
	// Find senior employee by converting the start date of each non-null employee
	// in the employees array to its Calendar equivalent, and using Calendar's 
	// before() method to determine which date is earliest.  The index of the
	// earliest start date is used to return a new instance of the most senior
	// employee
	
	public Employee findSeniorEmployee() {
		
		if (currentNumberEmployees()==0) return null;  // return null if no employees entered
		
		int seniorEmployeeIndex = 0; //assume first employee in array is senior
		// instantiate Calendar objects for current and earliest start dates
		Calendar calEarliestStartDate = (Calendar.getInstance());  
		
		// load Calendar object to hold presumed earliest start date using employees[0]
		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), 
				odEarliestStartDate.getMonth(), odEarliestStartDate.getDay());

		// loop through remaining employees and compare to determine earliest start date
		for (int employeeIndex = 1;  employeeIndex < currentNumberEmployees(); employeeIndex++) {
		     OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
		     Calendar calThisStartDate = Calendar.getInstance();  // need to load new instance..
		     calThisStartDate.set(thisStartDate.getYear(),   
						thisStartDate.getMonth(), thisStartDate.getDay());
		     // Use calendar before() method to compare Calendar start dates
		     if (calThisStartDate.before(calEarliestStartDate)){
		    	 seniorEmployeeIndex = employeeIndex;  // set new oldest employee
		    	 calEarliestStartDate = calThisStartDate;
		     }
		}
		return employees.get(seniorEmployeeIndex);  // return employee at index with earliest startdate
	}
	
/*	// An alternate implementation of findSeniorEmployee().  It lacks some of the 
	// sophistication of the above method, but it works reliably
	 
	public Employee findSeniorEmployee() {
		
		if (numberEmployees==0) return null;  // return null if no employees entered
		
		int seniorEmployeeIndex = 0, thisStartDateHash = 0; 
		
		// assume employees[0] is the senior employee and create a hash value 
		// combining the year, month and day
		OurDate oldestStartDate = employees[seniorEmployeeIndex].getStartDate(), thisStartDate;
		int oldestStartDateHash = oldestStartDate.getYear()*10000 +
				oldestStartDate.getMonth()*100 + oldestStartDate.getDay();

		// loop through remaining employees and compare each employee's StartDate 
		// to the current oldest
		for (int employeeIndex = 1;  employeeIndex < numberEmployees; employeeIndex++) {
		     thisStartDate = employees[employeeIndex].getStartDate();
		     thisStartDateHash = thisStartDate.getYear()*10000 +
						thisStartDate.getMonth()*100 + thisStartDate.getDay(); 
		     // compare the two hash values
		     if (thisStartDateHash < oldestStartDateHash){ // if new date was earlier...
		    	 seniorEmployeeIndex = employeeIndex;  // set new oldest employee
		    	 oldestStartDateHash = thisStartDateHash;
		     }
		}
		return employees[seniorEmployeeIndex];  // return employee at index with earliest startdate
	}
*/

	// assuming there is still room in the employees array, this method
	// adds an employee at the location currently pointed to by the 
	// numberEmployees value, which acts as an index to the employees array
	public Employee addEmployee(String name, int employeeNumber, OurDate date, double salary, int employeeType) {
		Employee employee = null; 
		int index = currentNumberEmployees();
		if (!isMaximumEmployees()) {//if the ArrayList contains less than 10 employee, then do the following
			switch(employeeType) {//according to employee type that user specified, add the new employee to the Array List
				case 1:
				employee = new Manager(name, employeeNumber, date, salary, "Supervisor");//instantiate manager class
		    	employees.add(index,employee); //add new manager to employee array List
		    	break;
		    	
				case 2:
				employee = new Staff(name, employeeNumber, date, salary,"Department1");//instantiate staff class
		    	employees.add(index,employee);// add new staff to employee array List
				break;
				
				case 3:
				employee = new Temp(name, employeeNumber, date, salary, new OurDate());//instantiate temporary worker class
		    	employees.add(index,employee);// add new temp worker to employee array List
				break;
			}
		}
		else  // if number of employees in the Array list is more than 10, then stop adding more employees. 
			System.out.println("Attempt to exceed maximum Employee array size");
		return employee;	
	}
	
	//according to user input, find the specified employee
	public Employee findEmployee(int employeeNum) {
		Employee employeeFinded = null; //set an Employee object that contained the info of employee that found from the employee list. 
		for(int i=0; i< employees.size(); i++) {//search the entire Array list.
			if(employees.get(i).getEmployeeNumber()==employeeNum) {
				employeeFinded = employees.get(i);//store the value of the found employee
				break;//Once the employee found, the loop is going to stop. 
			} 
		} 
		return employeeFinded; //return the found employee
	}
	
	//according to user input, delete the specified employee 
	public Employee deleteEmployee(int employeeNum) {
		Employee employeeRemoved = null; // set an Employee object that contained the info of employee that found from the ArrayList
		Employee em = findEmployee(employeeNum);//call findEmployee(int employeeNum) to make sure this employee is exist		
		if(em!=null) { 
			int i = employees.indexOf(em);
			employeeRemoved = employees.get(i);
			employees.remove(i);
		}
	
//		for(int i=0; i<employees.size(); i++) {
//			if(employees.get(i).getEmployeeNumber()==employeeNum) {
//				employeeRemoved = employees.get(i);
//				employees.remove(i);
//				break;
//			}
//		}
		return employeeRemoved; //return deleted employee
	}

}// end class 


