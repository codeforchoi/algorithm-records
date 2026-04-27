package etc3;

import java.io.*;
import java.util.*;

//
public class Q1765 {
    private static int[] parent;
    private static List<Integer>[] enemies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        enemies = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            enemies[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if (type.equals("F")) {
                union(p, q);
            } else {
                enemies[p].add(q);
                enemies[q].add(p);
            }
        }

        for (int i = 1; i <= n; i++) {
            if (enemies[i].size() > 1) {
                int firstEnemy = enemies[i].get(0);
                for (int j = 1; j < enemies[i].size(); j++) {
                    union(firstEnemy, enemies[i].get(j));
                }
            }
        }

        int teamCount = 0;
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) teamCount++;
        }
        System.out.println(teamCount);
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
