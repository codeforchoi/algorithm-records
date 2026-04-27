package etc3;

import java.io.*;
import java.util.*;

//
public class Q2448 {
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 가로 길이는 2 * N - 1
        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], ' ');
        }

        drawStar(0, N - 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void drawStar(int r, int c, int n) {
        // n이 3이 되면 기본 삼각형을 그림
        if (n == 3) {
            map[r][c] = '*';
            map[r + 1][c - 1] = map[r + 1][c + 1] = '*';
            map[r + 2][c - 2] = map[r + 2][c - 1] = map[r + 2][c] = map[r + 2][c + 1] = map[r + 2][c + 2] = '*';
            return;
        }

        // n을 반으로 나누어 3개의 구역으로 재귀 호출
        int size = n / 2;
        drawStar(r, c, size); // 위쪽
        drawStar(r + size, c - size, size); // 왼쪽 아래
        drawStar(r + size, c + size, size); // 오른쪽 아래
    }
}
