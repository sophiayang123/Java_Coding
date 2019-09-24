public class SortedStringArray {
	private String[] stringArray;
	private int currentSize;	
		
	public SortedStringArray() {
		stringArray = new String[10];
	}
		
	public SortedStringArray(int initialCapacity) {
		stringArray = new String[initialCapacity];
	}
		
		// Add an entry in the correct sorted location
		public boolean add(String s) {			
			boolean flag = true; 				
			for (int i=0; i< stringArray.length; i++) {					
				if (s.equals(stringArray[i]) ) { 
					flag = false;
					return flag;	
				}
			}		
			
			if (size() == stringArray.length) {
				String[] newArray = new String[capacity()+1];
				for (int i = 0; i< stringArray.length; i++) {
					newArray[i]= stringArray[i];
				} 
				newArray[capacity()] = s;
				stringArray = newArray;
			}else {
				int index = size();
				stringArray[index]=s; 
			}		
			
	        int cs = size();
	        String temp;
	        for (int i = 0; i < cs; i++) {
	            for (int j = 1; j < (cs - i); j++) {
	                if (stringArray[j - 1].compareTo( stringArray[j] ) > 0) {
	                    temp = stringArray[j - 1];
	                    stringArray[j - 1] = stringArray[j];
	                    stringArray[j] = temp;
	                }
	            }
	        }		
	        return flag;
		}
		
		
		public void print() {
			for (String s : stringArray) {
				System.out.print(s+"\t");
			}
		}
	
		// Get the entry at the sorted position
		public String get(int index) {
			if (index<0 || index >=stringArray.length) {
				return "ERROR";
			}else {
				return stringArray[index];}
		}
		
		// Get the index of the given entry
		public int getIndex(String entry) {
			for(int i=0; i< stringArray.length; i++) {
				if (stringArray[i].equals (entry) ) {
					return i;
				}
			}		
			return -1;
		}
		
		// Delete the entry at the given index
		public boolean delete(int index) {
			boolean flag = true;
			if (index< 0 || index >= stringArray.length) {
				flag = false;
			}else {
				for (int i = index; i< stringArray.length -1; i++) {				
					stringArray[i] = stringArray[i+1];
				}

				if (size() == capacity()) {
					stringArray[size()-1] = null;
				}
			}return flag;
		}
		
		// Delete the given entry
		public boolean delete (String entry) {
			boolean flag = false;
			outerloop:
			for (int i = 0; i < stringArray.length; i++) {
				if(stringArray[i].equals(entry)) {
					flag = true;
					for (int j=i; j< stringArray.length -1; j++) {				
						stringArray[j] = stringArray[j+1];
					}
					if (size() == capacity()) {
						stringArray[size()-1] = null;
					}
					break outerloop;
				}
			}		
		return flag;	
		}
					
		// Get the current size
		public int size() {
			currentSize = 0;
			for (int k =0; k < stringArray.length; k++) {
				if(stringArray[k]!= null) 
					currentSize = currentSize+1;
			}
			return currentSize;
		}
		
		// Get the current capacity
		public int capacity() {
			int capacity = stringArray.length;
			return capacity;
		}
	
}