package week_09.ssafy_2_test4;

import java.io.*;
import java.util.*;

// 시간복잡: O(N^4), 공간복잡도: O(N^4)
public class Ssafy_2_test4 {
	
	private static final int[] dr = {0, -1, -1, 0, 1, 1, 1, 0, -1}; // 원점, 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상 
	private static final int[] dc = {0, 0, 1, 1, 1, 0, -1, -1, -1};
	
	private static int N, minTime;
	private static int[][] map;
	
	private static class Position {
		int xr, xc, yr, yc, time;

		public Position(int xr, int xc, int yr, int yc, int time) {
			super();
			this.xr = xr;
			this.xc = xc;
			this.yr = yr;
			this.yc = yc;
			this.time = time;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int startXr = Integer.parseInt(st.nextToken()) - 1;
		int startXc = Integer.parseInt(st.nextToken()) - 1;
		int endXr = Integer.parseInt(st.nextToken()) - 1;
		int endXc = Integer.parseInt(st.nextToken()) - 1;
		
		st = new StringTokenizer(br.readLine());
		int startYr = Integer.parseInt(st.nextToken()) - 1;
		int startYc = Integer.parseInt(st.nextToken()) - 1;
		int endYr = Integer.parseInt(st.nextToken()) - 1;
		int endYc = Integer.parseInt(st.nextToken()) - 1;
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Position start = new Position(startXr, startXc, startYr, startYc, 0);
		Position end = new Position(endXr, endXc, endYr, endYc, 0);
		bfs(start, end);
		
		System.out.println(minTime);		
	}
	
	private static void bfs(Position start, Position end) {
		Queue<Position> q = new ArrayDeque<>();
		
		boolean[][][][] visited = new boolean[N][N][N][N];
		
		q.offer(start);
		visited[start.xr][start.xc][start.yr][start.yc] = true;
		
		while(!q.isEmpty()) {
			Position cur = q.poll();
			
			// X, Y 요원 모두 탈출 지점으로 도착했을 경우
			if(isBothAtExit(cur, end)) {
				minTime = cur.time;
				return;
			}
			
			for(int dx = 0; dx < 9; dx++) {
				int nxr = cur.xr + dr[dx];
				int nxc = cur.xc + dc[dx];
				
				// X가 경계를 벗어나거나 벽인 경우
				if(isOutBound(nxr, nxc) || isWall(nxr, nxc)) continue;
				
				for(int dy = 0; dy < 9; dy++) {
					int nyr = cur.yr + dr[dy];
					int nyc = cur.yc + dc[dy];
					
					// Y경계를 벗어나거나 벽인 경우
					if(isOutBound(nyr, nyc) || isWall(nyr, nyc)) continue;
					
					// 이미 방문 두 요원의 위치 조합인 경우
					if(visited[nxr][nxc][nyr][nyc]) continue;
					
					// 발각된 경우
					if(isDetection(nxr, nxc, nyr, nyc)) continue;
					
					visited[nxr][nxc][nyr][nyc] = true;
					q.offer(new Position(nxr, nxc, nyr, nyc, cur.time + 1));
				}
			}
		}
		return; // 탈출할 수 없는 경우는 입력으로 주어지지 않음.		
	}
	
	private static boolean isOutBound(int r, int c) {
		return r < 0 || c < 0 || r >= N || c >= N;
	}
	
	private static boolean isWall(int r, int c) {
		return map[r][c] == 1;
	}
	
	private static boolean isDetection(int rx, int cx, int ry, int cy) {
		return Math.abs(rx - ry) <= 1 && Math.abs(cx - cy) <= 1;
	}
	
	private static boolean isBothAtExit(Position cur, Position end) {
		return cur.xr == end.xr && cur.xc == end.xc && cur.yr == end.yr && cur.yc == end.yc;
	}
}
