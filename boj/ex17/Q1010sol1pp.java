package ex17;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1010sol1pp {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combination(m, n)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int combination(int n, int r) {
        // 이미 계산된 경우 바로 값 반환
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        // nCn = 1, nC0 = 1 성질 이용
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        
        // nCr = n-1Cr-1 + n-1Cr 성질 이용
        return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}