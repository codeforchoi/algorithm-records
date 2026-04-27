package etc3;

import java.io.*;
import java.util.*;

//
public class Q1414 {
    private static int[] parent;

    private static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Edge> edges = new ArrayList<>();
        long totalLength = 0;

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                int len = charToInt(line[j]);
                totalLength += len;
                if (i != j && len > 0) {
                    edges.add(new Edge(i, j, len));
                }
            }
        }

        Collections.sort(edges);

        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;

        long mstLength = 0;
        int edgeCount = 0;

        for (Edge edge : edges) {
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                mstLength += edge.w;
                edgeCount++;
            }
        }

        if (edgeCount == N - 1) {
            System.out.println(totalLength - mstLength);
        } else {
            System.out.println(-1);
        }
    }

    private static int charToInt(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a' + 1;
        if (c >= 'A' && c <= 'Z') return c - 'A' + 27;
        return 0;
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) parent[v] = u;
    }
}
