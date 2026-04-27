package etc3;

import java.io.*;
import java.util.*;

//
public class Q12851 {
    private static int N, K;
    private static int[] time = new int[100001];
    private static int minTime = Integer.MAX_VALUE;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println((N - K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime);
        System.out.println(count);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        time[N] = 1; // 0초를 1로 처리 (방문 여부 확인용)

        while (!q.isEmpty()) {
            int now = q.poll();

            // 현재 시간이 이미 찾은 최단 시간보다 크면 더 이상 탐색 불필요
            if (minTime < time[now]) return;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = now + 1;
                else if (i == 1) next = now - 1;
                else next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    minTime = time[now]; // 실제로는 time[now]가 최단 시간
                    count++;
                }

                // 처음 방문하거나, 방문한 적이 있어도 같은 시간에 도달한 경우 큐에 추가
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    time[next] = time[now] + 1;
                    q.add(next);
                }
            }
        }
    }

}
