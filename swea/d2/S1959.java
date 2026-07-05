package d2;

import java.io.*;
import java.util.*;

public class S1959 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // A 배열을 항상 긴 배열로 설정한다.
            if (N < M) {
                int[] temp = A;
                A = B;
                B = temp;

                int tmp = N;
                N = M;
                M = tmp;
            }

            int max = Integer.MIN_VALUE;

            for (int i = 0; i <= N - M; i++) {
                int sum = 0;

                for (int j = 0; j < M; j++) {
                    sum += A[i + j] * B[j];
                }
                max = Math.max(max, sum);
            }

            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
