package etc2;

import java.io.*;
import java.util.*;

// 다각형 넓이 공식
// S = 1/2 * |(x1y1 + x2y3 + ... xny1) - (y1x2 + y2x3 + ... + ynx1)|
public class Q2166 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N + 1][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        // 계산을 위해 처음 꼭지점 좌표를 한번 더 넣어준다.
        points[N][0] = points[0][0];
        points[N][1] = points[0][1];

        long sumA = 0;
        long sumB = 0;
        for (int i = 0; i < N; i++) {
            sumA += (long) points[i][0] * points[i + 1][1];
            sumB += (long) points[i + 1][0] * points[i][1];
        }
        double area = Math.abs((sumA - sumB) / 2.0);
        System.out.printf("%.1f", area);
    }
}
