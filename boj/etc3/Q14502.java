package etc3;

import java.util.*;
import java.io.*;

//
public class Q14502 {
    private static int N, M, maxSafe = 0;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0);
        System.out.println(maxSafe);
    }

    // 백트래킹으로 벽 3개 세우기
    private static void buildWall(int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count + 1);
                    map[i][j] = 0; // 원상복구
                }
            }
        }
    }

    private static void spreadVirus() {
        int[][] copyMap = new int[N][M];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 2) q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        calculateSafe(copyMap);
    }

    private static void calculateSafe(int[][] copyMap) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) count++;
            }
        }
        maxSafe = Math.max(maxSafe, count);
    }
}
