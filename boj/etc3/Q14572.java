package etc3;

import java.io.*;
import java.util.*;

//
public class Q14572 {
    private static class Student {
        int level;
        ArrayList<Integer> list = new ArrayList<>();

        Student(int level) {
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Student[] arr = new Student[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());

            arr[i] = new Student(level);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i].list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a.level));

        int[] cnt = new int[K + 1];
        long answer = 0;

        int left = 0;
        int union = 0;

        for (int right = 0; right < N; right++) {

            for (int algo : arr[right].list) {
                if (cnt[algo] == 0) union++;
                cnt[algo]++;
            }

            while (arr[right].level - arr[left].level > D) {
                for (int algo : arr[left].list) {
                    cnt[algo]--;
                    if (cnt[algo] == 0) union--;
                }
                left++;
            }

            int size = right - left + 1;
            int intersection = 0;
            for (int i = 1; i <= K; i++) {
                if (cnt[i] == size) intersection++;
            }
            answer = Math.max(answer, (long) size * (union - intersection));
        }
        System.out.println(answer);
    }
}
