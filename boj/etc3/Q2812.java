package etc3;

import java.util.*;
import java.io.*;

//
public class Q2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        int kCount = K; // 지워야 할 횟수
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            char current = number.charAt(i);

            // 스택이 비어있지 않고, 지울 횟수가 남았으며,
            // 현재 숫자가 스택의 마지막 숫자보다 크면 계속 pop
            while (!stack.isEmpty() && kCount > 0 && stack.peekLast() < current) {
                stack.removeLast();
                kCount--;
            }
            stack.addLast(current);
        }

        // 출력 시, 만약 K가 남았다면 그만큼 뒤를 잘라냄
        StringBuilder sb = new StringBuilder();
        int targetSize = N - K;
        for (int i = 0; i < targetSize; i++) {
            sb.append(stack.pollFirst());
        }
        System.out.println(sb);
    }
}
