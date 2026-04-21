package etc2;

import java.io.*;
import java.util.*;

// 최소 스패닝 트리 (MST)를 구성해보고 거기서 가장 비싼 도로(마지막 도로)를 끊으면 마을이 두개로 나뉜다.
public class Q1647 {
    static int[] parent;

    static class Edge {
        int u, v, cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        
        // 길 비용으로 오름차순 정렬
        Arrays.sort(edges, (e1, e2) -> Integer.compare(e1.cost, e2.cost));

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int lastEdgeCost = 0;
        int count = 0;
        for (Edge e : edges) {
            if(count == N - 1) break;

            // 순환하지 않으면 대표 노드 갱신
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                totalCost += e.cost;
                lastEdgeCost = e.cost;
                count++;
            }
        }
        System.out.println(totalCost - lastEdgeCost);
    }

    // 대표 노드 조회
    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    // 대표 노드 갱신 (parent[u]를 변경)
    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) parent[u] = v;
    }
}
