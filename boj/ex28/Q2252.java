package ex28;

import java.io.*;
import java.util.*;

// 위상정렬 문제
public class Q2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] inDegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            inDegree[b]++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        // 진입차수가 0인 것들 먼저 큐에 넣기
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for (int next : graph[now]) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        System.out.println(sb);
    }
}
