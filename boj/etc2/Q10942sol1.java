package etc2;

import java.io.*;
import java.util.*;

public class Q10942sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N][N];

        // 길이가 1인 경우
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // 길이가 2인 경우
        for (int i = 0; i < N - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                dp[i][i + 1]  = true;
            }
        }
        
        // 길이가 3이상인 경우
        for (int len = 3; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;

                // 양 끝 값이 같고, 그 내부가 팰린드롬이면 팰린드롬이다. (dp[i + 1][j - 1]는 내부에 이미 계산된 값)
                if (numbers[i] == numbers[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
