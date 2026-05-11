package d2;

import java.io.*;
import java.util.*;

public class S1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            long[] arr = new long[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            long max = 0;
            long profit = 0;

            for (int i = N - 1; i >= 0; i--) {
                if(arr[i] > max) max = arr[i];
                else profit += max - arr[i];
            }

            sb.append("#").append(t).append(" ").append(profit).append("\n");
        }
        System.out.print(sb);
    }
}
