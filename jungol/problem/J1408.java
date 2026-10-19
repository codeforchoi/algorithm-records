package problem;

import java.io.*;
import java.util.*;

public class J1408 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        int[][] wire = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        // A 전봇대 위치 기준 오름차순 정렬
        Arrays.sort(wire, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[] dp = new int[N];
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {          
                if (wire[j][1] < wire[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(N - maxLength);
    }
}