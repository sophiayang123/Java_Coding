/*Shuting Yang
 * CST8110 section 340
 * lab teacher name: Hubert Furey
 * This program is a Nim game, and player can play the game with computer
 * Assignment 3
 * submission on November 15th 2018
 */
public class Assign3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Welcome to the NIM game\r\n" + 
				"We play by the misère rules");	
		Nim nim = new Nim();
		nim.printPiles();
		boolean flag= true;
		
		while (!nim.done()) {
				do {flag = nim.PlayerMove();

					if (nim.done()==false) {
						nim.printPiles();
					}else {
						System.out.println("Sorry, you lose");
					}			
				}while(flag==false);	
				
				if(nim.done()==false) {
					nim.computerMove();
					if (nim.done()==false) {
						nim.printPiles();
					}else{
						System.out.println("Congrants: You win");
					}
				}
		}	
	}
}
