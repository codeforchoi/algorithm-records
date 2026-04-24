package etc2;

import java.io.*;
import java.util.*;

public class Q11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] matrix = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];
        for (int len = 2; len <= N; len++) { // 구간 길이
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1; // 끝 인덱스
                dp[i][j] = Integer.MAX_VALUE;

                // k는 구간을 나누는 기점
                // ex) k = 0 (A)(BCD), k = 1 (AB) (CD), k = 2 (ABC) (D) 이런식
                for (int k = i; k < j; k++) {
                    // ex) (AB) * (CD), AB 최소값, CD 최소값, 이 결과 행렬을 곱한 값이 해당 구간의 연산 횟수이다.
                    int cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    
                    // 최솟값 비교 후 갱신
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println(dp[0][N - 1]); // 0번 인덱스에서 (N - 1)번 인덱스까지
    }
}
