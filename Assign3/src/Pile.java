
public class Pile {
	private int size;// The current size of pile

//	public Pile() {
//		
//	}
	
	public Pile() {
		size = 10;
	}
	
	 // get current size of pile
	public int getSize() {
		return size;
	}
	
	// remove the amount from pile
	public void remove(int remo) {
			size = size - remo;
	}
}


