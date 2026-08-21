package week_02.pgs_2_49189;

import java.util.*;

public class pgs_2_49189 {
	public static void main(String[] args) {
		int[][] arr = {
			    {3, 6},
			    {4, 3},
			    {3, 2},
			    {1, 3},
			    {1, 2},
			    {2, 4},
			    {5, 2}
			};
		System.out.println(solution(6, arr));		
	}	

	public static int solution(int n, int[][] edge) {		
		List<Integer>[] graph = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int[] e : edge) {
			graph[e[0]].add(e[1]);
			graph[e[1]].add(e[0]);
		}
		
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
				
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;		
		int maxDist = 0;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int v : graph[cur]) {
				if(visited[v]) {
					continue;
				} else {
					visited[v] = true;
					q.offer(v);
					dist[v] = dist[cur] + 1;
					maxDist = Math.max(maxDist, dist[v]);
				}
			}						
		}
		
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if(dist[i] == maxDist) count++;
		}
		return count;
    }	
}
