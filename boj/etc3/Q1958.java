package etc3;

import java.io.*;

//
public class Q1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        // 인덱스 편의를 위해 길이를 +1 해서 선언 (0번 인덱스는 공백 문자)
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    // 세 문자열의 문자가 모두 일치하는 경우
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                    }
                    // 하나라도 다른 경우, 이전 값 중 최댓값 선택
                    else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        // 세 문자열 전체를 비교했을 때의 마지막 값 출력
        System.out.println(dp[n1][n2][n3]);
    }
}
