package ex25;

import java.io.*;
import java.util.*;

public class Q12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최장 증가 부분 수열(Longest Increasing Subsequence, LIS)
        int[] lis = new int[N];
        int size = 0;
        for (int x : arr) {
            int left = 0;
            int right = size;

            // x가 들어갈 위치를 이분 탐색
            while (left < right) {
                int mid = (left + right) / 2;
                if(lis[mid] < x) left = mid + 1;
                else right = mid;
            }
            lis[left] = x;
            // 추가해야하는 상황이면 길이를 늘린다.
            if(left == size) size++;
        }
        System.out.println(size);
    }
}
