package ex39;

import java.io.*;
import java.util.*;

// CCW (Counter ClockWise, 시계 반대 방향) 알고리즘 사용
// CCW 벡터 외적 : (x2−x1)*(y3−y1)−(y2−y1)*(x3−x1)
// CCW: 양수 : 반시계, 0: 일직선, 음수: 시계
public class Q17387 {
    private static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        System.out.println(isIntersect(A, B, C, D) ? 1 : 0);
    }

    private static boolean isIntersect(Point a, Point b, Point c, Point d) {
        long ab_c = ccw(a, b, c);
        long ab_d = ccw(a, b, d);
        long cd_a = ccw(c, d, a);
        long cd_b = ccw(c, d, b);

        // 네 점이 모두 한 직선 위에 있는 경우 (ACBD, CADB, ABCD(BC 같은점), CDAB(DA 같은점)
        if (ab_c == 0 && ab_d == 0 && cd_a == 0 && cd_b == 0) {
            return Math.min(a.x, b.x) <= Math.max(c.x, d.x) &&
                    Math.min(c.x, d.x) <= Math.max(a.x, b.x) &&
                    Math.min(a.y, b.y) <= Math.max(c.y, d.y) &&
                    Math.min(c.y, d.y) <= Math.max(a.y, b.y);
        }

        // 두 선분이 서로 일반적인 교차
        // 위에서 네 값이 모두 0인 경우는 처리됨.
        // 한 점이 다른 선분 위에 있는 경우 포함.
        // 세점이 일직선 상에 있고 그 중 두점이 같은 경우도 포함.
        return (ab_c * ab_d <= 0) && (cd_a * cd_b <= 0);
    }

    private static long ccw(Point a, Point b, Point c) {
        long val = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        return (val == 0) ? 0 : (val > 0) ? 1 : -1;
    }
}
