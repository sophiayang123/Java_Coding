import java.util.Scanner;
public class LabTest {
	private int value1, value2, gcd;
	
	public void getValues() {
		 Scanner input = new Scanner(System.in);
		 value1 = input.nextInt();
		 while(value1<=0) {
			 System.out.println("Enter value1 that is greater than 0: ");
			 value1 = input.nextInt();
		 }
		 
		 value2 = input.nextInt();
		 while(value2 <=0) {
			 System.out.println("Enter value1 that is greater than 0: ");
			 value2 = input.nextInt();
		 }
	}
	
	public void calculateGcd() {
		int a = value1;
		int b = value2;
		while (b!=0) {
			int temp = a%b;
			a = b;
			b = temp;
		}
		gcd = a;
	}
	
	public void display() {
		System.out.print("The greatest common divisor of"+value1+ "and"+ value2+ "is"+ gcd);
	}
}
