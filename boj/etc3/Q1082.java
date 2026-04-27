package etc3;

import java.io.*;
import java.util.*;

//
public class Q1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        // 첫 자리용 최소 비용 숫자 (0 제외)
        int first = -1;
        for (int i = 1; i < N; i++) {
            if (first == -1 || cost[i] < cost[first] ||
                    (cost[i] == cost[first] && i > first)) {
                first = i;
            }
        }

        // 숫자 하나도 못 사면 0
        if (first == -1 || cost[first] > M) {
            System.out.println(0);
            return;
        }

        // 전체 최소 비용 숫자
        int cheap = 0;
        for (int i = 0; i < N; i++) {
            if (cost[i] < cost[cheap] ||
                    (cost[i] == cost[cheap] && i > cheap)) {
                cheap = i;
            }
        }

        List<Integer> num = new ArrayList<>();

        // 첫 자리 구매
        num.add(first);
        M -= cost[first];

        // 나머지 자리 최대한 구매
        while (M >= cost[cheap]) {
            num.add(cheap);
            M -= cost[cheap];
        }

        // 각 자리 업그레이드
        for (int i = 0; i < num.size(); i++) {
            for (int d = N - 1; d >= 0; d--) {
                if (i == 0 && d == 0) continue; // 맨 앞 0 금지

                int need = cost[d] - cost[num.get(i)];
                if (need <= M) {
                    M -= need;
                    num.set(i, d);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : num) sb.append(x);
        System.out.println(sb);
    }
}
