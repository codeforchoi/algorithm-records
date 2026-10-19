package ssafy;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N + M)
 * 공간 복잡도 : O(N + M)
 * KMP
 */
public class B1786 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String T = br.readLine(); // string
		String P = br.readLine(); // substring
		
		final int N = T.length();
		final int M = P.length();
		
		int[] pi = new int[M];
		int j = 0;
		
		// substring에서 반복 패턴 찾기
		// 첫 인덱스는 이전에 반복이 없으므로 무조건 0
		for(int i = 1; i < M; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}		
		
		List<Integer> positions = new ArrayList<>();
		j = 0;
		
		// KMP 적용
		for(int i = 0; i< N; i++) {
			while(j > 0 && T.charAt(i) != P.charAt(j)) {
				j = pi[j - 1];
			}
			
			if(T.charAt(i)== P.charAt(j)) {
				j++;
				
				if(j == M) {
					positions.add(i - M + 2);
					j = pi[j - 1];
				}
			}
		}	
		
		sb.append(positions.size()).append("\n");		
		for(int position : positions) sb.append(position).append(" ");
		System.out.println(sb);
	}
}
