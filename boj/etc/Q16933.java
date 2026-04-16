package etc;

import java.io.*;
import java.util.*;

public class Q16933 {
    private static int n, m, k;
    private static int[][] map;
    private static boolean[][][][] visited;

    private static final int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static final int[] dy = {0, 0, -1, 1};

    private static class Node {
        int x, y, dist, wall, day; // 낮: 0, 밤: 1

        public Node(int x, int y, int dist, int wall, int day) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;
            this.day = day;
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
        visited = new boolean[n][m][k + 1][2]; // 낮에 방문, 밤에 방문 구분
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    /**
     * 조건: 낮과 밤 모두 이동가능, 낮에만 벽 부술 수 있음. (낮에도 머무를 수 있음)
     *
     * 이동하는 경우)
     *      벽인 경우) 낮이면서 벽 부수는 횟수가 남아 있어야함.
     *      벽이 아닌 경우) 이동
     * 이동하지 않는 경우) 머물르기
     */
    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1, 0, 0));
        visited[0][0][0][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();
            int nextDay = 1 - now.day;

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

                // 벽이 아닌 경우
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][now.wall][nextDay]) {
                        visited[nx][ny][now.wall][nextDay] = true;
                        q.offer(new Node(nx, ny, now.dist + 1, now.wall, nextDay));
                    }
                } else { // 벽인 경우
                    // 낮이면서 벽을 부술 수 있는 횟수가 남은 경우
                    if (now.day == 0 && now.wall < k) {
                        if (!visited[nx][ny][now.wall + 1][nextDay]){
                            visited[nx][ny][now.wall + 1][nextDay] = true;
                            q.offer(new Node(nx, ny, now.dist + 1, now.wall + 1, nextDay));
                        }
                    }
                }
            }

            // 이동하지 않는 경우
            if (!visited[now.x][now.y][now.wall][nextDay]) {
                visited[now.x][now.y][now.wall][nextDay] = true;
                q.offer(new Node(now.x, now.y, now.dist + 1, now.wall, nextDay));
            }
        }
        return -1;
    }
}
