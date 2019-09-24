import java.util.Scanner;
import java.util.Random;

public class Nim {
	private Pile pileA;
	private Pile pileB;
	private Pile pileC;
	private Scanner input;
	private Random rnd;

	// Default constructor, constructs the three piles
	public Nim() {
		pileA = new Pile();	
		pileB = new Pile();
		pileC = new Pile();
	}
	
	// All the rules to handle user input
	public boolean PlayerMove() {
		input = new Scanner(System.in); 
		System.out.println("Select a pile: ");
		String inp = input.next().toUpperCase();

		boolean booleanflag=false;

		if (inp.equals("A") || inp.equals("B") || inp.equals("C") ) {
			if(inp.equals("A")) {
				if(pileA.getSize() > 0) {
					System.out.println("How many do you want to remove?");
					int Amount = input.nextInt();
					if(Amount>=1 && Amount<= pileA.getSize()) {		
						pileA.remove(Amount);
						booleanflag = true;		
						return booleanflag;

					}else {
						System.out.println("Pick a number between 1 to "+ pileA.getSize());
//						printPiles();
					}
				}else {
					System.out.println("Pile a is empty, pick another");
//					printPiles();
				}				
							
			}else if(inp.equals("B") ) {
				if( pileB.getSize() > 0) {
					System.out.println("How many do you want to remove?");
					int Amount = input.nextInt();
					if(Amount>=1 && Amount<= pileB.getSize()) {
						pileB.remove(Amount);
						booleanflag = true;
						return booleanflag;
					}else {
						System.out.println("Pick a number between 1 to "+ pileB.getSize());
//						printPiles();
					}
				}else {
					System.out.println("Pile b is empty, pick another");
//					printPiles();
				}
				
			
			}else if (inp.equals("C") ) {
				if (pileC.getSize() > 0) {
					System.out.println("How many do you want to remove?");
					int Amount = input.nextInt();
					if(Amount>=1 && Amount<= pileC.getSize()) { 
						pileC.remove(Amount);
						booleanflag = true;
						return booleanflag;
					}else {
						System.out.println("Pick a number between 1 to "+ pileC.getSize());
//						printPiles();
					}
				}else {
					System.out.println("Pile c is empty, pick another");
//					printPiles();
				}
							
			}			
		}else {
			System.out.println("Invalid pile letter, select a, b or c");
//			printPiles();
		}	
		return booleanflag;		
	}
	
	// Computer move if done 
	public void computerMove() {
		rnd = new Random();
		int randomMove;
		char computerChoice;
		
		//when all pile are not zero
		if (pileA.getSize()!=0 && pileB.getSize()!=0 && pileC.getSize()!=0) {
			String A= "ABC";
			computerChoice = A.charAt(rnd.nextInt(3)); 
			if (computerChoice == 'A') {
				randomMove=1+ rnd.nextInt(pileA.getSize());
				pileA.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}else if (computerChoice == 'B') {
				randomMove=1+ rnd.nextInt(pileB.getSize() );
				pileB.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}else if (computerChoice == 'C') {
				randomMove=1+ rnd.nextInt(pileC.getSize() );
				pileC.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}
			
		//when AB are not zero	
		}else if (pileA.getSize()!=0 && pileB.getSize()!=0) {
			String B="AB";
			computerChoice = B.charAt(rnd.nextInt(2));
			if (computerChoice == 'A') {
				randomMove=1+ rnd.nextInt(pileA.getSize() );
				pileA.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}else if (computerChoice == 'B') {
				randomMove=1+ rnd.nextInt(pileB.getSize() );
				pileB.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}	
		  		
		//when BC are not zero
		}else if (pileB.getSize()!=0 && pileC.getSize()!=0) {
			String C ="BC";
			computerChoice = C.charAt(rnd.nextInt(2));
			if (computerChoice == 'B') {
				randomMove=1+ rnd.nextInt(pileB.getSize() );
				pileB.remove(randomMove);
				System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}else if (computerChoice == 'C') {
				randomMove=1+ rnd.nextInt(pileC.getSize() ) ;
				pileC.remove(randomMove);
				System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}
			
		//when AC are not zero
		}else if (pileA.getSize()!=0 && pileB.getSize()!=0) {
			String D = "AC";
			computerChoice = D.charAt(rnd.nextInt(2));
			if (computerChoice == 'A') {
				randomMove= 1+rnd.nextInt(pileA.getSize() );
				pileA.remove(randomMove);
		  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}else if (computerChoice == 'B') {
				randomMove=1+ rnd.nextInt(pileB.getSize() );
				pileB.remove(randomMove);
				System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
			}
			
		//when single pile are not zero	
		}else if (pileA.getSize()!=0) {
			computerChoice = 'A';
			randomMove=rnd.nextInt(pileA.getSize() )+1;
			pileA.remove(randomMove);
	  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
		}else if (pileB.getSize()!=0) {
			computerChoice = 'B';
	  		randomMove= rnd.nextInt(pileB.getSize() )+1;
			pileB.remove(randomMove);
	  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
		}else if (pileC.getSize()!=0) {
			computerChoice = 'C';
	  		randomMove= rnd.nextInt(pileC.getSize() )+1;
			pileC.remove(randomMove);
	  		System.out.println("Computer takes "+ randomMove + " from pile "+ computerChoice);
		}

}
	
	 // Is the game done?
	public boolean done() {
		boolean Done = false;
		if (pileA.getSize() ==0 && pileB.getSize()==0 && pileC.getSize()==0) {
			Done = true;			
		}
		return Done;
	}
	
	// Print the current state of the piles
	public void printPiles() {		
		System.out.println("\tA\t\tB\t\tC");
		System.out.println("\t"+pileA.getSize()+"\t\t"+pileB.getSize()+"\t\t"+pileC.getSize());		
	}
}	
	

