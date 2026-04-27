package etc3;

import java.io.*;
import java.util.*;

//
public class Q1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(br.readLine()));
        }

        long answer = 0;

        while (pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();

            long sum = a + b;
            answer += sum;

            pq.offer(sum);
        }
        System.out.println(answer);
    }
}
