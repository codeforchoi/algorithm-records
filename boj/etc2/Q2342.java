package etc2;

import java.io.*;
import java.util.*;

// DP
public class Q2342 {
    private static int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        while (true) {
            int x = Integer.parseInt(st.nextToken());
            if(x == 0) break;
            list.add(x);
        }

        int n = list.size();
        int[][][] dp = new int[n + 1][5][5]; // i번째 명령, 왼발 현재 위치, 오른발 현재 위치

        // 우선 최대값으로 채운다.
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        // 초기값 세팅 (0개의 명령 실행시 왼발 오른발 위치)
        dp[0][0][0] = 0;

        for (int i = 0; i < n; i++) {
            int next = list.get(i);

            // 왼발, 오른발이 있을 수 있는 위치만큼 돌려본다.
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if(dp[i][j][k] == INF) continue; // 계산된적 없으면 존재하지 않는 상태이므로 계산하지 않는다.

                    // 왼발 이동 시 
                    dp[i + 1][next][k] = Math.min(dp[i + 1][next][k], dp[i][j][k] + move(j, next));

                    // 오른발 이동 시
                    dp[i + 1][j][next] = Math.min(dp[i + 1][j][next], dp[i][j][k] + move(k, next));
                }
            }
        }

        int minCost = INF;
        // n개의 명령을 실행 후 가장 최소 비용이 든 경우를 구한다.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                minCost = Math.min(minCost, dp[n][i][j]);
            }
        }
        System.out.println(minCost);
    }

    private static int move(int from, int to) {
        if(from == to) return 1;
        if(from == 0) return 2;
        if(Math.abs(from - to) == 2) return 4;
        return 3; // 1 -> 4 경우도 커버 가능
    }
}
