package ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q12789pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count = 1;

        while (n-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (num == count) {
                count++;
                while (!stack.isEmpty()) {
                    if (stack.peek() == count) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            } else {
                stack.push(num);
            }
        }
        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }
}