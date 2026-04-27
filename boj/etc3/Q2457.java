package etc3;

import java.util.*;
import java.io.*;

public class Q2457 {
    private static class Flower implements Comparable<Flower> {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            if (this.start == o.start) return o.end - this.end;
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            flowers[i] = new Flower(sm * 100 + sd, em * 100 + ed);
        }

        Arrays.sort(flowers);

        int count = 0;
        int currentEnd = 301; // 현재 채워야 하는 기준점
        int maxEnd = 0;
        int idx = 0;
        boolean possible = false;

        while (currentEnd < 1201) {
            boolean found = false;

            // 현재 기준점(currentEnd) 이전에 피는 꽃들 중 가장 늦게 지는 꽃 찾기
            while (idx < N && flowers[idx].start <= currentEnd) {
                if (flowers[idx].end > maxEnd) {
                    maxEnd = flowers[idx].end;
                    found = true;
                }
                idx++;
            }

            if (found) {
                currentEnd = maxEnd; // 기준점을 찾은 꽃의 지는 시간으로 갱신
                count++;
                if (currentEnd >= 1201) {
                    possible = true;
                    break;
                }
            } else {
                // 더 이상 이어붙일 꽃이 없는 경우
                break;
            }
        }
        System.out.println(possible ? count : 0);
    }

}
