package d;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(1)
 * 공간 복잡도 : O(1)
 * DP
 */
// Memory: 26,112 kb, Time: 83 ms, Code Length: 1,164
public class S1952 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			int[] fee = new int[4];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 4; i++) {
				fee[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] plan = new int[13];
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[13];
			for(int i = 1; i <= 12; i++) {
				// 전달 + 이번달에 모두 1일 이용권 or 1달 이용권
				dp[i] = dp[i - 1] + Math.min(plan[i] * fee[0], fee[1]);
				
				// 3달마다 3개월이 더 유리한지 비교
				if(i >= 3) {					
					dp[i] = Math.min(dp[i], dp[i - 3] + fee[2]);
				}				
			}
			
			// 1년치가 더 유리한 비교
			int minCost = Math.min(dp[12], fee[3]);
					
			sb.append("#").append(tc).append(" ").append(minCost).append("\n");
		}
		System.out.println(sb);
	}
}
