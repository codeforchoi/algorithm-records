package level2;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1844 {
    private static final int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static final int[] dy = {0, 0, -1, 1};

    private static class Node {
        int x, y, dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 1));
        visited[0][0] = true;

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

                // 벽이거나 방문한 경우
                if(maps[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, now.dist + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr1 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int[][] arr2 = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }
}
