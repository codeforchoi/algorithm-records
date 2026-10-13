package d;

import java.io.*;
import java.util.*;

/**
 * 시간 복잡도 : O()
 * 공간 복잡도 : O()
 */
// Memory: 34,176 kb, Time: 167 ms, Code Length: 2,864
public class S2383 {

	private static int N, minTime;
	private static List<Person> people;
	private static Stair[] stairs;

	private static class Person {
		int id, r, c;
		int[] time; // 계단까지의 이동 시간

		public Person(int id, int r, int c) {
			super();
			this.id = id;
			this.r = r;
			this.c = c;
			this.time = new int[2];
		}
	}

	private static class Stair {
		int r, c, k;

		public Stair(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			people = new ArrayList<>();
			stairs = new Stair[2];
			minTime = Integer.MAX_VALUE;

			int p_idx = 0;
			int s_idx = 0;
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int value = Integer.parseInt(st.nextToken());
					if (value == 1) {
						people.add(new Person(p_idx++, i, j));
					} else if (value >= 2) {
						stairs[s_idx++] = new Stair(i, j, value);
					}
				}
			}

			// 각 사람마다 계단까지 도착 시간 계산
			for (Person p : people) {
				int pr = p.r, pc = p.c, sr = 0, sc = 0;

				// 계단별 시간 계산
				for (int i = 0; i < 2; i++) {
					sr = stairs[i].r;
					sc = stairs[i].c;
					p.time[i] = Math.abs(pr - sr) + Math.abs(pc - sc);
				}
			}

			int count = 1 << p_idx;
			// 각 사람을 계단에 정하는 배치 경우의 수 만큼 계산
			for (int i = 0; i < count; i++) {
				// 계단 별 계산 (비트마스킹: 0은 0 인덱스 계단, 1은 1 인덱스 계단)
				int time = 0;
				for (int j = 0; j < 2; j++) {
					time = Math.max(time, calculate(i, j));
				}
				minTime = Math.min(minTime, time);
			}

			sb.append("#").append(tc).append(" ").append(minTime).append("\n");
		}

		System.out.println(sb);
	}

	private static int calculate(int bit, int idx) {
		
		List<Person> list = new ArrayList<>();

		for (int i = 0; i < people.size(); i++) {
			Person p = people.get(i);
			// idx와 같으면 해당 계단으로 가는 사람
			if (((bit >> p.id) & 1) == idx) {
				list.add(p);
			}
		}
		
		if(list.isEmpty()) return 0;

		// 해당 계단의 시간 오름 차순 정렬
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.time[idx], o2.time[idx]));

		int k = stairs[idx].k;		

		List<Integer> endTimes = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			Person p = list.get(i);
			int start = p.time[idx] + 1; // 계단 내려갈 수 있는 시작 시간
			
			if(i >= 3) {
				start = Math.max(start, endTimes.get(i - 3));
			}			
			
			int end = start + k;
			endTimes.add(end);
		}
		
		return endTimes.get(list.size() - 1);
	}
}
