import java.util.Scanner;

public class Fruit {
	private String orchardName;
	
	public Fruit() {
		
	}
	
	@Override
	public String String() {
		
	}
	
	public boolean addItem(Scanner scanner) {
		System.out.println("Enter the code for the item:");
		String item = null;
		while(!scanner.hasNextInt()) {
			System.out.println("Enter the code for the item");
			item = scanner.next();
		}
		System.out.println("Enter the name for the item: ");
		while(!scanner.hasNext()) {
			System.out.println("Enter the code for the item");
			item = scanner.next();
		}
		System.out.println("Enter the quantity for the item:");
		
	}
	
}
