import java.util.*;
public class prob1_ver2 {
	Map<Integer, Integer> mp = new HashMap<>(); 
	public int[] twoSum(int[] nums, int target) {
		for(int i =0; i < nums.length; i++) {
			mp.put(nums[i],i);
		}
		
		for (int i = 0; i< nums.length; i++) {
			int comp = target - nums[i];
			if (mp.containsKey(comp) && mp.get(comp)!=i ) {
				int[] result = new int[] {i,mp.get(comp)};
			}
		}
	}
}
