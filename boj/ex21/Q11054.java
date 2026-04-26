package ex21;

import java.io.*;
import java.util.*;

// LIS, LDS
public class Q11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = val, i번째 값을 기준으로 증가하는, 감소하는 val = 최대 길이
        int[] l_dp = new int[N];
        int[] r_dp = new int[N];
        Arrays.fill(l_dp, 1);
        Arrays.fill(r_dp, 1);

        // i까지 LIS 최대값 찾기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
                }
            }
        }

        // i까지 LDS 최대값 찾기
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            // i가 두번 세졌으므로 1을 빼준다.
            max = Math.max(max, l_dp[i] + r_dp[i] - 1);
        }
        System.out.println(max);
    }
}
