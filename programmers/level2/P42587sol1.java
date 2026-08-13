package level2;

import java.util.*;

public class P42587sol1 {
	public static void main(String[] args) {
		int[] arr1 = {2, 1, 3, 2};
		int[] arr2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(arr1, 2));		
		System.out.println(solution(arr2, 0));		
	}
	
	public static int solution(int[] priorities, int location) {
		int order = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < priorities.length; i++) {			
			pq.offer(priorities[i]);
		}		
		
		while(!pq.isEmpty()) {
			for(int i = 0; i < priorities.length; i++) {
				if(priorities[i] == pq.peek()) {
					pq.poll();
					if(i == location) return order;
					order++;
				}
			}
		}
		return order;
    }

}
