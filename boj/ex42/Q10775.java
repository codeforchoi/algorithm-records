package ex42;

import java.io.*;

public class Q10775 {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) {
            parent[i] = i;
        }

        int maxPlane = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());

            int root = find(g);
            // 더 이상 도킹 불가시 종료
            if(root == 0) break;

            // 가장 큰 번호에 도킹하고 하나 작은 게이트를 가리킴.
            union(root, root - 1);
            maxPlane++;
        }
        System.out.println(maxPlane);
    }

    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        parent[u] = v;
    }
}
