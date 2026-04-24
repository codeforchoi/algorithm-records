package ex28;

import java.io.*;
import java.util.*;

public class Q2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K - 1; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph[prev].add(next);
                inDegree[next]++;
                prev = next;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        // 진입 차수가 0인 것들을 큐에 넣는다.
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append("\n");
            count++;
            for (int next : graph[cur]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        // count가 가수 수랑 같지 않으면 순서를 정하는 것이 불가능하다.(어딘가 순환이 발생했을 것)
        System.out.println((count != N) ? 0 : sb);
    }
}
