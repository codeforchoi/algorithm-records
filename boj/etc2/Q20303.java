package etc2;

import java.io.*;
import java.util.*;

// union-find, dp
// 0/1 Knapscak(배낭 문제)
public class Q20303 {
    private static int[] friend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int maxCount = 0;
        int[] candyCount = new int[N + 1];

        friend = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friend[i] = i;
            candyCount[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int[] people = new int[N + 1];
        int[] totalCandy = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            people[root]++;
            totalCandy[root] += candyCount[i];
        }

        int[] dp = new int[K]; // i명 뺏었을 때 최대 사탕 수 (K - 1) 까지가 안들키고 최대 사탕 수
        // 0/1 Knapscak(한 번만 사용하기 위해 뒤로 순회)
        for (int i = 1; i <= N; i++) {
            if (people[i] > 0) {
                int p = people[i];
                int c = totalCandy[i];

                // 해당 그룹의 학생이 들어갈 수 있는 경우에 최대값 비교해서 갱신
                for (int j = K - 1; j >= p; j--) {
                    dp[j] = Math.max(dp[j], dp[j - p] + c);
                }
            }
        }
        System.out.println(dp[K - 1]);
    }

    private static int find(int n) {
        if(friend[n] == n) return n;
        return friend[n] = find(friend[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) friend[u] = v;
    }
}
