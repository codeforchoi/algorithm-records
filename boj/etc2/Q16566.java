package etc2;

import java.io.*;
import java.util.*;

// union-find
// 이분 탐색
public class Q16566 {
    private static int[] cards;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        cards = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        parent = new int[M + 1]; // 인덱스 오버플로우 방지
        for(int i = 0; i <= M; i++) parent[i] = i;

        // 철수가 낼 카드들
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int x = Integer.parseInt(st.nextToken());
            int index = upperBound(x); // 철수가 낼 카드보다 큰 수 카드 중 가장 작은 카드 인덱스
            index = find(index); // 이미 냈는지 확인, 냈으면 연결된 다음 큰수 인덱스 저장
            sb.append(cards[index]).append("\n");
            union(index, index + 1); // 다음 큰수로 연결
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    // 철수가 낸 카드보다 큰 카드들 중 가장 작은 카드의 인덱스 반환
    private static int upperBound(int target) {
        int left = 0;
        int right = cards.length;

        while (left < right) {
            int mid = (left + right) / 2;
            if(cards[mid] <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    private static int find(int n) {
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void union(int u, int v) {
        u = find(u);
        v = find(v);
        parent[u] = v;
    }
}
