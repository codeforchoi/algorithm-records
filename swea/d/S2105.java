package d;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N^4)
 * 공간 복잡도 : O(N^2)
 */
// Memory: 28,416 kb, Time: 179 ms, Code Length: 1,981
public class S2105 {
	
	private static final int[] dr = {1, 1, -1, -1}; // 우하 좌하 좌상 우상 으로 고정
	private static final int[] dc = {1, -1, -1, 1};
	
	private static int N, startR, startC, maxCount;
	private static int[][] map;
	private static boolean[][] visited;
	private static boolean[] type;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			maxCount = 0;			
			type = new boolean[101];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}			
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					startR = i;
					startC = j;					
					dfs(i, j, 0, 0);
				}
			}
			
			sb.append(maxCount == 0 ? -1 : maxCount).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int r, int c, int dir, int count) {
		if(dir > 3) return;
		// 마지막 방향이고 시작지점이면 탐색 종료
		if(dir == 3 && r == startR && c == startC) {
			maxCount = Math.max(maxCount, count);
			return;
		}
		
		// 이미 있는 종류라면 더 볼 필요가 없음.
		if(type[map[r][c]]) return;
		
		int nr = r + dr[dir];
		int nc = c + dc[dir];
		
		// 경계 밖으로 벗어나는 경우
		if(nr < 0 || nc < 0 || nr >= N || nc >= N) return;
		
		visited[r][c] = true;
		type[map[r][c]] = true;		
		
		// 다음 방향으로 가는 경우
		dfs(r + dr[dir], c + dc[dir], dir + 1, count + 1);
		
		// 같은 방향으로 가는 경우
		dfs(r + dr[dir], c + dc[dir], dir, count + 1);
		
		// 백트래킹
		visited[r][c] = false;
		type[map[r][c]] = false;		
	}
}