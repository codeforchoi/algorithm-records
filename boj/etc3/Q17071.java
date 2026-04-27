package etc3;

import java.io.*;
import java.util.*;

//
public class Q17071 {
    private static final int MAX = 500000;
    private static int[][] visited = new int[2][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);

        bfs(N);

        int time = 0;
        int sisterPos = K;
        int result = -1;

        while (sisterPos <= MAX) {
            int parity = time % 2;
            if (visited[parity][sisterPos] != -1 && visited[parity][sisterPos] <= time) {
                result = time;
                break;
            }
            time++;
            sisterPos += time;
        }
        System.out.println(result);
    }

    private static void bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visited[0][start] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int pos = curr[0];
            int time = curr[1];

            int nextTime = time + 1;
            int nextParity = nextTime % 2;

            for (int nextPos : new int[]{pos - 1, pos + 1, pos * 2}) {
                if (nextPos >= 0 && nextPos <= MAX && visited[nextParity][nextPos] == -1) {
                    visited[nextParity][nextPos] = nextTime;
                    q.add(new int[]{nextPos, nextTime});
                }
            }
        }
    }

}
