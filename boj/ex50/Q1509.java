package ex50;

import java.io.*;

// dp
// 팰린드롬
public class Q1509 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;
        boolean[][] isPalindrome = new boolean[n][n]; // i ~ j까지 구간이 팰린드롬인지 확인
        int[] dp = new int[n]; // 0부터 i 인덱스까지 최소 팰린드롬 개수

        // 길이가 1인 팰린드롬
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        
        // 길이가 2인 팰린드롬
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                isPalindrome[i][i + 1] = true;
            }
        }
        
        // 길이가 3이상인 팰린드롬
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (arr[i] == arr[j] && isPalindrome[i + 1][j - 1]) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE; // 최대값으로 초기화

            for (int j = 0; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    if(j == 0) dp[i] = 1; // 팰린드롬인 상태에서 0 ~ i 번까지면 무조건 1개 경우
                    else dp[i] = Math.min(dp[i], dp[j - 1] + 1); // 0 ~ j - 1까지의 팰린드롬 최소 개수 + 팰린드롬 1개 추가와 비교
                }
            }
        }
        System.out.println(dp[n - 1]);
    }
}
