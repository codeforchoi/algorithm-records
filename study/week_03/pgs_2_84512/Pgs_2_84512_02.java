package week_03.pgs_2_84512;

public class Pgs_2_84512_02 {
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}
	/*
	5 + 5^2 + 5^3 + 5^4 + 5^5 전체경우의 수 
	
	1 + 5^1 + 5^2 + 5^3 + 5^4 => 781
	1 + 5^1 + 5^2 + 5^3 => 156 
	1 + 5^1 + 5^2 => 31
	1 + 5^1 => 6
	1 => 1
	
	EEOIU => 1 * 781 + 1 / + 1 * 156 + 1 / 3 * 31 + 1 / 2 * 6 + 1 / + 4 * 1 + 1 
	*/
	private static int[] number = {781, 156, 31, 6, 1};
		
	public static int solution(String word) {
		int answer = 0;
		for(int i = 0; i < word.length(); i++) {
			answer += toIndexOf(word.charAt(i)) * number[i] + 1;
		}	
		return answer;
	}
	
	private static int toIndexOf(char ch) {
		return "AEIOU".indexOf(ch);
	}
}
