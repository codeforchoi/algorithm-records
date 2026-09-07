package d3;

import java.io.*;
import java.util.*;


/**
 * 규영이가 가진 9장의 카드를 visited 배열에 방문 처리하고, 
 * 인영이가 사용할 수 있는 나머지 9장의 카드 순서를 DFS와 백트래킹을 이용해 모든 경우의 수(9!)를 탐색
 * 각 라운드마다 두 카드의 크기를 비교하여 승자를 정해 점수를 더한다.
 * 9라운드 모두 끝나면 두 사람의 점수를 비교해 승리, 패배 횟수 계산하고, 백트래킹 과정에서 방문 상태와 점수를 이전 상태로 복구
 */
//Memory: 26,240 kb, Time: 3,009 ms, Code Length: 1,652
public class S6808 {
	private static final int N = 18;
	private static boolean[] visited;
	private static int a_score, b_score; // a_score : 규영 점수, b_score : 인영 점수
	private static int winCount;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			visited = new boolean[N + 1];
			int[] givenCards = new int[N / 2];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N / 2; i++) {
				int num = Integer.parseInt(st.nextToken());
				visited[num] = true;
				givenCards[i] = num;
			}
			
			a_score = b_score = winCount = 0;
			dfs(givenCards, 0);
			
			int total = 1;
			for(int i = 2; i <= 9; i++) {
				total *= i;
			}
			sb.append(winCount).append(" ").append(total - winCount).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void dfs(int[] givenCards, int depth) {
		// 모든 라운드가 끝나면 결과 계산 후 반영 
		if(depth == N / 2) {
			if(a_score > b_score) {
				winCount++;
			} 
			return;
		}
		
		// 가능한 카드 탐색
		for(int i = 1; i <= N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				// 점수 백업
				int tempScore_a = a_score;
				int tempScore_b = b_score;
				int score = i + givenCards[depth];
				// 비기는 경우는 없음
				if(i < givenCards[depth]) {
					a_score += score;
				} else {
					b_score += score;
				}
				
				dfs(givenCards, depth + 1);
			
				// 백트래킹
				visited[i] = false;
				a_score = tempScore_a;
				b_score = tempScore_b;
			}
		}
	}
}
