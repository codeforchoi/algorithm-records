package d3;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N * L)
 * 공간 복잡도 : O(L)
 */
// Memory: 28,288 kb, Time: 104 ms, Code Length: 1,022
public class S5215 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			
			int[] dp = new int[L + 1];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				
				// 역순으로 계산
				for(int j = L; j >= calorie; j--) {
					// 현재 재료를 넣지 않았을 경우와 넣었을 경우 큰 점수로 비교 후 최신화
					dp[j] = Math.max(dp[j], dp[j - calorie] + score);
				}				
			}	
			
			sb.append("#").append(tc).append(" ").append(dp[L]).append("\n");
		}
		
		System.out.println(sb);
	}
}
