package d4;

import java.io.*;
import java.util.*;

public class S1824 {
	private static int R, C;
	private static char[][] order;
	private static boolean[][][][] visited;
	
	private static int[] dr = {0, 1, 0, -1}; // 우하좌상
	private static int[] dc = {1, 0, -1, 0};
	
	public static class State {
		int r, c;
		int dir;
		int memory;

		public State(int r, int c, int dir, int memory) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.memory = memory;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 1;
		
		

		StringTokenizer st;
		while (T-- > 0) {
			sb.append("#").append(tc++).append(" ");
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			order = new char[R][C];
			for (int i = 0; i < R; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					order[i][j] = line[j];
				}
			}
			
			visited = new boolean[R][C][4][16];
			boolean result = dfs();				
			
			sb.append(result ? "YES" : "NO").append("\n");
		}			
		System.out.println(sb);
	}	
	
	public static boolean dfs() {
		Queue<State> q = new ArrayDeque<>();
		
		q.offer(new State(0, 0, 0, 0));
		visited[0][0][0][0] = true;		
		
		while (!q.isEmpty()) {
			
			State cur = q.poll();
			int r = cur.r;
			int c = cur.c;
			int dir = cur.dir;
			int memory = cur.memory;
			
			char command = order[r][c];
			
			// '@'를 만나면 프로그램 종료
			if(command == '@') {			
				return true;
			}				
			
			switch (command) {
				case '>' : 
					dir = 0;
					break;
				case 'v' : 
					dir = 1;
					break;
				case '<' : 
					dir = 2;
					break;
				case '^' : 
					dir = 3;
					break;
				case '_':
					dir = memory == 0 ? 0 : 2;
					break;
				case '|':
					dir = memory == 0 ? 1 : 3;
					break;
				case '?':
					for(int i = 0; i < 4; i++) {
						move(q, r, c, i, memory);
					}
					continue;
				case '.':
					break;
				case '+':
					if(memory == 15) {
						memory = 0;
					} else {
						memory++;
					}
					break;
				case '-':
					if(memory == 0) {
						memory = 15;
					} else {
						memory--;
					}
					break;						
				default:
					if (command >= '0' && command <= '9') {
						memory = command - '0';
					}
			}
			move(q, r, c, dir, memory);
		}	
		return false;
	}
	
	public static void move(Queue<State> q, int x, int y, int dir, int memory) {
		int nx = x + dr[dir];
		int ny = y + dc[dir];

		// 행 경계 밖 처리
		if (nx < 0)
			nx = R - 1;
		else if (nx >= R)
			nx = 0;

		// 열 경계 밖 처리
		if (ny < 0)
			ny = C - 1;
		else if (ny >= C)
			ny = 0;
		
		if(!visited[nx][ny][dir][memory]) {
			visited[nx][ny][dir][memory] = true;
			q.offer(new State(nx, ny, dir, memory));
		}
	}
}
