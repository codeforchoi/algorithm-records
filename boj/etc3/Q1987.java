package etc3;

import java.io.*;
import java.util.*;

//
public class Q1987 {
    private static int R, C, maxCount = 0;
    private static int[][] map;
    private static boolean[] visited = new boolean[26];
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 'A';
            }
        }

        // 시작 지점 방문 처리
        visited[map[0][0]] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    private static void dfs(int r, int c, int count) {
        maxCount = Math.max(maxCount, count);

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                int nextChar = map[nr][nc];

                // 아직 사용하지 않은 알파벳인 경우만 진입
                if (!visited[nextChar]) {
                    visited[nextChar] = true;
                    dfs(nr, nc, count + 1);
                    visited[nextChar] = false; // 백트래킹의 핵심: 원상복구
                }
            }
        }
    }
}
