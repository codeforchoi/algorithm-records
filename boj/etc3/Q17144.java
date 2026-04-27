package etc3;

import java.io.*;
import java.util.*;

public class Q17144 {
    private static int R, C, T;
    private static int[][] map;
    private static int airUpper = -1, airLower = -1;
    private static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airUpper == -1) airUpper = i;
                    else airLower = i;
                }
            }
        }

        while (T-- > 0) {
            map = spread();
            clean();
        }

        System.out.println(getTotalDust());
    }

    private static int[][] spread() {
        int[][] nextMap = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == -1) {
                    nextMap[r][c] = -1;
                    continue;
                }
                if (map[r][c] > 0) {
                    int amount = map[r][c] / 5;
                    int count = 0;
                    for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i], nc = c + dc[i];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                            nextMap[nr][nc] += amount;
                            count++;
                        }
                    }
                    nextMap[r][c] += map[r][c] - (amount * count);
                }
            }
        }
        return nextMap;
    }

    private static void clean() {
        // 위쪽 반시계
        for (int i = airUpper - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < airUpper; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[airUpper][i] = map[airUpper][i - 1];
        map[airUpper][1] = 0;

        // 아래쪽 시계
        for (int i = airLower + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > airLower; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[airLower][i] = map[airLower][i - 1];
        map[airLower][1] = 0;
    }

    private static int getTotalDust() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) sum += map[i][j];
            }
        }
        return sum;
    }
}
