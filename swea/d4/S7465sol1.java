package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N + M)
 * 공간 복잡도 : O(N)
 */
// Memory: 28,928 kb, Time: 108 ms, Code Length: 1,243
public class S7465sol1 {
	
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
			
			// 경로 압축을 하지 않고 무리의 개수를 알 수 있음.
			int count = 0;
			for(int i = 1; i <= N; i++) {
				if(parents[i] == i) count++;
			}
			
			sb.append(count).append("\n");
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