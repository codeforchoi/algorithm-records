package stack.level1;

import java.util.*;

public class P64061 {
	public static void main(String[] args) {
		int[][] arr1 = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] arr2 = {1, 5, 3, 5, 1, 2, 1, 4};
		System.out.println(solution(arr1, arr2));
	}
	
	public static int solution(int[][] board, int[] moves) {
		Deque<Integer> stack = new ArrayDeque<>();
		int n = board.length;
		int count = 0;
		
		for(int m : moves) {
			for(int i = 0; i < n; i++) {
				if(board[i][m - 1] == 0) continue;
				
				int doll = board[i][m - 1];
				board[i][m - 1] = 0;
				
				if(!stack.isEmpty() && stack.peek() == doll) {
					stack.pop();					
					count += 2;
				} else {
					stack.push(doll);
				}
				
				break;
			}
		}       
        return count;
    }
}
