package d3;

import java.io.*;
import java.util.*;

public class S1206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            for(int j = 2; j < N - 2; j++) {
                int leftMax = Math.max(arr[j - 2], arr[j - 1]);
                int rightMax = Math.max(arr[j + 1], arr[j + 2]);
                int max = Math.max(leftMax, rightMax);

                if(arr[j] > max) {
                    result += arr[j] - max;
                }
            }
            sb.append("#").append(i).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }
}
