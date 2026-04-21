package etc2;

import java.io.*;
import java.util.*;

public class Q2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();

        // 각 배열 부분합 경우 구하기
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                sumB.add(sum);
            }
        }

        // 이분 탑색을 사용할 부분합 리스트 정렬
        Collections.sort(sumB);

        for (int value : sumA) {
            int targer = T - value;
            count += upperBound(sumB, targer) - lowerBound(sumB, targer);
        }
        System.out.println(count);
    }

    private static int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) >= target) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private static int upperBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if(list.get(mid) > target) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
