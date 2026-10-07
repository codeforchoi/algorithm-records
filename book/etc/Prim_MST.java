package etc;

import java.io.*;
import java.util.*;

public class Prim_MST {

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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, cost));
            graph[b].add(new Edge(a, cost));
        }

        boolean[] visited = new boolean[V + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        pq.offer(new Edge(1, 0));

        long answer = 0;
        int count = 0;

        while (!pq.isEmpty()) {

            Edge cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;
            answer += cur.cost;
            count++;

            if (count == V) {
                break;
            }

            for (Edge next : graph[cur.to]) {
                if (!visited[next.to]) {
                    pq.offer(next);
                }
            }
        }

        if (count == V) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }
    }
}
