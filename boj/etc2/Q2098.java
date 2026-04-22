package etc2;

import java.io.*;
import java.util.*;

// TSP (외판원 순회, Traveling Salesperson Problem)
// 모든 경로를 탐색하려면 16!로 시간초과이므로 방문상태를 비트마스크로 표현하고 DP로 관리한다.
// 최단 경로는 어느정점에서 시작해도 똑같으므로 같은 상태 중복을 제거하기 위해 DP 메모제이션 기법을 사용한다.
// 시작 도시는 사이클 특성상 어디든 상관없으므로 0번으로 고정한다.
public class Q2098 {
    static int N;
    static int[][] W, dp;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // [현재 도시 번호, 도시 방문 상태 값(전체 경우 수)]
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 0번 도시에서 시작, 0번 도시 방문
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int cur, int visited) {
        // 모든 도시를 다 지난 경우
        if (visited == (1 << N) - 1) { // ex) 1111
            // 현재 도시에서 처음 출발 도시로 가는 길이 없는 경우
            if(W[cur][0] == 0) return INF;
            return W[cur][0];
        }

        // 이미 계산된 경우 (DP 메모제이션 기법)
        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        // 해당 도시 방문 처리
        dp[cur][visited] = INF;

        // 방문하지 않은 도시 탐색
        for (int next = 0; next < N; next++) {
            // 이미 방문했거나 길이 없는 경우
            if((visited & (1 << next)) != 0 || W[cur][next] == 0) continue;

            // 방문하지 않았으면 방문 처리로 방문값 세팅
            int nextVisited = visited | (1 << next);

            // 최소비용 비교 후 갱신, 실제 값 계산은 W[cur][0]가 반환될 때 depth 끝에서부터 올라오면서 계산됨.
            dp[cur][visited] = Math.min(dp[cur][visited], W[cur][next] + tsp(next, nextVisited));
        }
        return dp[cur][visited];
    }
}
