package etc2;

import java.io.*;
import java.util.*;

public class Q2887 {
    static int[] parent;

    static class Planet {
        int id, x, y, z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge {
        int u, v, weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int minCost = 0;

        StringTokenizer st;
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            planets[i] = new Planet(
                    i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        List<Edge> edges = new ArrayList<>();
/*
        // 각 행성 간의 터널 비용 계산
        // 이렇게 모든 행성들 간에 비용을 계산해 edges에 추가하면 너무 많은 Edge들이 만들어져 메모리 초과 상태가 날 수 있다.
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int cost = Math.min(Math.abs(planets[i][0] - planets[j][0]), Math.abs(planets[i][1] - planets[j][1]));
                cost = Math.min(cost, Math.abs(planets[i][2] - planets[j][2]));
                edges.add(new Edge(i, j, cost));
            }
        }
*/
        // 각 행성들은 무조건 한 행성과는 가장 가깝다.
        // x, y, z 기준으로 가장 가까운 경우를 N-1개씩 후보를 뽑으면 된다. (메모리 초과 방지)
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.x, p2.x));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].x - planets[i + 1].x)));
        }
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.y, p2.y));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].y - planets[i + 1].y)));
        }
        Arrays.sort(planets, (p1, p2) -> Integer.compare(p1.z, p2.z));
        for (int i = 0; i < N - 1; i++) {
            edges.add(new Edge(planets[i].id, planets[i + 1].id, Math.abs(planets[i].z - planets[i + 1].z)));
        }

        // 터널들끼리 비용 오름차순으로 정렬
        Collections.sort(edges, (o1, o2) -> Integer.compare(o1.weight, o2.weight));

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (Edge e : edges) {
            if(count == N - 1) break; // N - 1개 터널
            // 순환하지 않는 경우 터널을 만들고 대표 노드 갱신한다.
            if (find(e.u) != find(e.v)) {
                union(e.u, e.v);
                minCost += e.weight;
                count++;
            }
            // 순환하면 터널을 만들 필요가 없다.
        }

        System.out.println(minCost);
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
        if (u != v) parent[u] = v;
    }
}
