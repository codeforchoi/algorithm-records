package d4;

import java.io.*;
import java.util.*;

public class S1824 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int tc = 1;

		Map<Character, int[]> direction = new HashMap<>();
		direction.put('<', new int[] { 0, -1 });
		direction.put('>', new int[] { 0, 1 });
		direction.put('^', new int[] { -1, 0 });
		direction.put('v', new int[] { 1, 0 });

		StringTokenizer st;
		while (T-- > 0) {
			sb.append("#").append(tc++).append(" ");
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			char[][] order = new char[R][C];
			for (int i = 0; i < R; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					order[i][j] = line[j];
				}
			}

			int memory = 0;
			char curDir = '>';
			char command = order[0][0];
			int x = 0, y = 0;
			boolean isFinish = false;
			while () {
				int nx = x + direction.get(curDir)[0];
				int ny = y + direction.get(curDir)[1];

				// 행 경계 밖 처리
				if (nx < 0)
					nx = R - 1;
				else if (nx >= R)
					nx = 0;

				// 열 경계 밖 처리
				if (ny < 0)
					ny = R - 1;
				else if (ny >= R)
					ny = 0;

				command = order[nx][ny];
				
				// '@'를 만나면 프로그램 종료
				if(command == '@') {
					isFinish = true;
					sb.append("YES");
					break;
				}
				
				if (command >= '0' && command <= '9') {
					memory = command - '0';
				} else {
					switch (command) {
					case '_':
						curDir = memory == 0 ? '>' : '<';
					case '|':
						curDir = memory == 0 ? 'v' : '^';
					case '?':
						
					case '.':
						continue;
					case '+':
						if(memory == 15) {
							memory = 0;
						} else {
							memory++;
						}
						break;
					case '-':
						if(memory == 0) {
							memory = 15;
						} else {
							memory--;
						}
						break;						
					default:
					}
				}
			}
			
		}
	}
}
