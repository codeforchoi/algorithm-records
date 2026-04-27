package etc3;

import java.io.*;
import java.util.*;

//
public class Q6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            long[] h = new long[n];
            for (int i = 0; i < n; i++) {
                h[i] = Long.parseLong(st.nextToken());
            }
            sb.append(getMaxArea(n, h)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static long getMaxArea(int n, long[] h) {
        Deque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                long height = h[stack.pop()];
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            long height = h[stack.pop()];
            long width = stack.isEmpty() ? n : n - 1 - stack.peek();
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }
}
