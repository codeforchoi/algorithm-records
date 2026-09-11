package d2;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N)
 * 공간 복잡도 : O(N)
 */
// Memory: 25,344 kb, Time: 77 ms, Code Length: 1,420
public class S14510 {
	
	private static int N, maxHeight;
	private static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			maxHeight = 0; 
					
			trees = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				if(trees[i] > maxHeight) maxHeight = trees[i];	// 최대 나무 높이 구하기
			}
			
			int one = 0; // 키 + 1 개수 
			int two = 0; // 키 + 2 개수 
			for(int i = 0; i < N; i++) {
				int diff = maxHeight - trees[i];
				two += diff / 2;
				one += diff % 2;
			}
			
			// 짝수 날이 많은 동안 홀수 날 2번으로 바꿔서 비슷하게 만든다.
			while(two > one + 1) {
				two--;
				one += 2;
			}
			
			int day = 0;
			// 같거나 짝수날이 많은 경우 필요 날짜 수
			if(two >= one) {
				day = 2 * two;
			} else { // 홀수 날이 많은 경우 필요 날짜 수
				day = 2 * one - 1;
			}			
			
			sb.append(day).append("\n");
		}
		System.out.println(sb);
	}
}