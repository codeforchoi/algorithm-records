package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N * (N + M))
 * 공간 복잡도 : O(N + M)
 * 인접리스트 + DFS
 */
// Memory: 103,220 kb, Time: 1,980 ms, Code Length: 1,527
public class S5643 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			List<Integer>[] shorter = new ArrayList[N + 1];
			List<Integer>[] taller = new ArrayList[N + 1];
			
			for(int i = 1; i <= N; i++) {
				shorter[i] = new ArrayList<>();
				taller[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				shorter[b].add(a); // 인덱스 보다 작은 학생들 
				taller[a].add(b); // 인덱스 보다 큰 학생들 
			}
			
			int answer = 0;
			
			for(int i = 1; i <= N; i++) {
				int count = 0;
				boolean[] visited = new boolean[N + 1];
				count += dfs(i, shorter, visited);
				count += dfs(i, taller, visited);
				
				if(count == N - 1) answer++;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int dfs(int cur, List<Integer>[] graph, boolean[] visited) {
		visited[cur] = true;
		int count = 0;
		
		for(int next : graph[cur]) {
			if(!visited[next]) {
				count += dfs(next, graph, visited) + 1;
			}
		}
		return count;
	}
}
