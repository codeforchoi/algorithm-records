package etc3;

import java.io.*;
import java.util.*;

//
public class Q11438 {
    private static int N, M, K;
    private static List<Integer>[] adj;
    private static int[][] parent;
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        K = 0;
        for (int i = 1; i <= N; i *= 2) K++;

        parent = new int[K][N + 1];
        depth = new int[N + 1];

        bfs(1);

        for (int k = 1; k < K; k++) {
            for (int v = 1; v <= N; v++) {
                parent[k][v] = parent[k - 1][parent[k - 1][v]];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getLCA(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        depth[start] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                if (depth[next] == 0) {
                    depth[next] = depth[curr] + 1;
                    parent[0][next] = curr;
                    q.add(next);
                }
            }
        }
    }

    private static int getLCA(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a; a = b; b = temp;
        }

        for (int i = K - 1; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[i][b];
            }
        }

        if (a == b) return a;

        for (int i = K - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

}
