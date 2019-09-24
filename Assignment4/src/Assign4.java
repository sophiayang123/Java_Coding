/*Shuting Yang
 * CST8110 section 340
 * lab teacher name: Hubert Furey
 * This program is to add, delete and get string in an array
 * Assignment 4
 * submission on December 2th 2018
 */
public class Assign4 {

	public static void main(String[] args) {
		boolean testSucceeds;
		
		// Test that the default constructor works properly
		testSucceeds=true;
		SortedStringArray ssa = new SortedStringArray();
		if(ssa.size()!=0)
		{
			System.err.println("Default constructor: initial size is wrong");
			testSucceeds=false;
		}
		if(ssa.capacity()!=10)
		{
			System.err.println("Default constructor: initial capacity is wrong");
			testSucceeds=false;
		}
		if(testSucceeds)
		{
			System.out.println("Default constructor: working correctly");			
		}
		
		// Test that the initial constructor works properly
		SortedStringArray ssa_r = new SortedStringArray(20);
		if(ssa_r.size()!=0)
		{
			System.err.println("Default constructor: initial size is wrong");
			testSucceeds=false;
		}
		if(ssa_r.capacity()!=20)
		{
			System.err.println("Default constructor: initial capacity is wrong");
			testSucceeds=false;
		}
		if(testSucceeds)
		{
			System.out.println("Initial constructor: working correctly");			
		}
				
		// Test that the add method works properly
		ssa.add("c");
		ssa.add("a");
		ssa.add("b");
		ssa.add("e");
		ssa.add("c");
		ssa.add("d");
		ssa.add("d");
		ssa.add("f");
		ssa.add("j");
		ssa.add("h");
		ssa.add("g");
		ssa.add("i");
		String testArray[] =new String[] {"a","b","c","d","e","f","g","h","i","j"};
		for(int i =0; i< ssa.size(); i++) {
			if(!ssa.get(i).equals(testArray[i]) ) {
				System.err.println("Add method is wrong");
				testSucceeds=false;
				break;
			} 
		}
		if(testSucceeds)
		{
			System.out.println("Add : working correctly");			
		}
		
		// Test that the get method works properly
		if(! ssa.get(ssa.size()).equals("ERROR") ) {
			System.err.println("Get method is wrong");
		}
		if(!ssa.get(-1).equals("ERROR")) {
			System.err.println("Get method is wrong");
		}
		if(testSucceeds)
		{
			System.out.println("Get: working correctly");			
		}
		
		// Test that the getIndex method works properly
		if (! (ssa.getIndex("s") == -1)) {
			System.err.println("getIndex is wrong");
		}
		if (!(ssa.getIndex("a")==0)) {
			System.err.println("getIndex is wrong");
		}
		if(testSucceeds)
		{
			System.out.println("getIndex: working correctly");			
		}
		
		// Test that the delete method works properly
		ssa.delete(0);
		ssa.delete("b");
		String testArray_r[] =new String[] {"c","d","e","f","g","h","i","j",null,null};
		for(int i =0; i< ssa.size(); i++) {
			if(!ssa.get(i).equals(testArray_r[i]) ) {
				System.err.println("Add method is wrong");
				testSucceeds=false;
				break;
			} 
		}
		if(testSucceeds)
		{
			System.out.println("delete method: working correctly");			
		}

	}
		
}