package level1;

import java.util.*;

public class P42889sol1 {
	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 2, 1, 2, 6, 2, 4, 3, 3 };
		int[] arr2 = { 4, 4, 4, 4, 4 };
		System.out.println(Arrays.toString(solution(n, arr1)));
		System.out.println(Arrays.toString(solution(4, arr2)));
	}

	public static int[] solution(int N, int[] stages) {
		int[] challenger = new int[N + 2]; // 0인덱스 빼고 N인덱스까지라서 + 2
		for (int stage : stages) {
			challenger[stage]++;
		}

		Map<Integer, Double> fails = new HashMap<>();
		double total = stages.length;

		for (int i = 1; i <= N; i++) {
			if (challenger[i] == 0) {
				fails.put(i, 0.);
			} else {
				fails.put(i, challenger[i] / total);
				total -= challenger[i]; // 뒤에 앞에 스테이지 사람들은 뒤에 스테이지를 도달하지 못했을 것이므로
			}
		}

//		return fails.entrySet().stream()
//				.sorted((o1, o2) -> o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey())
//						: Double.compare(o2.getValue(), o1.getValue()))
//				.mapToInt(HashMap.Entry::getKey).toArray();
		
		return fails.entrySet().stream()
				.sorted((o1, o2) -> {
					if(o1.getValue().equals(o2.getValue())) {
						return Integer.compare(o1.getKey(), o2.getKey());
					} else {
						return Double.compare(o2.getValue(), o1.getValue());
					}
				}).mapToInt(HashMap.Entry::getKey).toArray();
	}
}
