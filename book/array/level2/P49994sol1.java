package array.level2;

import java.util.*;

// 49994번 문제에서 U R D L 이 보는 방향에 따라 바뀌도록 설정한 문제 풀이
// 예를들어 R 상태에서 U은 R이다. D는 L이고 L은 U이며 R은 D이다.
public class P49994sol1 {
	public static void main(String[] args) {
		String str1 = "ULURRDLLU";
		String str2 = "LULLLLLLU";
		System.out.println(solution(str1));
		System.out.println(solution(str2));
	}
	
	public static int solution(String dirs) {
		int[] dx = {0, 1, 0, -1}; // U -> R -> D -> L 90도씩 회전
		int[] dy = {1, 0, -1, 0};
		
		int x = 0;
		int y = 0;
		
		int ndir = 0; // 기본 U 방향 시작
		Set<String> visited = new HashSet<>();
		
		for(char dir : dirs.toCharArray()) {
			int relativeDir = 0;
			switch(dir) {
				case 'U':
					relativeDir = 0;
					break;
				case 'R':
					relativeDir = 1;
					break;
				case 'D':
					relativeDir = 2;
					break;
				case 'L':
					relativeDir = 3;
					break;
			}
			
			// 현재 바라보는 방향을 기준으로 실제 방향 계산
			int realDir = (ndir + relativeDir) % 4;
			
			int nx = x + dx[realDir];
			int ny = y + dy[realDir];
			
			if(nx < -5 || ny < -5 || nx > 5 || ny > 5) continue;
			
			visited.add(x + " " + y + " " + nx + " " + ny);
            visited.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
            
            ndir = realDir;
		}
		return visited.size() / 2;
		
    }

}
