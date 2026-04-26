package etc2;

import java.io.*;
import java.util.*;

// DFS, 사이클 발생하면 SAFE ZONE 찾은 것.
// visit을 세 가지 상태로 정의, 미방문, 방문중, 방문완료
public class Q16724 {
    private static int N, M;
    private static char[][] map;
    private static int[][] visit;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new int[N][M]; // 0: 미방문, 1: 방문중, 2: 방문완료

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visit[i][j] == 0) dfs(i, j);
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = 1; // 방문 중 처리

        int nx = x, ny = y;
        switch(map[x][y]) {
            case 'U': nx--; break;
            case 'D': nx++; break;
            case 'L': ny--; break;
            case 'R': ny++; break;
        }

        if (visit[nx][ny] == 0) {
            dfs(nx, ny);
        } else if (visit[nx][ny] == 1) { // 사이클 발견
            count++;
        }

        visit[x][y] = 2;
    }
}
