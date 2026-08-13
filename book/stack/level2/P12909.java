package stack.level2;

import java.util.*;

public class P12909 {
	public static void main(String[] args) {
		String str1 = "()()";
		String str2 = "(())()";
		String str3 = ")()(";
		String str4 = "(()(";
		System.out.println(solution(str1));
		System.out.println(solution(str2));
		System.out.println(solution(str3));
		System.out.println(solution(str4));
	}
	
	public static boolean solution(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for(Character ch : s.toCharArray()) {
			if(ch == '(') {
				stack.push(ch);
			} else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}		
		return stack.isEmpty();
    }
}
