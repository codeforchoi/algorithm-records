package queue.level1;

import java.util.*;

public class P159994 {
	public static void main(String[] args) {
		String[] cards1 = {"i", "drink", "water"};
	    String[] cards2 = {"want", "to"};
	    String[] goal = {"i", "want", "to", "drink", "water"};

	    String[] cards1_2 = {"i", "water", "drink"};
	    String[] cards2_2 = {"want", "to"};
	    String[] goal2 = {"i", "want", "to", "drink", "water"};

	    System.out.println(solution(cards1, cards2, goal));       
	    System.out.println(solution(cards1_2, cards2_2, goal2));
	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {				
		Queue<String> q1 = new ArrayDeque<>();
		Queue<String> q2 = new ArrayDeque<>();
		
		for(String str : cards1) {
			q1.offer(str);
		}
		
		for(String str : cards2) {
			q2.offer(str);
		}
		
		for(String word : goal) {
			boolean isCards1 = (!q1.isEmpty()) ? q1.peek().equals(word) : false;
			boolean isCards2 = (!q2.isEmpty()) ? q2.peek().equals(word) : false;
			
			if(!isCards1 && !isCards2 ) return "No";
			
			if(isCards1) q1.poll();
			else if (!q2.isEmpty() && isCards2) q2.poll();
		}
		return "Yes";
	}

}
