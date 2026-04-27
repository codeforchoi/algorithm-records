package etc3;

import java.io.*;
import java.util.*;

//
public class Q17386 {
    private static class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 선분 (x1, y1, x2, y2)
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point A = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point B = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        // 두 번째 선분 (x3, y3, x4, y4)
        st = new StringTokenizer(br.readLine());
        Point C = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        Point D = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));

        // 선분 교차 판별 (CCW 결과의 곱이 음수면 서로 교차함)
        if (ccw(A, B, C) * ccw(A, B, D) < 0 && ccw(C, D, A) * ccw(C, D, B) < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // CCW 함수
    private static int ccw(Point p1, Point p2, Point p3) {
        long result = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        if (result > 0) return 1;    // 반시계
        if (result < 0) return -1;   // 시계
        return 0;                    // 일직선
    }
}
