package etc3;

import java.io.*;
import java.util.*;

//
public class Q1725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] h = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            h[i] = Integer.parseInt(br.readLine());
        }

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        long maxArea = 0;

        for (int i = 1; i <= N + 1; i++) {
            while (!stack.isEmpty() && h[stack.peek()] > h[i]) {
                int height = h[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, (long) height * width);
            }
            stack.push(i);
        }
        System.out.println(maxArea);
    }
}
