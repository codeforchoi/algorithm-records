package stack.level2;

import java.util.*;

public class P12973 {
	public static void main(String[] args) {
		String s1 = "baabaa";
		String s2 = "cdcd";
		System.out.println(solution(s1));
		System.out.println(solution(s2));
	}
	
	public static int solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(Character ch : s.toCharArray()) {			
			if(!stack.isEmpty() && stack.peek() == ch) stack.pop();
			else stack.push(ch);
		}      
        return stack.isEmpty() ? 1 : 0;
    }
	
}
