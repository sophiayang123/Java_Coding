//package Employee_info;
public class Employee {
	private String name;
	private int employeeNumber;
	private double salary;
	private OurDate startDate;
//	public Object startUp;
	
	public Employee() {
		this("unknow",-9, new OurDate(),-1);			
	}
	
//	public Employee(String name) {
//		this(name,-9);
//	}
//	public Employee(String name, int employeeNumber) {
//		this(name,employeeNumber,new OurDate());
//	}
//	public Employee(String name, int employeeNumber,OurDate startDate) {
//		this(name,employeeNumber,startDate, -1);
//	}
	
	public Employee(String name, int employeeNumber, OurDate startDate, double salary) {
		setName(name);
		setEmployeeNumber(employeeNumber);
		setStartDate(startDate);
		setSalary(salary);
	}
	
	public String getName() {
		return name;
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public OurDate getStartDate() {
		return startDate;
	}
	public double getSalary() {
		return salary;
	}
	private void setName(String name) {
//		if(name.equals("unknow")) {
//			throw new IllegalArgumentException("Invalid name ");
//		}else
		    this.name = name;		
	}
	private void setEmployeeNumber(int employeeNumber) {
//		if(employeeNumber<0 ) {
//			throw new IllegalArgumentException("Invalid employeeNumber ");
//		}else
			this.employeeNumber = employeeNumber;
	}
	
	private void setStartDate(OurDate startDate) {
//		startDate = new OurDate();
		this.startDate = startDate;
	}
	
	private void setSalary(double salary) {	
//		if(salary<0 ) {
//			throw new IllegalArgumentException("Invalid employeeNumber ");
//		}else
			this.salary=salary;
	}
	
	@Override
	public String toString() {
//		return name+"\t\t\t"+employeeNumber+"\t\t\t"+startDate+"\t\t\t"+salary;
		return String.format("%-20s%-20d%-20s%-20.2f%n",name, employeeNumber,startDate, salary);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(this.getClass()!=obj.getClass()){
			return false;
		}
		Employee otherEp = (Employee) obj;
		return this.getName().equals(otherEp.getName()) && this.getEmployeeNumber() == otherEp.getEmployeeNumber() && this.getStartDate().equals(otherEp.getStartDate() );
		//		if(this==null) {
//			return false;
//		}
		
	}
}
