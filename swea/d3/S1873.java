package d3;

import java.io.*;
import java.util.*;

public class S1873 {

	private static int H, W;
	private static int nx, ny, dir;
	private static char[][] map;

	private static final int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	private static final int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		Map<Character, Integer> tank = new HashMap<>();
		tank.put('^', 0);
		tank.put('v', 1);
		tank.put('<', 2);
		tank.put('>', 3);

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			nx = ny = dir = 0;
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (tank.containsKey(map[i][j])) {
						nx = i;
						ny = j;
						dir = tank.get(map[i][j]);
					}
				}
			}
			

			int N = Integer.parseInt(br.readLine());
			String commandLine = br.readLine();

			for (int i = 0; i < N; i++) {
				char command = commandLine.charAt(i);

				switch (command) {
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':					
					move(3);
					break;
				case 'S':					
					shoot(dir);
					break;
				default:
				}				
			}

			// 입력 처리 후 게임의 맵의 상태 출력
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	private static void move(int d) {
		dir = d; // dir 최신화
		int x = nx + dx[d];
		int y = ny + dy[d];
		
		char tank = map[nx][ny];
		switch (d) {
		case 0:
			tank = '^';
			break;
		case 1:
			tank = 'v';
			break;
		case 2:
			tank = '<';
			break;
		case 3:
			tank = '>';
			break;
		default:
		}

		// 맵 밖을 벗어나는 경우
		if (x < 0 || y < 0 || x >= H || y >= W) {
			map[nx][ny] = tank;
			return;
		}			

		switch (map[x][y]) {
		// 가는 방향이 평지가 아니라서 갈 수 없는 경우
		case '*': case '#': case '-':
			break;
		// 가는 방향이 평지라서 갈 수 있는 경우
		case '.':
			map[nx][ny] = '.';
			nx = x;
			ny = y;
			break;
		default:
		}
		
		map[nx][ny] = tank;
	}

	private static void shoot(int d) {
		int x = nx;
		int y = ny;

		while (true) {
			x = x + dx[d];
			y = y + dy[d];

			// 맵 밖을 벗어나거나 강철 벽에 쏠 경우
			if (x < 0 || y < 0 || x >= H || y >= W || map[x][y] == '#')
				return;

			// 벽돌 벽을 만나서 부순 경우
			if (map[x][y] == '*') {
				map[x][y] = '.';
				return;
			}
		}
	}
}