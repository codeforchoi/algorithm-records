package etc3;

import java.io.*;
import java.util.*;

//
public class Q2162 {
    private static int[] parent;
    private static int[] size;

    private static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Line {
        Point p1, p2;
        Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Long.parseLong(st.nextToken());
            long y1 = Long.parseLong(st.nextToken());
            long x2 = Long.parseLong(st.nextToken());
            long y2 = Long.parseLong(st.nextToken());

            lines[i] = new Line(new Point(x1, y1), new Point(x2, y2));
        }

        parent = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isCross(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        int groupCnt = 0;
        int maxSize = 0;

        for (int i = 0; i < N; i++) {
            if (find(i) == i) {
                groupCnt++;
                maxSize = Math.max(maxSize, size[i]);
            }
        }

        System.out.println(groupCnt);
        System.out.println(maxSize);
    }

    private static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);

        if (u != v) {
            parent[v] = u;
            size[u] += size[v];
        }
    }

    private static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    private static boolean isCross(Line l1, Line l2) {
        Point A = l1.p1, B = l1.p2;
        Point C = l2.p1, D = l2.p2;

        long ab1 = ccw(A, B, C);
        long ab2 = ccw(A, B, D);
        long cd1 = ccw(C, D, A);
        long cd2 = ccw(C, D, B);

        if (ab1 == 0 && ab2 == 0) {
            return Math.max(Math.min(A.x, B.x), Math.min(C.x, D.x)) <= Math.min(Math.max(A.x, B.x), Math.max(C.x, D.x))
                    &&
                    Math.max(Math.min(A.y, B.y), Math.min(C.y, D.y)) <= Math.min(Math.max(A.y, B.y), Math.max(C.y, D.y));
        }

        return ab1 * ab2 <= 0 && cd1 * cd2 <= 0;
    }

}
