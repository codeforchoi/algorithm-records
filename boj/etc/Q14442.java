package etc;

import java.io.*;
import java.util.*;

public class Q14442 {
    private static int n, m, k;
    private static int[][] map;
    private static boolean[][][] visited;

    private static final int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static final int[] dy = {0, 0, -1, 1};

    private static class Node {
        int x, y, dist, wall;

        public Node(int x, int y, int dist, int wall) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 맵 구현
        map = new int[n][m];
        visited = new boolean[n][m][k + 1]; // k번까지 부술 수 있으므로 k+1
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            // 도착시 종료
            if (now.x == n - 1 && now.y == m - 1) {
                return now.dist;
            }

            // 모든 방향으로 이동시켜봄
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 맵 밖으로 나가는 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 벽이거나 아직 부술 수 있는 횟수가 남은 경우
                if (map[nx][ny] == 1 && now.wall < k) {
                    if (!visited[nx][ny][now.wall + 1]) {
                        visited[nx][ny][now.wall + 1] = true;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall + 1));
                    }
                }

                // 벽이 아닌 경우
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][now.wall]) {
                        visited[nx][ny][now.wall] = true;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall));
                    }
                }

                //벽인데 k번 부순 경우는 아무 조치 없이 지난다.
            }
        }
        return -1;
    }
}
