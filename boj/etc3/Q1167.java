package etc3;

import java.io.*;
import java.util.*;

public class Q1167 {
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
        int V = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) break;
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Node(v, w));
            }
        }

        // 1번 노드에서 가장 먼 노드 찾기
        visited = new boolean[V + 1];
        dfs(1, 0);

        // 찾은 그 끝점에서 다시 가장 먼 노드까지의 거리 구하기
        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    private static void dfs(int curr, int dist) {
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = curr;
        }
        visited[curr] = true;

        for (Node next : adj[curr]) {
            if (!visited[next.target]) {
                dfs(next.target, dist + next.weight);
            }
        }
    }

}
