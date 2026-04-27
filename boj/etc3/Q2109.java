package etc3;

import java.util.*;
import java.io.*;

public class Q2109 {
    private static class Lecture implements Comparable<Lecture> {
        int p, d;

        public Lecture(int p, int d) {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o) {
            // 기한(d) 기준 오름차순 정렬
            if (this.d == o.d) return o.p - this.p; // 기한 같으면 돈 많은 순
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(p, d));
        }

        // 1. 기한 순으로 정렬
        Collections.sort(lectures);

        // 2. 강연료를 담을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Lecture l : lectures) {
            pq.add(l.p);
            // 선택한 강연 수가 기한을 초과하면 가장 싼 강연 포기
            if (pq.size() > l.d) {
                pq.poll();
            }
        }

        // 3. 큐에 남은 금액 모두 합산
        long totalPay = 0;
        while (!pq.isEmpty()) {
            totalPay += pq.poll();
        }
        System.out.println(totalPay);
    }

}
