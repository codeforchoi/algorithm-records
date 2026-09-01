package queue;

import java.util.*;

public class B01 {		
	public static void main(String[] args) {
		System.out.println(solution(5, 2));
	}
	
	public static int solution(int n, int k) {
		Queue<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			q.offer(i);
		}
		
		while(q.size() > 1) {
			for(int i = 0; i < k - 1; i++) {
				q.offer(q.poll());
			}
			q.poll();
		}
		return q.poll();
	}
}
