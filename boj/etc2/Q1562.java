package etc2;

import java.io.*;

public class Q1562 {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // [i][j][k] i번째 자리에 j 숫자, k는 0~9까지 사용한 상태 저장 (비트마스크)
        int[][][] dp = new int[N + 1][10][1 << 10];

        // 초기값 설정 (0은 첫번째 자리에 불가)
        for (int i = 1; i <= 9; i++) {
            dp[1][i][1 << i] = 1;
        }

        for (int i = 2; i <= N; i++) { // i번째 자리, 2번째 자리부터 시작
            for (int j = 0; j <= 9; j++) { // 0 ~ 9까지 넣어본다.
                for (int k = 0; k < (1 << 10); k++) { // 각 숫자가 모두 나왔는지 확인
                    int nextVisited = k | (1 << j); // 비트마스크로 방문 처리

                    // j 숫자가 0이면 올라가는 경우만 존재
                    if (j == 0) { //
                        dp[i][j][nextVisited] += dp[i - 1][j + 1][k] % MOD;
                    } else if (j == 9) { // j 숫자가 9이면 내려가는 경우만 존재
                        dp[i][j][nextVisited] += dp[i - 1][j - 1][k] % MOD;
                    } else { // 둘다 아닌 경우 내려가거나 올라갈 수 있는 경우 존재 가능
                        dp[i][j][nextVisited] += dp[i - 1][j - 1][k] % MOD + dp[i - 1][j + 1][k] % MOD;
                    }

                    dp[i][j][nextVisited] %= MOD;
                }
            }
        }

        long sum = 0;
        // 0 ~ 9 숫자까지 모두 잘 도착한 경우의 수를 모두 더한다.
        for (int i = 0; i <= 9; i++) {
            sum += dp[N][i][(1 << 10) - 1];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}
