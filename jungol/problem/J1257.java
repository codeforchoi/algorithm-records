package problem;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O(N log N)
 * 공간 복잡도 : O(N)
 * 최장 증가 수열 (LIS)
 */
// Memory: 52.4 MB, Time: 703 ms, Code Length: 1,443
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
		int[] trace = new int[N]; // 역추적용 
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
			trace[idx++] = left; // 대체된 인덱스 저장
			
			if(left == len) {
				len++;
			}
		}
		
		boolean[] selected = new boolean[N];
		int target = len - 1;
		// trace의 각 마지막에 저장된 인덱스의 것이 lis에 들어가 있는 선택된 것들
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
