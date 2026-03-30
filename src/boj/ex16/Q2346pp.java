package boj.ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q2346pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.offerLast(new int[] {(i+1), Integer.parseInt(st.nextToken())});
        }

        int[] next = deque.pollFirst();
        int step = next[1];
        sb.append(next[0]).append(" ");
        while (!deque.isEmpty()) {
            if (step > 0) {
                for (int i = 1; i < step; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                next = deque.pollFirst();
            } else {
                for (int i = 1; i < (-1 * step); i++) {
                    deque.offerFirst(deque.pollLast());
                }
                next = deque.pollLast();
            }
            step = next[1];
            sb.append(next[0]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}