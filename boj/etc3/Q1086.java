package etc3;

import java.io.*;

//
public class Q1086 {
    private static int N, K;
    private static String[] nums;
    private static int[] val, len;
    private static int[][] pow10; // pow10[K][자릿수] 나머지를 미리 저장
    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new String[N];

        for (int i = 0; i < N; i++) nums[i] = br.readLine();

        K = Integer.parseInt(br.readLine());

        val = new int[N];
        len = new int[N];
        for (int i = 0; i < N; i++) {
            len[i] = nums[i].length();
            int r = 0;
            for (int j = 0; j < len[i]; j++) {
                r = (r * 10 + (nums[i].charAt(j) - '0')) % K;
            }
            val[i] = r;
        }

        int[] p10 = new int[751]; // 최대 자릿수 50 * 15
        p10[0] = 1 % K;
        for (int i = 1; i <= 750; i++) p10[i] = (p10[i - 1] * 10) % K;

        dp = new long[1 << N][K];
        dp[0][0] = 1;

        for (int mask = 0; mask < (1 << N); mask++) {
            // 현재까지의 총 자릿수 계산
            int currentLen = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) currentLen += len[i];
            }

            for (int rem = 0; rem < K; rem++) {
                if (dp[mask][rem] == 0) continue;

                for (int next = 0; next < N; next++) {
                    if ((mask & (1 << next)) == 0) {
                        int nextRem = (rem * p10[len[next]] + val[next]) % K;
                        dp[mask | (1 << next)][nextRem] += dp[mask][rem];
                    }
                }
            }
        }

        long p = dp[(1 << N) - 1][0];
        long q = 1;
        for (int i = 2; i <= N; i++) q *= i;

        long gcd = getGCD(p, q);
        System.out.println((p / gcd) + "/" + (q / gcd));
    }

    private static long getGCD(long a, long b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}
