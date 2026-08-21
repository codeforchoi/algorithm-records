package week_02.pgs_3_43164;

import java.util.*;

// 우선큐를 해시맵의 value로 미리 사전순으로 나오도록 설정
public class pgs_3_43164_03 {
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
 	
	public static String[] solution(String[][] tickets) {
		Map<String, PriorityQueue<String>> graph = new HashMap<>();
		
		for(String[] ticket : tickets) {
			// key값이 없으면 k (key)에 value를 PriorityQueue를 생성해서 넣어주고 
			// value를 반환하므로 offer 해줄 수 있다.
			graph.computeIfAbsent(ticket[0], k -> new PriorityQueue<>())
				.offer(ticket[1]);
		}
		
		// 앞에 삽일할 것이므로 LinkedList 선택
		LinkedList<String> route = new LinkedList<>();
		dfs("ICN", graph, route);
		return route.toArray(new String[0]);	
    }
	
	private static void dfs(String start, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {		
		PriorityQueue<String> pq = graph.get(start);
		
		// pq가 null인지 먼저 확인해서 NullPointException 예방
		while(pq != null && !pq.isEmpty()) {
			String next = pq.poll();
			dfs(next, graph, route);
		}
		route.addFirst(start);
	}
}