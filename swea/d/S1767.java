package d;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N * 5^k) (5는 상, 하, 좌, 우, 연결x, k는 가장자리 아닌 코어 개수) 
 * 공간 복잡도 : O(N^2)
 */
// Memory: 29,920 kb, Time: 124 ms, Code Length: 3,186
public class S1767 {

	private static final int EMPTY = 0;
	private static final int CORE = 1;
	private static final int WIRE = 2;

	private static final int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static final int[] dc = { 0, 0, -1, 1 };

	private static int N, maxCount, minWire;
	private static int[][] map;	
	private static List<Core> cores;

	private static class Core {
		int r, c;

		public Core(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			cores = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (isTargetCore(i, j)) {
						cores.add(new Core(i, j));
					}
				}
			}
			
			maxCount = 0;
			minWire = N * N; // wire 길이가 N^2을 넘을 수 없음.

			dfs(0, 0, 0);

			sb.append(minWire).append("\n");
		}
		System.out.println(sb);
	}

	// idx : 코어 인덱스, count : 코어수, wireLen : 전선 길이
	private static void dfs(int idx, int count, int wireLen) {
		// 앞으로 확인할 것보다 maxCount가 높으면 더 해볼 필요 없음 (가지치기)
		if(count + (cores.size() - idx) < maxCount) {
			return;
		}
		// 앞으로 확인할 것이 maxCount와 같은데 wireLen이 이미 minWire보다 크거나 같으면 더 해볼 필요 없음 (가지치기)
		else if(count + (cores.size() - idx) == maxCount && wireLen >= minWire) {
			return;
		}
		
		if (idx == cores.size()) {
			if (count > maxCount) {
				maxCount = count;
				minWire = wireLen;
			} else if (count == maxCount) {
				minWire = Math.min(minWire, wireLen);
			}
			return;
		}

		Core core = cores.get(idx);

		int nr = core.r;
		int nc = core.c;

		// 코어를 연결하는 경우
		// 4방향으로 해본다.
		for (int dir = 0; dir < 4; dir++) {
			// 해당 방향으로 코어가 연결 가능한 경우
			if (canConnect(nr, nc, dir)) {				
				wireLen += setWire(nr, nc, dir, WIRE);
				dfs(idx + 1, count + 1, wireLen);
				wireLen -= setWire(nr, nc, dir, EMPTY); // 백트래킹
			}
		}

		// 코어를 연결하지 않는 경우
		dfs(idx + 1, count, wireLen);
	}

	// r : 행, c : 열, d : 방향
	private static boolean canConnect(int r, int c, int d) {

		int nr = r;
		int nc = c;

		while (true) {
			nr += dr[d];
			nc += dc[d];

			// 맵 밖인 경우
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				break;

			if (map[nr][nc] != 0) {
				return false;
			}
		}

		return true;
	}

	// r : 행, c : 열, d : 방향, v : 세팅값
	private static int setWire(int r, int c, int d, int v) {
		int len = 0;

		while (true) {
			r += dr[d];
			c += dc[d];

			// 맵 밖인 경우
			if (r < 0 || c < 0 || r >= N || c >= N)
				break;

			map[r][c] = v;
			len++;
		}
		return len;
	}

	private static boolean isTargetCore(int i, int j) {
		return (i != 0) && (i != N - 1) && (j != 0) && (j != N - 1) && (map[i][j] == 1);
	}
}