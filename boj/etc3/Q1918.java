package etc3;

import java.util.*;
import java.io.*;

//
public class Q1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char now = expression.charAt(i);

            if (now >= 'A' && now <= 'Z') {
                sb.append(now);
            } else if (now == '(') {
                stack.push(now);
            } else if (now == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            } else {
                // 연산자인 경우 우선순위 비교
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                    sb.append(stack.pop());
                }
                stack.push(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int priority(char op) {
        if (op == '(' || op == ')') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }
}
