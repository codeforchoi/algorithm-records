package etc;

import java.io.*;
import java.util.*;

//MST 크루스칼 알고리즘 풀이
public class Q1197 {
    static int[] parent;

    static class Edge {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int sum = 0;

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges, (o1, o2) -> Integer.compare(o1.weight, o2.weight));

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (Edge e : edges) {
            if(count == V - 1) break; // 최소 스패닝 트리는 (정점개수 - 1)개의 간선을 가짐.
            // 순환하지 않는 경우 대표노드 갱신
            if (find(e.to) != find(e.from)) {
                union(e.to, e.from);
                sum += e.weight;
                count++;
            }
        }
        System.out.println(sum);
    }

    // 대표 노드 조회
    static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
    
    // 대표 노드 갱신 (parent[u]를 변경)
    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) parent[u] = v;
    }
}
