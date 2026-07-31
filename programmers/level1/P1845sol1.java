package level1;

import java.util.HashMap;
import java.util.Map;

public class P1845sol1 {
	public static void main(String[] args) {		
		int[] arr1 = {3, 1, 2, 3}; 
        int[] arr2 = {3, 3, 3, 2, 2, 4};
        int[] arr3 = {3, 3, 3, 2, 2, 2};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
        System.out.println(solution(arr3));
	}

	public static int solution(int[] nums) {			
		int n = nums.length / 2;		
		Map<Integer, Integer> phoneketmonCount = new HashMap<>();
		
		for(int num : nums) {
			phoneketmonCount.put(num, phoneketmonCount.getOrDefault(num, 0) + 1);
		}	
		
		return Math.min(n, phoneketmonCount.size());
	}
}
