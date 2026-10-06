package etc;

import java.io.*;
import java.util.*;

public class Kruskal_MST {

    static int[] parent;

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static boolean union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u == v) {
            return false;
        }

        parent[v] = u;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        StringTokenizer st =
                new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, cost);
        }

        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        long answer = 0;
        int count = 0;

        for (Edge edge : edges) {

            if (union(edge.from, edge.to)) {
                answer += edge.cost;
                count++;

                if (count == V - 1) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
