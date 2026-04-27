package etc3;

import java.io.*;
import java.util.*;

//
public class Q13975 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            long answer = 0;

            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();

                long sum = a + b;
                answer += sum;

                pq.offer(sum);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
