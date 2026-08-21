package week_03.pgs_2_84512;

public class pgs_2_84512 {
	public static void main(String[] args) {
		System.out.println(solution("AAAAE"));
		System.out.println(solution("AAAE"));
		System.out.println(solution("I"));
		System.out.println(solution("EIO"));
	}

	private static String vowel = "AEIOU";
	private static int count = 0;
	private static int answer = 0;

	public static int solution(String word) {
		count = 0;
		answer = 0;
		dfs("", word);
		return answer;
	}

	private static void dfs(String cur, String target) {
		if (cur.length() >= 5) {
			return;
		}

		for (char ch : vowel.toCharArray()) {
			String word = cur + ch;
			count++;

			if (word.equals(target)) {
				answer = count;
				return;
			}

			dfs(word, target);

			if (answer != 0) {
				return;
			}
		}
	}
}
