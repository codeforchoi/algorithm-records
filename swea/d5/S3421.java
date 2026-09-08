package d5;

import java.io.*;
import java.util.*;

public class S3421 {
	
	private static int N, M;
	private static boolean[] selected; // 선택됐는지 확인 정보
	private static boolean[][] bad; // 궁합이 안맞는 재료 정보
	private static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			selected = new boolean[N + 1];
			bad = new boolean[N + 1][N + 1];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				bad[a][b] = true;
				bad[b][a] = true;
			}
			
			count = 0;
			subset(1); // 재료 1번부터 시작
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void subset(int idx) {
		if(idx > N) {
			count++;
			return;
		}
		
		// 현재 재료를 선택하지 않는 경우
		selected[idx] = false;
		subset(idx + 1);
		
		// 현재 재료를 선택하는 경우
		if(canSelect(idx)) {
			selected[idx] = true;
			subset(idx + 1);			
		}
	}
	
	private static boolean canSelect(int idx) {
		// 이미 넣은 재료 중에 현재 재료와 안맞는게 있는지 확인
		for(int i = 1; i < idx; i++) {
			if(selected[i] && bad[i][idx]) {
				return false;
			}
		}
		return true;
	}
}
