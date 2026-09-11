package d4;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(2^N)
 * 공간 복잡도 : O(N)
 */
// Memory: 25,856 kb, Time: 78 ms, Code Length: 1,259
public class S1486 {
	
	private static int N, B, minHeight;
	private static int[] heights;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			heights = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());				
			}
			
		
			minHeight = Integer.MAX_VALUE;
			dfs(0, 0);
			
			sb.append("#").append(tc).append(" ").append(minHeight - B).append("\n");
		}		
		System.out.println(sb);
	}	
	
	private static void dfs(int depth, int sum) {
		// B보다 크면 최솟값 비교 후 갱신
		if (sum >= B) {
		    minHeight = Math.min(minHeight, sum);
		    return;
		}

		// 모든 탐색을 끝낸 경우
		if(depth == N) {
			return;
		}
		
		// 점원을 뽑는 경우 
		dfs(depth + 1, sum + heights[depth]);
		// 점원을 뽑지 않는 경우
		dfs(depth + 1, sum);		
	}	
}

//// 합이 최소값보다 커지면 뒤로 더 볼 필요 없음 (가지치기)
//if(sum >= minHeight) {
//	return;
//}
//
//// 여기서 찾아진 sum은 최솟값
//if(sum >= B) {
//	minHeight = sum;
//	return;
//}