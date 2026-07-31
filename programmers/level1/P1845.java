package level1;

import java.util.*;

public class P1845 {
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
		int maxCount = 0;
		Map<Integer, Integer> phoneketmonCount = new HashMap<>();
		
		for(int num : nums) {
			phoneketmonCount.put(num, phoneketmonCount.getOrDefault(num, 0) + 1);
		}
		
		for(int key : phoneketmonCount.keySet()) {
			if(maxCount >= n) {
				break;
			}
			maxCount++;
		}
		
		return maxCount;
	}

}
