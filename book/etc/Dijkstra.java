package etc;

import java.io.*;
import java.util.*;

public class Dijkstra {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[from].add(new Edge(to, cost));

            // 무방향 그래프라면 아래도 추가
            // graph[to].add(new Edge(from, cost));
        }

        int start = 1;

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();

            int now = cur.to;
            int currentCost = cur.cost;

            if (dist[now] < currentCost) {
                continue;
            }

            for (Edge next : graph[now]) {

                int nextCost = currentCost + next.cost;

                if (nextCost < dist[next.to]) {
                    dist[next.to] = nextCost;
                    pq.offer(new Edge(next.to, nextCost));
                }
            }
        }

        for (int i = 1; i <= V; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
