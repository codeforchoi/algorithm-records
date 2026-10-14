package problem;

import java.io.*;
import java.util.*;

public class J1257 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] wireInfo = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wireInfo[i][0] = Integer.parseInt(st.nextToken());
			wireInfo[i][1] = Integer.parseInt(st.nextToken());			
		}			
		
		Arrays.sort(wireInfo, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		int[] lis = new int[N + 1];
		int[] trace = new int[N];
		int len = 0;
		int idx = 0;
		
		for(int[] wire : wireInfo) {
			int left = 0;
			int right = len;
			
			while(left < right) {
				int mid = (left + right) / 2;
				
				if(lis[mid] < wire[1]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			
			lis[left] = wire[1];
			trace[idx++] = left;
			
			if(left == len) {
				len++;
			}
		}
		
		boolean[] selected = new boolean[N];
		int target = len - 1;
		for(int i = N - 1; i >= 0; i--) {
			if(trace[i] == target) {
				selected[i] = true;
				target--;
			}
		}
		
		sb.append(N - len).append("\n");
		for(int i = 0; i < N; i++) {
			if(!selected[i]) {
				sb.append(wireInfo[i][0]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
