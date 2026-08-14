package stack.level2;

import java.util.*;

public class P42584 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	public static int[] solution(int[] prices) {
		Deque<Integer> stack = new ArrayDeque<>();
		int n = prices.length;
		int[] result = new int[prices.length];
		
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			int index = stack.pop();
			result[index] = n - index - 1; 
		}	
		
        return result;
    }

}
