package etc2;

import java.io.*;
import java.util.*;

// 백트래킹 (흑, 백 색분리)
public class Q1799 {
    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    private static int maxBlack, maxWhite;

    private static List<int[]> black = new ArrayList<>();
    private static List<int[]> white = new ArrayList<>();

    private static int[] dx = {-1, -1, 1, 1}; // 왼쪽 위, 왼쪽 아래, 오른쪽 위, 오른쪽 아래
    private static int[] dy = {-1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                // 흑칸, 백칸 색분리
                if (board[i][j] == 1) {
                    if ((i + j) % 2 == 0) black.add(new int[]{i, j});
                    else white.add(new int[]{i, j});
                }
            }
        }

        dfs(0, 0, black, true);
        dfs(0, 0, white, false);

        System.out.println(maxBlack + maxWhite);
    }

    private static void dfs(int index, int count, List<int[]> list, boolean isBlack) {
        if (index == list.size()) {
            if(isBlack) maxBlack = Math.max(maxBlack, count);
            else maxWhite = Math.max(maxWhite, count);
            return;
        }

        int x = list.get(index)[0];
        int y = list.get(index)[1];

        if (canPlace(x, y)) {
            visited[x][y] = true; // 비숍 배치
            dfs(index + 1, count + 1, list, isBlack);
            visited[x][y] = false; // 백트래킹 (원상복구)
        }

        // 현재 칸 건너뛰고 다음 칸 시도
        dfs(index + 1, count, list, isBlack);
    }

    private static boolean canPlace(int x, int y) {
        // 4방향 대각선 모두 탐색해본다.
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;

            // 대각선 방향으로 맵끝까지 탐색
            while (true) {
                nx += dx[i];
                ny += dy[i];

                // 맵 밖으로 넘어가면 탐색 중단
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                // 이미 다른 비숍이 배치되어 있다면 불가능
                if(visited[nx][ny]) return false;
            }
        }
        return true;
    }
}
