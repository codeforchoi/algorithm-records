package etc3;

import java.io.*;
import java.util.*;

//
public class Q15678 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long[] K = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            K[i] = Long.parseLong(st.nextToken());
        }

        long[] dp = new long[N];
        Deque<Integer> deque = new ArrayDeque<>();
        long maxResult = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - D) {
                deque.pollFirst();
            }

            long prevMax = deque.isEmpty() ? 0 : Math.max(0, dp[deque.peekFirst()]);
            dp[i] = K[i] + prevMax;
            maxResult = Math.max(maxResult, dp[i]);

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        System.out.println(maxResult);
    }


}
