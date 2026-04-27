package etc3;

import java.util.*;
import java.io.*;

//
public class Q1753 {
    private static final int INF = Integer.MAX_VALUE;
    private static List<Node>[] adj;
    private static int[] dist;

    private static class Node implements Comparable<Node> {
        int target, weight;
        Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.weight > dist[curr.target]) continue;

            for (Node next : adj[curr.target]) {
                if (dist[next.target] > dist[curr.target] + next.weight) {
                    dist[next.target] = dist[curr.target] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }
    }
}
