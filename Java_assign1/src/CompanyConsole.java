//package Employee_info;
import java.util.Scanner;
public class CompanyConsole {
	private static final int addEmployee =1;
	private static final int displayEmployees =2;
	private static final int displaySeniorEmployee =3;
	private static final int exit = 9;
	private Company startUp;
	private Scanner in;
	
	public CompanyConsole() {
		in = new Scanner(System.in);
	}

	
	public static void main(String[] args) {
		CompanyConsole cc = new CompanyConsole();
		cc.startUp = new Company();
		cc.meun();
		int n = cc.in.nextInt();
		while(n!=exit) {
//			if(n==addEmployee) {
//				cc.addEmployee(); 
////				System.out.print(cc.startUp.currentNumberEmployees());				
//			}else if(n== displayEmployees){
//				cc.displayEmployees();
//			}else if(n==displaySeniorEmployee) {
//				cc.displaySeniorEmployee();
//			}
			switch(n) {
			case addEmployee:
				cc.addEmployee(); 
				break;			
			case displayEmployees: 
				cc.displayEmployees();
				break;
			case displaySeniorEmployee: 
				cc.displaySeniorEmployee();
				break;		
			}
			cc.meun();
			n = cc.in.nextInt();
		}
		System.out.print ("GoodBye");
	}
	
	
	enum selection {
		addemployee, displayemployee, displaueeSinorEmployee
	}
	public void meun() {
		for(int i=0; i<70; i++) {
			System.out.print("*");
		}
		System.out.printf("%n%s%n%s%n%s%n%s%n","1. ADD EMPLOYEE", "2. DISPLAY EMPLOYEES", "3. DISPLAY SENIOR EMPLOYEE","9. EXIT");
		for(int i=0; i<70; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		System.out.print("SECTION:");
	}
	
	private void addEmployee() {

		System.out.printf("%s%n%s","ENTER NEW EMPLOYEE INFORMATION:","NAME:");
			String na = in.next();		
			System.out.print("EMPLOYEE NUMBER:");
			int en = in.nextInt();
			System.out.printf("%s%n%s","HIRING DATE","YEAR: ");
			int ye = in.nextInt();
			System.out.print("MONTH:");
			int mo = in.nextInt();
			System.out.print("DAY:");
			int da = in.nextInt();
			System.out.print("SALARY:");
			int sa = in.nextInt();
		
		OurDate date = new OurDate(da,mo,ye);
		startUp.addEmployee(na,en, date,sa);
	}
	
	private void displayEmployees() {
		System.out.printf("%-20s%-20s%-20s%-20s%n","NAME", "EMPLOYEE NO.", "START DATE", "SALARY");
		for(int i=0; i<startUp.currentNumberEmployees() ;i++) {
			System.out.print(startUp.getEmployees()[i]);
		}
		
	}
	
	private void displaySeniorEmployee() {
		System.out.printf("%-20s%-20s%-20s%-20s%n","NAME", "EMPLOYEE NO.", "START DATE", "SALARY");
		System.out.println(startUp.findSeniorEmployee() );
	}
	


}
