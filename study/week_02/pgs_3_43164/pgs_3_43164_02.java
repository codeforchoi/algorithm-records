package week_02.pgs_3_43164;

import java.util.*;

// result를 List가 아닌 String[]로 풀이
// 이렇게 하면 인덱스에 덮어씌우므로 복구 필요 x
public class pgs_3_43164_02 {
	public static void main(String[] args) {
		String[][] tickets1 = {
			    {"ICN", "JFK"},
			    {"HND", "IAD"},
			    {"JFK", "HND"}
			};
		String[][] tickets2 = {
			    {"ICN", "SFO"},
			    {"ICN", "ATL"},
			    {"SFO", "ATL"},
			    {"ATL", "ICN"},
			    {"ATL", "SFO"}
			};
		System.out.println(Arrays.toString(solution(tickets1)));
		System.out.println(Arrays.toString(solution(tickets2)));
	}
	
	private static boolean[] visited;
	private static int n;
	private static String[] result;
 	
	public static String[] solution(String[][] tickets) {
		Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
		
		n = tickets.length;
		
		visited = new boolean[n];
		result = new String[n + 1];
		result[0] = "ICN";
		
		dfs(tickets, "ICN", 0);        
        return result;
    }
	
	private static boolean dfs(String[][] tickets, String start, int depth) {
		if(depth == n) {
			return true;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && tickets[i][0].equals(start)) {
				visited[i] = true;				
				result[depth + 1] = tickets[i][1];
				
				if(dfs(tickets, tickets[i][1], depth + 1)) {
					return true;
				}
				visited[i] = false; // 탐색이 끝나면 복구				
			}
		}	
		return false;
	}
}
