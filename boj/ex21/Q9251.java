package ex21;

import java.io.*;
import java.util.*;

public class Q9251 {
    static char[] A, B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        int n = A.length;
        int m = B.length;

        dp = new int[n][m];
        // -1로 초기화 Integer배열을 선언하면 기본 null이므로 안해도 된다.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lcs(n - 1, m -1)).append("\n"); // 길이가 긴 뒤에서부터 탐색 시작 (Top-Down)
        System.out.println(sb);
    }

    private static int lcs(int x, int y) {
        // 공집합일 경우 0 반환
        if(x == -1 || y == -1) return 0;

        // 탐색한 적이 있는 경우
        if(dp[x][y] != -1) return dp[x][y];

        // A의 x번째 문자와 B의 y번째 문자가 같은지 검사
        if (A[x] == B[y]) {
            return dp[x][y] = lcs(x - 1, y - 1) + 1;
        } else {
            return dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
        }
    }
}
