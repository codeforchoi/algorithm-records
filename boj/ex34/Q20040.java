package ex34;

import java.io.*;
import java.util.*;

public class Q20040 {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n]; // 0 ~ n-1 까지 고유번호 부여
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int num = 0;
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) == find(b)) {
                num = i;
                break;
            } else {
                union(a, b);
            }
        }
        System.out.println(num);
    }

    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) parent[u] = v;
    }
}
