package etc;

import java.io.*;
import java.util.*;

// 입력받은 수들의 일부를 선택해서 합이 TARGET이 되는 경우의 수 구하기
public class SubsetSum {
	static int N, TARGET, answer; // 원소 수
	static int[] input; // 입력 받은 수들

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		TARGET = Integer.parseInt(br.readLine());
		input = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		answer = 0;
		generateSubset(0, 0, 0);
		System.out.println(answer);
	}

	/**
	 * @param idx : 처리해야하는 원소의 인덱스
	 * @param sum : 선택된 원소들의 합
	 * @param cnt : 선택된 원소 개수
	 */
	static void generateSubset(int idx, int sum, int cnt) {

		if (idx == N) { // 모든 원소를 다 고려했면
			if (cnt > 0 && sum == TARGET) { // cnt > 0 조건을 빼면 공집합까지 셈
				++answer;
			}
			return;
		}

		// 해당 원소를 부분집합에 포함시키기
		generateSubset(idx + 1, sum + input[idx], cnt + 1);
		// 해당 원소를 부분집합에 미포함시키기
		generateSubset(idx + 1, sum, cnt);
	}

	static void generateSubset2(int idx, int sum, int cnt) { // idx : 처리해야하는 원소의 인덱스, sum : 선택된 원소들의 합, cnt : 선택된 원소개수
		if (sum == TARGET) {
			++answer;
			return;
		}

		if (idx == N || sum > TARGET) return;

		// 해당 원소를 부분집합에 포함시키기
		generateSubset(idx + 1, sum + input[idx], cnt + 1);
		// 해당 원소를 부분집합에 미포함시키기
		generateSubset(idx + 1, sum, cnt);
	}
}
