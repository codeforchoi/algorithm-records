package etc3;

import java.io.*;
import java.util.*;

//
public class Q1238 {
    private static int N, M, X;
    private static List<Node>[] adj, revAdj;
    private static final int INF = 100_000_000;

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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        revAdj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            revAdj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));    // 정방향
            revAdj[v].add(new Node(u, w)); // 역방향 (가는 길 계산용)
        }

        int[] distToParty = dijkstra(revAdj, X); // 각 마을 -> X
        int[] distToHome = dijkstra(adj, X);    // X -> 각 마을

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distToParty[i] + distToHome[i]);
        }

        System.out.println(maxTime);
    }

    private static int[] dijkstra(List<Node>[] graph, int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.weight > dist[curr.target]) continue;

            for (Node next : graph[curr.target]) {
                if (dist[next.target] > dist[curr.target] + next.weight) {
                    dist[next.target] = dist[curr.target] + next.weight;
                    pq.add(new Node(next.target, dist[next.target]));
                }
            }
        }
        return dist;
    }

}
