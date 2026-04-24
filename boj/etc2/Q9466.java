package etc2;

import java.io.*;
import java.util.*;

public class Q9466 {
    static int n;
    static int count;
    static int[] visited; // 0: 미방문, 1: 방문중, 2: 방문완료
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new int[n + 1];
            count = 0; // 팀에 속한 학생 수

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                // 방문한 적이 없다면 방문한다.
                if (visited[j] == 0) {
                    dfs(j);
                }
            }
            sb.append(n - count).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    private static void dfs(int x) {
        visited[x] = 1; // 방문중 처리
        int next = arr[x];

        // 방문한 적이 없다면 방문한다.
        if (visited[next] == 0) {
            dfs(next);
        } else if (visited[next] == 1) { // 방문중이라면 사이클이 발생한 것 (팀 생성됨)
            count++; // 현재값 x 학생 카운트
            for (int i = next; i != x; i = arr[i]) {
                count++;
            }
        }

        // 방문 처리
        visited[x] = 2;
    }
}
