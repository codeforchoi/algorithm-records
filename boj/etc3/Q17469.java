package etc3;

import java.io.*;
import java.util.*;

//
public class Q17469 {
    private static int[] parent, nodeParent, colors;
    private static Set<Integer>[] colorSets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        nodeParent = new int[N + 1];
        colors = new int[N + 1];
        parent = new int[N + 1];
        colorSets = new HashSet[N + 1];

        for (int i = 2; i <= N; i++) {
            nodeParent[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            colors[i] = Integer.parseInt(br.readLine());
            parent[i] = i;
            colorSets[i] = new HashSet<>();
            colorSets[i].add(colors[i]);
        }

        int[][] queries = new int[N + Q][2];
        for (int i = 0; i < N + Q - 1; i++) {
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = N + Q - 2; i >= 0; i--) {
            int type = queries[i][0];
            int v = queries[i][1];

            if (type == 1) {
                union(v, nodeParent[v]);
            } else {
                stack.push(colorSets[find(v)].size());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }
        System.out.print(sb);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        int parentA = find(u);
        int parentB = find(v);

        if (parentA != parentB) {
            if (colorSets[parentA].size() > colorSets[parentB].size()) {
                int temp = parentA;
                parentA = parentB;
                parentB = temp;
            }
            colorSets[parentB].addAll(colorSets[parentA]);
            colorSets[parentA].clear(); // 메모리 절약
            parent[parentA] = parentB;
        }
    }
}
