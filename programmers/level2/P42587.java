package level2;

import java.util.*;

public class P42587 {
	public static void main(String[] args) {
		int[] arr1 = {2, 1, 3, 2};
		int[] arr2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(arr1, 2));		
		System.out.println(solution(arr2, 0));		
	}
	
	public static class Process {
		int index;
		int priority;
		
		public Process(int index, int priority) {
			super();
			this.index = index;
			this.priority = priority;
		}		
	}
	
	public static int solution(int[] priorities, int location) {
		Queue<Process> queue = new LinkedList<>(); // 실제 프로세스 순서 유지
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < priorities.length; i++) {
			queue.offer(new Process(i, priorities[i]));
			pq.offer(priorities[i]);
		}
		
		int order = 0;
		
		while(!queue.isEmpty()) {
			Process process = queue.poll();
			
			if(process.priority == pq.peek()) {
				pq.poll();
				order++;
				
				if(process.index == location) {
					return order;
				}
			} else {
				queue.offer(process);
			}
		}
		return -1;
    }
}
