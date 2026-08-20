package week_01;

import java.util.*;

public class pgs_1_42584 {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	public static int[] solution(int[] prices) {
		int n = prices.length;
		int[] result = new int[n];
		
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
        	// stack이 비어있지 않거나 가격이 떨어진 경우
        	while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) { 
        		int index = stack.pop();
        		result[index] = i - index;
        	}
        	stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	int index = stack.pop();
        	result[index] = (n - 1) - index;
        }       
        return result;
    }	
}
