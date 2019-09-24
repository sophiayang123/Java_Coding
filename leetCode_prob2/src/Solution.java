
class Solution {
    int rev = 0;
    public int reverse(int x) {
        	int z;
			int w = String.valueOf(x).length();	
            if(x==0){
                return rev;
            }
			while(w > 0 ) {			 	
				z = x % 10;				
				rev = rev*10 + z*(int) Math.pow(10, w-1);	
				x = x/10;
//                if (rev > Integer.MAX_VALUE|| (rev == Integer.MAX_VALUE && z > 7)) return 0;
//                if (rev < Integer.MIN_VALUE|| (rev == Integer.MIN_VALUE && z < -8)) return 0;
				--w;
			}			
			return rev;       
    }
		

		public static void main(String[] args) {
			Solution sl = new Solution();		
			System.out.print(sl.reverse(1534236463));
		}

}
