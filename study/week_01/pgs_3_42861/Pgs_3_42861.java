package week_01.pgs_3_42861;

import java.util.*;

public class pgs_3_42861 {
	public static void main(String[] args) {
		int[][] arr = {
			    {0, 1, 1},
			    {0, 2, 2},
			    {1, 2, 5},
			    {1, 3, 1},
			    {2, 3, 8}
		};
		System.out.println(solution(4, arr));		
	}
	
	private static int[] parent;
	
	public static class Edge {
		int u, v, cost;

		public Edge(int u, int v, int cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}		
	}
	
    public static int solution(int n, int[][] costs) {
    	int len = costs.length;
    	Edge[] edges = new Edge[len];
    	
    	for(int i = 0; i < len; i++) {
    		int u = costs[i][0];
    		int v = costs[i][1];
    		int cost = costs[i][2];
    		edges[i] = new Edge(u, v, cost);
    	}
    	
    	// 비용으로 간선을 오름차순으로 정렬
    	Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.cost, o2.cost));
    	
    	// 대표 노드 초기화
    	parent = new int[n];
    	for(int i = 0; i < n; i++) {
    		parent[i] = i;
    	}
    	
    	int count = 0;
    	int minCost = 0;
    	for(Edge edge : edges) {
    		if(count == n - 1) break; // MST의 간선의 개수는 (정점의 개수 - 1)
    		// 대표노드가 같지 않으면 통합
    		if(find(edge.u) != find(edge.v)) {
    			union(edge.u, edge.v);
    			minCost += edge.cost;
    			count++;
    		}
    	}        
        return minCost;
    }
    
    // 대표 노드 조회
    private static int find(int n) {
    	if(parent[n] == n) return n;
    	return parent[n] = find(parent[n]);
    }
    
    // 대표 노드 갱신 (parent[u]를 변경)
    private static void union(int u, int v) {
    	u = find(u);
    	v = find(v);
    	if(u != v) parent[u] = v;
    }
}
