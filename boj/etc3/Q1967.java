package etc3;

import java.io.*;
import java.util.*;

//
public class Q1967 {
    private static List<Node>[] adj;
    private static boolean[] visited;
    private static int maxDist = 0;
    private static int farthestNode = 0;

    private static class Node {
        int target, weight;
        Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(0);
            return;
        }

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
            adj[v].add(new Node(u, w));
        }

        // 임의의 노드에서 가장 먼 노드 찾기
        visited = new boolean[n + 1];
        dfs(1, 0);

        // 찾은 노드에서 다시 가장 먼 노드까지의 거리 구하기
        visited = new boolean[n + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    private static void dfs(int curr, int dist) {
        visited[curr] = true;

        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = curr;
        }

        for (Node next : adj[curr]) {
            if (!visited[next.target]) {
                dfs(next.target, dist + next.weight);
            }
        }
    }
}
