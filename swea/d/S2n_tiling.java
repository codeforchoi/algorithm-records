package d;

import java.io.*;

public class S2n_tiling {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 15;
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N + 2]; // N이 1인 경우 인덱스 오류 대비
			
			dp[1] = 1;
			dp[2] = 3;
			for(int i = 3; i <= N; i++) {
				// (i - 1 칸 + 세로 타일) + (i - 2 칸 + 2x2 타일 1개, 2x1타일 가로 2개) 
				dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
			}
			
			sb.append(dp[N]).append("\n");			
		}
		System.out.println(sb);		
	}
}

/*
============================================================
[입력 데이터 (Input)]
============================================================

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15

============================================================
[출력 데이터 (Output)]
============================================================

1
3
5
11
21
43
85
171
341
683
1365
2731
5461
916
1831
*/