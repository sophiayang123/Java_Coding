import java.util.Scanner;
public class LabTest {
	private double startNum, divisionSize;
	
	public LabTest() {
		startNum = 0;
		divisionSize = 0;
	}
	
	public void getValuesFromUser() {
		System.out.print("Enter the start value: ");
		Scanner input = new Scanner (System.in);
		startNum = input.nextDouble();
		while (startNum<=1) {
			System.out.print("Invalid entry…Enter the start value: ");
			startNum = input.nextDouble();
		}
		
		System.out.print("Enter the division size: ");
		divisionSize = input.nextDouble();
		while (divisionSize<=1) {
			System.out.print("Invalid entry…Enter the start value: ");
			divisionSize = input.nextDouble();
		}
	}
	
	public void displayDivisions() {
		while (startNum>= divisionSize) {
			double res = startNum / divisionSize;
			startNum = res;
			System.out.print(res+"\t");
		}
	}
}
