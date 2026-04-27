package etc3;

import java.io.*;
import java.util.*;

public class Q11000 {
    private static class Lecture {
        int start, end;

        Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] arr = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            arr[i] = new Lecture(s, t);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start == b.start) return Integer.compare(a.end, b.end);
            return Integer.compare(a.start, b.start);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0].end);

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= arr[i].start) {
                pq.poll();
            }
            pq.offer(arr[i].end);
        }
        System.out.println(pq.size());
    }
}
