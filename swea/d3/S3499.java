package d3;

import java.io.*;
import java.util.*;

// 과제 01
public class S3499 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			int N = Integer.parseInt(br.readLine());		
			String[] cards = new String[N];
			
			st = new StringTokenizer(br.readLine());			
			for(int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}
			
			int mid = (N % 2 == 0) ? N / 2 : N / 2 + 1;
			
			for(int i = 0; i < N / 2; i++) {
				sb.append(cards[i]).append(" ").append(cards[mid + i]).append(" ");				
			}
			if(N % 2 == 1) sb.append(cards[mid - 1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
