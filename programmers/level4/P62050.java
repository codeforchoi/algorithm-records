package level4;

import java.util.*;

public class P62050 {
    private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	
	private static int[] parent;
	
	private static class Edge {
		int u, v, cost;

		public Edge(int u, int v, int cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}	
	}
	
	public int solution(int[][] land, int height) {
		
		int n = land.length;
		parent = new int[n * n];
		for(int i = 0; i < n * n; i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int cur = land[i][j];
				
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    
					if(find(i * n + j) == find(nr * n + nc)) continue;
					
					int cost = Math.abs(cur - land[nr][nc]);
					if(cost <= height) {
						union(i * n + j, nr * n + nc);
					} else {
						pq.offer(new Edge(i * n + j, nr * n + nc, cost));
					}
				}
			}
		}
		
		for(int i = 0; i < n * n; i++) {
			if(parent[i] == i) count++;
		}
		
		int minCost = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			if(union(edge.u, edge.v)) {
				minCost += edge.cost;
				cnt++;
				
				if(cnt == count - 1) break;
			}			
		}	
        return minCost;
    }
	
	private static int find(int n) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	
	private static boolean union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u == v) return false;
		parent[v] = u;
		return true; 
	}
}
