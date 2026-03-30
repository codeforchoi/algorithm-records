package boj.ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;
            else sb.append(isVPS(line)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static String isVPS(String line) {
        Stack<Character> stack = new Stack<>();
        for (char ch : line.toCharArray()) {
            switch(ch) {
                case '(': case'[':
                    stack.push(ch);
                    break;
                case ')':
                    if(stack.isEmpty() || stack.peek() != '(') return "no";
                    else stack.pop();
                    break;
                case ']':
                    if(stack.isEmpty() || stack.peek() != '[') return "no";
                    else stack.pop();
                default:
                    break;
            }
        }
        if (stack.isEmpty()) return "yes";
        else return "no";
    }
}