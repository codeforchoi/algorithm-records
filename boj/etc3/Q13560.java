package etc3;

import java.io.*;
import java.util.*;

//
public class Q13560 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        int w = 0;
        boolean valid = true;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        if (N * (N - 1) / 2 == sum) {
            Arrays.sort(arr);
            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > i) {
                    if(arr[i] <= i + w) {
                        w -= arr[i] - i;
                    } else {
                        valid = false;
                        break;
                    }
                } else if (arr[i] < i) w += i - arr[i];
            }
            if(valid) System.out.println(1);
            else System.out.println(-1);
        } else {
            System.out.println(-1);
        }
    }
}
