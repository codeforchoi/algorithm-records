package boj.ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q18258sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(queue.isEmpty() ? -1 : queue.pop()).append("\n");;
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");;
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");;
                    break;
                case "front" :
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");;
                    break;
                case "back" :
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");;
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}