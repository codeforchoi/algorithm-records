package ex28;

import java.io.*;
import java.util.*;

// 위상정렬
public class Q3665 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] lastYear = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                lastYear[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer>[] graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
            int[] inDegree = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    graph[lastYear[i]].add(lastYear[j]);
                    inDegree[lastYear[j]]++;
                }
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                // v팀이 u팀을 순위 역전함.
                if (graph[u].contains(v)) {
                    // Integer.valueOf로 객체를 넘기면 해당 요소를 찾아서 제거
                    graph[u].remove(Integer.valueOf(v));
                    graph[v].add(u);
                    inDegree[v]--;
                    inDegree[u]++;
                } else { // u팀이 v팀을 순위 역전함.
                    graph[v].remove(Integer.valueOf(u));
                    graph[u].add(v);
                    inDegree[u]--;
                    inDegree[v]++;
                }
            }

            StringBuilder temp = new StringBuilder();
            boolean isPossible = true;
            boolean isAmbiguous = false;
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                if(inDegree[i] == 0) q.offer(i);
            }

            for (int i = 0; i < n; i++) {
                // n개를 정하기 전에 큐가 비면 불가능한 경우이다.
                if (q.isEmpty()) {
                    isPossible = false;
                    break;
                }
                // 순위가 모호한 경우, 순위가 정확하면 큐 사이즈는 항상 1
                if (q.size() > 1) {
                    isAmbiguous = true;
                    break;
                }

                int cur = q.poll();
                temp.append(cur).append(" ");

                for (int next : graph[cur]) {
                    inDegree[next]--;
                    if(inDegree[next] == 0) q.offer(next);
                }
            }

            if(!isPossible) sb.append("IMPOSSIBLE");
            else if (isAmbiguous) sb.append("?");
            else sb.append(temp);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
