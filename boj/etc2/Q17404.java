package etc2;

import java.io.*;
import java.util.*;

// DP
public class Q17404 {
    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cost = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = INF;

        // 첫 집 색을 (0, 1, 2)로 고정
        for (int first = 0; first < 3; first++) {
            int[][] dp = new int[N][3]; // [집, 색]

            // 초기값 세팅
            for (int i = 0; i < 3; i++) {
                if(i == first) dp[0][i] = cost[0][i];
                else dp[0][i] = INF;
            }

            // 0번부터 채워나갔으므로 오른쪽 집은 안채워져 있음.
            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
            }

            for (int last = 0; last < 3; last++) {
                if(last == first) continue;
                minCost = Math.min(minCost, dp[N - 1][last]);
            }
        }
        System.out.println(minCost);
    }
}
