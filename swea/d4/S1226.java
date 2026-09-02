package d4;

import java.io.*;
import java.util.*;

public class S1226 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		int[] dx = {-1, 1, 0, 0}; // 상하좌우
		int[] dy = {0, 0, -1, 1};
		
		int N = 16; // 16 * 16 행렬 고정값
		
		// 테스트 케이스 10개 고정
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 입력 흘리기
			sb.append("#").append(tc).append(" ");
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}		
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {1, 1});
			map[1][1] = 1;
			boolean canNotGo = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				// 4방향으로 모두 이동해본다.
				for(int i = 0; i < 4; i++) {						
					int nx = cur[0]+ dx[i];
					int ny = cur[1] + dy[i];
					
					// 맵 밖을 벗어나거나 벽(1)인 경우
					if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16 || map[nx][ny] == 1) {
						continue;
					}					
					
					// 도착지점이면 반복을 종료한다.
					if(map[nx][ny] == 3) {
						sb.append(1).append("\n");
						canNotGo = false;
						break;
					}
					
					q.offer(new int[] {nx, ny});
					map[nx][ny] = 1; // 지나온 길을 1로 처리
				}
			}
			
			if(canNotGo) {
				sb.append(0).append("\n");
			}			
		}
		System.out.println(sb);
	}	
}
