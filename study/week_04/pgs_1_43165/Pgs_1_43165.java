package week_04.pgs_1_43165;

public class Pgs_1_43165 {
	public static void main(String[] args) {
		int[] numbers1 = { 1, 1, 1, 1, 1 };
		int target1 = 3;

		System.out.println(solution(numbers1, target1));

		int[] numbers2 = { 4, 1, 2, 1 };
		int target2 = 4;

		System.out.println(solution(numbers2, target2));
	}

	private static int count = 0;

	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return count;
	}

	private static void dfs(int[] numbers, int target, int depth, int sum) {
		if (depth >= numbers.length) {
			if (sum == target)
				count++;
			return;
		}

		dfs(numbers, target, depth + 1, sum + numbers[depth]);
		dfs(numbers, target, depth + 1, sum + numbers[depth] * (-1));
	}

}
