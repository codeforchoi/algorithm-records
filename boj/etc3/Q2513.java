package etc3;

import java.io.*;
import java.util.*;

//
public class Q2513 {
    private static class Stop {
        int dist, cnt;

        Stop(int dist, int cnt) {
            this.dist = dist;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        List<Stop> left = new ArrayList<>();
        List<Stop> right = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            if (x < S) left.add(new Stop(S - x, cnt));
            else if (x > S) right.add(new Stop(x - S, cnt));
        }

        left.sort((a, b) -> b.dist - a.dist);
        right.sort((a, b) -> b.dist - a.dist);

        long answer = 0;

        answer += solve(left, K);
        answer += solve(right, K);

        System.out.println(answer);
    }

    private static long solve(List<Stop> list, int K) {
        long sum = 0;
        int idx = 0;
        int remain = 0;

        while (idx < list.size()) {
            if (remain == 0) {
                remain = K;
                sum += (long) list.get(idx).dist * 2;
            }
            Stop now = list.get(idx);
            if (now.cnt <= remain) {
                remain -= now.cnt;
                idx++;
            } else {
                now.cnt -= remain;
                remain = 0;
            }
        }
        return sum;
    }
}
