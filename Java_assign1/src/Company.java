//package Employee_info;
/*
Represents an abstraction of a Company
*/
import java.util.Calendar;
public class Company {
	private Employee[] employee;
	private static int numberEmployees;
	private static final int maxnumEmployees=10;
	
	public Company() {
		employee = new Employee[10];
	}
	
	public void addEmployee(String name, int employeeNumber, OurDate startDate, double salary) {		
		  if(!isMaximumEmployees()) {
			  employee[numberEmployees] = new Employee(name,employeeNumber,startDate,salary); 
			  numberEmployees++; 
			  }		 
		
		/*
		 * for(int i=0; i< employee.length; i++) { if(employee[i]!=null)
		 * numberEmployees++; }
		 */
	}
	
	public int currentNumberEmployees() {
//		int currentEmployees = 0;
//		 for(int i=0; i< employee.length; i++) { 
//			 if(employee[i]!=null)
//				 currentEmployees++;	 
//		}
//		 return currentEmployees;
		return numberEmployees;
	}
	
	public boolean isMaximumEmployees() {
		if(currentNumberEmployees() < maxnumEmployees) 
			return false;
		else
			return true;
	}
	
	public Employee[] getEmployees() {
		return employee;
	}
	
	public Employee findSeniorEmployee() {
		Employee seniorEmployee = new Employee();
		Calendar seniorEmployeeDate = Calendar.getInstance();
		seniorEmployeeDate.set(seniorEmployee.getStartDate().getDay(), 
							seniorEmployee.getStartDate().getMonth(),
							seniorEmployee.getStartDate().getYear());

		for(int i=0; i< currentNumberEmployees(); i++) {
			Calendar EmployeeDate = Calendar.getInstance();
			EmployeeDate.set(employee[i].getStartDate().getDay(), 
							employee[i].getStartDate().getMonth(),
							employee[i].getStartDate().getYear() );

			if(seniorEmployeeDate.after(EmployeeDate)) {
				seniorEmployee = employee[i];
			}
			
	
		}
		
		return seniorEmployee;
	}
	
}
