package testcompany;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import company.Company;
import company.Employee;
import company.Manager;
import company.OurDate;
import company.Temp;

/**
 * @author Carolyn MacIsaac - with modification by Shuting Yang
 */

class TestEmployee {
	Employee e1;
	Employee e2;
	OurDate date;
	Calendar CAL = Calendar.getInstance();
	Company comp;
	
	@BeforeAll
	static void setUpBeforeAllTests() {  System.out.println("STARTING TESTING....");  }

	@AfterAll
	static void tearDownAfterAllTests()  {  System.out.println("ENDING TESTING....");  }

	@BeforeEach
	void setUpBeforeEachTest() {  System.out.println("Starting test....");    }

	@AfterEach
	void tearDownAfterEachTest()  {  System.out.println("Ending test....");;  }

	@Test
	void testEmployeeEquals() {  
		e1 = new Manager("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Surpervisor"); 
		e2 = new Manager("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, "Surpervisor");
		
		assertEquals(e1, e2); }
	
	@Test
	void testEmployeeNotEquals() {  
		OurDate temp1 = new OurDate(1,1,1);
		OurDate temp2 = new OurDate(2,2,2);
		
		e1 = new Temp("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, temp1); 
		e2 = new Temp("Joe Smitk", 43, new OurDate(5, 9, 1987), 55000, temp2);
		
		assertNotEquals(e1, e2); 
		
		e1 = null;
		e2 = null;
	}
	
	@Test
	public void testDefaultOurDateConstructor(){
		date = new OurDate( CAL.get( Calendar.DATE), CAL.get( Calendar.MONTH + 1), CAL.get(Calendar.YEAR));
		assertEquals( date.getDay(), CAL.get( Calendar.DATE));
		assertEquals( date.getMonth(), CAL.get( Calendar.MONTH + 1));
		assertEquals( date.getYear(), CAL.get( Calendar.YEAR));
		
		date = null;
	}
	
	@Test
	public void testOverloadedOurDateConstructor(){
		date = new OurDate( CAL.get( Calendar.DATE), CAL.get( Calendar.MONTH + 1), CAL.get( Calendar.YEAR));
		assertEquals( date.getDay(), CAL.get( Calendar.DATE));
		assertEquals( date.getMonth(), CAL.get( Calendar.MONTH + 1));
		assertEquals( date.getYear(), CAL.get( Calendar.YEAR));
		
		date = null;
	}
	
	@Test
	public void testDeleteEmployeeReturnsNull() {
		comp = new Company();
		assertNull(comp.deleteEmployee(-1));
		//since no employee has employee number as -1, thus comp.deleteEmployee(-1) will return null
	}
	
	@Test 
	public void testDeletesFirstEmployeeOnly() {
		comp = new Company();		
		e1 = comp.addEmployee("FirstEmployee", 3, new OurDate(2,2,2019),10000, 1);
		e2 = comp.addEmployee("SecondEmployee", 3 , new OurDate(3,3,2019), 10000, 1);

		assertEquals( e1 , comp.deleteEmployee(3)); //even the first employee and the second employee have the same employee number,
													//the deleteEmployee method can only delete the first employee. 
		
		e1 = null;
		e2 = null;
	}
	
	@Test
	public void testNoAccidentalDeleteEmployee() {
		comp = new Company();
		comp.deleteEmployee(-2);
		assertEquals(3, comp.currentNumberEmployees());//there are now still 3 employees in the array list since no employee has employeeNumer as -2
		
	}
	
	@Test
	public void testTempEquals() {
		OurDate temp1 = new OurDate(1,1,1);
		OurDate temp2 = new OurDate(1,1,1);
		
		e1 = new Temp("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, temp1); 
		e2 = new Temp("Joe Smith", 44, new OurDate(5, 9, 1987), 55000, temp2);
		//after comparsion, e1 equals e2, so that tempEquals method is effective
		
		assertEquals(e1, e2);
	}

}
