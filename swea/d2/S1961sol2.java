package d2;

import java.io.*;
import java.util.*;

public class S1961sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#").append(t).append("\n");

            for (int i = 0; i < N; i++) {
                // 90도 회전
                for (int j = N - 1; j >= 0; j--) {
                    sb.append(arr[j][i]);
                }
                sb.append(" ");

                // 180도 회전
                for (int j = N - 1; j >= 0; j--) {
                    sb.append(arr[N - 1 - i][j]);
                }
                sb.append(" ");

                // 270도 회전
                for (int j = 0; j < N; j++) {
                    sb.append(arr[j][N - 1 - i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
