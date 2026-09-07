package week_05.lc_2_77;

import java.util.*;

public class Lc_2_77_combinations {
	private List<List<Integer>> answer;

	public List<List<Integer>> combine(int n, int k) {
		answer = new ArrayList<>();	
		
		int[] arr = new int[k];
		
		dfs(arr, n, k, 0, 1);
		
		return answer;
	}

	private void dfs(int[] arr, int n, int k, int depth, int start) {
		if (depth == k) {
			List<Integer> list = new ArrayList<>();
			for (int num : arr) {
				list.add(num);
			}
			answer.add(list);
			return;
		}

		for (int i = start; i <= n; i++) {
			arr[depth] = i;
			dfs(arr, n, k, depth + 1, i + 1);
		}
	}
}
