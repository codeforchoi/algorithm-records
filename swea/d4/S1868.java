package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N^2)
 * 공간 복잡도 : O(N^2)
 */
// Memory: 40,364 kb, Time: 215 ms, Code Length: 2,389
public class S1868 {
	private static final int BOMB = -2;
	private static final int CHECKED = -1;
	private static final int CLEAR = 0;
	private static final int NEAR_BOMB = 1;

	private static int N, minCount;
	private static int[][] map;

	private static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 상 우상 우 우하 하 좌하 좌 좌상
	private static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	private static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			minCount = 0;

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					char ch = line.charAt(j);
					if (ch == '*') {
						map[i][j] = BOMB;
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							// 맵을 벗어나는 경우
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;

							if (map[nr][nc] == CLEAR) {
								map[nr][nc] = NEAR_BOMB;
							}
						}
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 주변에 지뢰가 없는 0인 경우
					if (map[i][j] == CLEAR) {
						minCount++;
						bfs(i, j);
					}
				}
			}

			// 주변이 모두 지뢰로 둘러싸인 경우
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == NEAR_BOMB) {
						minCount++;
					}
				}
			}

			sb.append(minCount).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {
		Queue<Point> q = new ArrayDeque<>();

		q.offer(new Point(r, c));
		map[r][c] = CHECKED;

		while (!q.isEmpty()) {
			Point cur = q.poll();

			for (int d = 0; d < 8; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];

				// 맵을 벗어나거나 방문한적 있는 경우
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == CHECKED)
					continue;

				// 0인 경우 전파
				if (map[nr][nc] == CLEAR) {
					q.offer(new Point(nr, nc));
				}
				map[nr][nc] = CHECKED;
			}
		}
	}
}