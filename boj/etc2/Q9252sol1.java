package etc2;

import java.io.*;
import java.util.*;

// LCS(Longest Common Subsequence, 최장 공통 부분 수열) + 역추적 (반복문 사용, 더 성능 좋음)
// 재귀는 Top-Down
// 반복문은 Bottom-Up 해야함.
// dp의 낮은 쪽부터 모두 계산되어야 뒤쪽을 계산할 수 있기 때문에.
public class Q9252sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int n = A.length;
        int m = B.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 같은 문자이면 대각선값을 저장
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 다른 문자이면 큰 값으로 저장
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[n][m]).append("\n");

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
}
