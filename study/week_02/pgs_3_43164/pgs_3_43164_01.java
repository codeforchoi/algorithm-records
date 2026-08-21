package week_02.pgs_3_43164;

import java.util.*;

public class pgs_3_43164_01 {
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
	private static List<String> result;
 	
	public static String[] solution(String[][] tickets) {
		Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
		
		n = tickets.length;
		
		visited = new boolean[n];
		result = new ArrayList<>();
		result.add("ICN");
		
		dfs(tickets, "ICN", 0);        
        return result.toArray(new String[0]);
    }
	
	private static boolean dfs(String[][] tickets, String start, int depth) {
		if(depth == n) {
			return true;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && tickets[i][0].equals(start)) {
				visited[i] = true;				
				result.add(tickets[i][1]);
				
				if(dfs(tickets, tickets[i][1], depth + 1)) {
					return true;
				}
				visited[i] = false; // 탐색이 끝나면 복구
				result.remove(result.size() - 1); // 탐색이 끝나면 결과도 복구
			}
		}	
		return false;
	}
}
