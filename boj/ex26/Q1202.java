package ex26;

import java.io.*;
import java.util.*;

public class Q1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // [무게, 가격]
        int[][] jewels = new int[N][2];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i][0] = Integer.parseInt(st.nextToken());
            jewels[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        // 무게 기준 오름차순 정렬
        Arrays.sort(jewels, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(bags);

        // 가방에 넣은 보석 중에 가치가 높은 것이 가장 먼저 나오도록 설정
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long maxSum = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            // 현재 가방에 들어갈 수 있는 보석들 추가
            while (index < N && jewels[index][0] <= bags[i]) {
                pq.offer(jewels[index++][1]);
            }
            
            // 가장 가치가 높은 보석 선택
            if (!pq.isEmpty()) {
                maxSum += pq.poll();
            }
        }
        System.out.println(maxSum);
    }
}
