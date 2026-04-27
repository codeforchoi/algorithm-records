package etc3;

import java.io.*;
import java.util.*;

//
public class Q18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long totalCost = 0;

        for (int i = 0; i < N; i++) {
            if (A[i+1] > A[i+2]) {
                int count2 = Math.min(A[i], A[i+1] - A[i+2]);
                totalCost += 5L * count2;
                A[i] -= count2;
                A[i+1] -= count2;

                int count3 = Math.min(A[i], Math.min(A[i+1], A[i+2]));
                totalCost += 7L * count3;
                A[i] -= count3;
                A[i+1] -= count3;
                A[i+2] -= count3;
            } else {
                int count3 = Math.min(A[i], Math.min(A[i+1], A[i+2]));
                totalCost += 7L * count3;
                A[i] -= count3;
                A[i+1] -= count3;
                A[i+2] -= count3;

                int count2 = Math.min(A[i], A[i+1]);
                totalCost += 5L * count2;
                A[i] -= count2;
                A[i+1] -= count2;
            }
            totalCost += 3L * A[i];
            A[i] = 0;
        }
        System.out.println(totalCost);
    }
}
