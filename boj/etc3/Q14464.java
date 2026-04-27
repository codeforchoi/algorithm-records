package etc3;

import java.io.*;
import java.util.*;

//
public class Q14464 {
    private static class Cow {
        int start, end;

        Cow(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken()); // 닭 수
        int N = Integer.parseInt(st.nextToken()); // 소 수

        int[] chicken = new int[C];
        for (int i = 0; i < C; i++) {
            chicken[i] = Integer.parseInt(br.readLine());
        }

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(a, b);
        }

        Arrays.sort(chicken);
        Arrays.sort(cows, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Cow> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        int idx = 0;
        int answer = 0;

        for (int t : chicken) {
            while (idx < N && cows[idx].start <= t) {
                pq.offer(cows[idx++]);
            }

            while (!pq.isEmpty() && pq.peek().end < t) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }
        }
        System.out.println(answer);
    }
}
