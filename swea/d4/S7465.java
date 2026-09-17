package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N + M)
 * 공간 복잡도 : O(N)
 */
// Memory: 28,032 kb, Time: 102 ms, Code Length: 1,336
public class S7465 {
	
	private static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				parents[i] = i;
			}			
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			// 경로 압축 최신화
			for(int i = 1; i <= N; i++) {
				find(i);
			}
			
			// 중복 체크
			Set<Integer> set = new HashSet<>();
			for(int i = 1; i <= N; i++) {
				set.add(parents[i]);
			}
			
			sb.append(set.size()).append("\n");
		}
		System.out.println(sb);
	}
	
	private static int find(int n) {
		if(parents[n] == n) return n;
		return parents[n] = find(parents[n]);
	}
	
	private static void union(int u, int v) {
		u = find(u);
		v = find(v);
		if(u != v) parents[u] = v;
	}
}