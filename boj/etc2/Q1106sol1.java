package etc2;

import java.io.*;
import java.util.*;

public class Q1106sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 100]; // C - 1 상태에서 + 100이 나올 수 있는 최대명수이다.
        Arrays.fill(dp, Integer.MAX_VALUE); // 모두 가장 큰 값으로 계산된 적이 없는 것으로 초기화
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());

            for (int j = people; j < C + 100; j++) {
                // 해당 명수에서 people를 홍보하기 전 비용이 계산되어 있다면 최소를 비교한다.
                if (dp[j - people] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], cost + dp[j - people]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = C; i < C + 100; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        System.out.println(minCost);
    }
}
