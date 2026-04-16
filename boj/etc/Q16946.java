package etc;

import java.io.*;
import java.util.*;

public class Q16946 {

    private static int n, m;
    private static int[][] map;
    private static int[][] group;
    private static boolean[][] visited;
    private static StringBuilder sb;

    private static int groupId = 1;
    private static List<Integer> groupSize = new ArrayList<>();

    private static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    private static int[] dy = {0, 0, -1, 1};

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        group = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        grouping();
        createRessult();
        System.out.println(sb);
    }

    private static void grouping() {
        groupSize.add(0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    groupSize.add(bfs(i, j));
                    groupId++;
                }
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y)); // 시작점
        visited[x][y] = true;
        group[x][y] = groupId;

        int count = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 맵 밖으로 벗어나는 경우
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                // 이미 방문했거나 벽인 경우
                if(visited[nx][ny] || map[nx][ny] == 1) continue;

                visited[nx][ny] = true;
                group[nx][ny] = groupId;
                q.add(new Node(nx, ny));
                count++;
            }
        }
        return count;
    }

    private static void createRessult() {
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    int sum = 1;
                    boolean[] used = new boolean[groupSize.size() + 1];

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 맵 밖으로 벗어나는 경우
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                        int gid = group[nx][ny];
                        // 그룹이 없는 경우 (벽인 경우)
                        if(gid == 0) continue;

                        if (!used[gid]) {
                            sum += groupSize.get(gid);
                            used[gid] = true;
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
    }
}
