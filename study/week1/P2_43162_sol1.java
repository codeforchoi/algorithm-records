package week1;

import java.util.*;

public class P2_43162_sol1 {
	public static void main(String[] args) {
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}
	
	private static int[] parent;

	public static int solution(int n, int[][] computers) {
		List<Integer>[] graph = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i != j && computers[i][j] == 1) {
					graph[i].add(j);	
				}
			}
		}
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int v : graph[i]) {
				if(count == n - 1) break;
				if(find(i) != find(v)) {
					union(i, v);
					count++;
				}
			}
		}
		
        return n - count;
    }
	
	private static int find(int n) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	
	private static void union(int u, int v ) {
		u = find(u);
		v = find(v);
		if(u != v) parent[u] = v;
	}    
}
