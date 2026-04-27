package etc3;

import java.io.*;
import java.util.*;

//
public class Q14500 {
    private static int N, M, max = 0;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
                checkEx(i, j); // 'ㅜ' 모양 별도 체크
            }
        }

        System.out.println(max);
    }

    private static void dfs(int r, int c, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, sum + map[nr][nc], depth + 1);
                visited[nr][nc] = false;
            }
        }
    }

    private static void checkEx(int r, int c) {
        int cnt = 0;
        int total = map[r][c];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                cnt++;
                total += map[nr][nc];
                min = Math.min(min, map[nr][nc]);
            }
        }

        // 인접한 칸이 3개면 그대로 계산, 4개면 가장 작은 값 하나 빼기
        if (cnt == 3) max = Math.max(max, total);
        else if (cnt == 4) max = Math.max(max, total - min);
    }
}
