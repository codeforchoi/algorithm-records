package etc2;

import java.io.*;
import java.util.*;

public class Q2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int minLeft = 0, minRight = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }

            if(sum == 0) break;
            else if(sum > 0) right--;
            else left++;
        }
        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}

