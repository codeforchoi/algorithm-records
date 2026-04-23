package ex32;

import java.io.*;
import java.util.*;

// LCS(Longest Common Subsequence, 최장 공통 부분 수열) + 역추적 (재귀 사용)
public class Q9252 {
    static char[] A, B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        int n = A.length;
        int m = B.length;

        dp = new int[n + 1][m + 1];
        // -1로 초기화 Integer배열을 선언하면 기본 null이므로 안해도 된다.
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lcs(n, m)).append("\n"); // 뒤에서부터 탐색 시작 (Top-Down)

        // 역추적 (뒤에서부터 추적하므로 스택에 넣고 이후에 꺼내어 순서를 맞춘다.)
        Deque<Character> stack = new ArrayDeque<>();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            // 같은 문자일 경우
            if (A[i - 1] == B[j - 1]) {
                stack.push(A[i - 1]);
                i--;
                j--;
            } else {
                // 서로 다른 문자면 dp값이 큰 쪽으로 간다.
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    // x, y 는 dp의 인덱스를 위한 것이므로 각각이 A와 B 문자열 길이에 해당
    private static int lcs(int x, int y) {
        // 공집합일 경우 0 반환
        if(x == 0 || y == 0) return 0;

        // 탐색한 적이 있는 경우
        if(dp[x][y] != -1) return dp[x][y];

        // A의 해당 번째 문자와 B의 해당 번째 문자가 같은지 검사
        if (A[x - 1] == B[y - 1]) {
            return dp[x][y] = lcs(x - 1, y - 1) + 1;
        } else {
            return dp[x][y] = Math.max(lcs(x - 1, y), lcs(x, y - 1));
        }
    }
}
