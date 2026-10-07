package week_10.pgs_1_132266;

import java.util.*;

public class Pgs_1_132266 {
	
	private static ArrayList<Integer>[] graph;
	private static List<Integer> minTime;
	
	private static class Info {
		int area, time;

		public Info(int area, int time) {
			super();
			this.area = area;
			this.time = time;
		}	
	}
	
	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		
		graph = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int[] road : roads) {
			graph[road[0]].add(road[1]);
			graph[road[1]].add(road[0]);
		}
		
		minTime = new ArrayList<>();
		for(int source : sources) {
			int time = bfs(n, source, destination);
			minTime.add(time);
		}
			
        return minTime.stream().mapToInt(Integer::intValue).toArray();
    }
	
	private static int bfs(int n, int start, int destination) {
		Queue<Info> q = new ArrayDeque<>();
		boolean[] visited = new boolean[n + 1];
		
		q.offer(new Info(start, 0));
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			int time = cur.time;
			
			if(cur.area == destination) return cur.time;			
			
			for(int next : graph[cur.area]) {				
				if(!visited[next]) {
					visited[next] = true;
					q.offer(new Info(next, time + 1));
				}
			}
		}
		return -1;
	}
}
