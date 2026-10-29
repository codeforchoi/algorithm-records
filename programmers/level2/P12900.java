package level2;

public class P12900 {
	public int solution(int n) {
		final int P = 1_000_000_007;
        int[] dp = new int[n + 1];
    
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % P;
        }
        
        return dp[n];
    }
}
