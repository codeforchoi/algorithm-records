package ex36;

import java.io.*;
import java.util.*;

public class Q15681 {
    static List<Integer>[] edges;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N + 1];
        count = new int[N + 1];
        Arrays.fill(count, 1);
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[u].add(v);
            edges[v].add(u);
        }

        // 모든 정점에 대해서 서브트리에 속한 정점 수를 계산해놓는다.
        dfs(R, -1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            sb.append(count[Integer.parseInt(br.readLine())]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dfs(int r, int prevNode) {
        for (int x : edges[r]) {
            if(x == prevNode) continue;
            dfs(x, r);
            count[r] += count[x];
        }
    }
}
