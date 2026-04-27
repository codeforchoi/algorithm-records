package etc3;

import java.io.*;
import java.util.*;

//
public class Q1311 {
    private static int N;
    private static int[][] cost, dp;
    private static final int INF = 10_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[사람 인덱스][일을 마친 상태 비트마스크]
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(solve(0, 0));
    }

    private static int solve(int now, int bit) {
        // 모든 사람에게 일을 다 배정한 경우
        if (now == N) return 0;

        // 이미 계산된 값이 있는 경우 (Memoization)
        if (dp[now][bit] != -1) return dp[now][bit];

        int res = INF;
        for (int i = 0; i < N; i++) {
            // i번째 일이 아직 배정되지 않았다면
            if ((bit & (1 << i)) == 0) {
                res = Math.min(res, solve(now + 1, bit | (1 << i)) + cost[now][i]);
            }
        }
        return dp[now][bit] = res;
    }

}
