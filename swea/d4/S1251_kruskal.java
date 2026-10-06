package d4;

import java.io.*;
import java.util.*;

public class S1251_kruskal {
	
	private static int[] parent;
	
	private static class Edge {
		int u, v;
		double cost;
		
		public Edge(int u, int v, double cost) {
			super();
			this.u = u;
			this.v = v;
			this.cost = cost;
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			int[] node_x = new int[N];
			int[] node_y = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				node_x[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				node_y[i] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			Edge[] edges = new Edge[N * (N - 1) / 2];
			
			int idx = 0;
			for(int i = 0; i < N - 1; i++) {
				for(int j = i + 1; j < N; j++) {					
					double cost = E * (Math.pow(node_x[i] - node_x[j], 2) + Math.pow(node_y[i] - node_y[j], 2));
					edges[idx++] = new Edge(i, j, cost);
				}				
			}
			
			Arrays.sort(edges, (o1, o2) -> Double.compare(o1.cost, o2.cost));
			
			parent = new int[N];
			for(int i = 0; i < N; i++) parent[i] = i;
			
			double minCost = 0;
			int count = 0;
			for(Edge edge : edges) {
				if(count == N - 1) break;
				
				if(find(edge.u) != find(edge.v)) {
					union(edge.u, edge.v);
					minCost += edge.cost;
					count++;
				}				
			}
			sb.append("#").append(tc).append(" ").append(Math.round(minCost)).append("\n");
		}		
		System.out.println(sb);
	}
	
	private static int find(int n) {
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}
	
	private static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u != v) parent[v] = u;
	}
}
