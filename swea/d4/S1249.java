package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N^2 log N)
 * 공간 복잡도 : O(N^2)
 * Dijkstra 알고리즘
 */
// Memory: 34,924 kb, Time: 166 ms, Code Length: 1,867
public class S1249 {	
	
	private static final int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static final int[] dc = {0, 0, -1, 1};
	
	private static class Info {
		int r, c, time;

		public Info(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());			
			
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
			
			dist[0][0] = 0;
			pq.offer(new Info(0, 0, 0));
			
			while(!pq.isEmpty()) {
				Info cur = pq.poll();
				
				int r = cur.r;
				int c = cur.c;
				int time = cur.time;
				
				// 이미 더 짧은 경로가 있으면 건너뛰기
				if(time > dist[r][c]) continue;
				
				// 목적지에 도착한 경우
				if(r == N - 1 && c == N - 1) break;
				
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 맵 밖으로 나간 경우
					if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					
					int nextTime = time + map[nr][nc];
					
					// 이 경로가 더 짧은 경우
					if(nextTime < dist[nr][nc]) {
						dist[nr][nc] = nextTime;
						pq.offer(new Info(nr, nc, nextTime));
					}
				}
			}	
			
			sb.append("#").append(tc).append(" ").append(dist[N - 1][N - 1]).append("\n");
		}
		
		System.out.println(sb);
	}
}
