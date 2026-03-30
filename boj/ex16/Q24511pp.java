package ex16;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q24511pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] type = new int[n];
        int[] currentValue = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            type[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            currentValue[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] insertValue = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            insertValue[i] = Integer.parseInt(st.nextToken());
        }

        // 스택은 들어간 원소가 나오므로 구현할 필요가 없다.
        // 큐는 하나 큐로 합치며 후순위 큐의 원소가 합친 큐의 앞쪽에 위치해야한다.
        Deque<Integer> queueStack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (type[i] == 0) {
                queueStack.offerFirst(currentValue[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            queueStack.offerLast(insertValue[i]);
            sb.append(queueStack.pollFirst()).append(" ");
        }
        sb.setLength(sb.length() - 1); // 자료구조 N의 최소 개수가 1개 이상이므로 예외x
        System.out.println(sb);
    }
}