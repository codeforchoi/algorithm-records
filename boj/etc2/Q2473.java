package etc2;

import java.io.*;
import java.util.*;

public class Q2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long minSum = Long.MAX_VALUE;
        long a = 0, b = 0, c = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long)arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                }

                if (sum == 0) {
                    sb.append(a).append(" ").append(b).append(" ").append(c);
                    System.out.println(sb);
                    return;
                } else if (sum > 0) right--;
                else left++;
            }
        }
        sb.append(a).append(" ").append(b).append(" ").append(c);
        System.out.println(sb);
    }
}
