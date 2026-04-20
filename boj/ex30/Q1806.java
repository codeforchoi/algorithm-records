package ex30;

import java.io.*;
import java.util.*;

// 부분합, 투포인터
public class Q1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            while (sum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= arr[left++];
            }
        }
        System.out.println((minLength == Integer.MAX_VALUE) ? 0 : minLength);
    }
}
