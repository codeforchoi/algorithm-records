package ex28;

import java.io.*;
import java.util.*;

public class Q1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] buildTime = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[N + 1];
            int[] dp = new int[N + 1];

            List<Integer>[] graph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                inDegree[b]++;
            }

            int w = Integer.parseInt(br.readLine());

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (inDegree[i] == 0) {
                    q.offer(i);
                    dp[i] = buildTime[i]; // 진입 차수 0인 것들부터 건설시간 저장
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                // 동시에 지어지는 건물들 중 시간 긴것 기준이므로 max를 구한다.
                for (int next : graph[cur]) {
                    inDegree[next]--;
                    dp[next] = Math.max(dp[next], dp[cur] + buildTime[next]);

                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            sb.append(dp[w]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
