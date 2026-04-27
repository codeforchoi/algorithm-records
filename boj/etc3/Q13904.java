package etc3;

import java.io.*;
import java.util.*;

//
public class Q13904 {
    private static class Homework {
        int day, score;

        Homework(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Homework[] arr = new Homework[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Homework(d, w);
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a.day, b.day));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Homework hw : arr) {
            pq.offer(hw.score);

            if (pq.size() > hw.day) {
                pq.poll();
            }
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        System.out.println(answer);
    }
}
