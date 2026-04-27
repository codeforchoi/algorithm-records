package etc3;

import java.io.*;
import java.util.*;

//
public class Q1557 {
    private static final int MAX = 1_000_000;
    private static int[] mobius = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long K = Long.parseLong(br.readLine());

        getMobius();

        long low = 0L;
        long high = 2_000_000_000L; // 약 20억
        long answer = high;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (countSquareFree(mid) >= K) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static long countSquareFree(long x) {
        long count = 0;
        for (long i = 1; i * i <= x; i++) {
            count += mobius[(int) i] * (x / (i * i));
        }
        return count;
    }

    private static void getMobius() {
        mobius[1] = 1;
        for (int i = 1; i <= MAX; i++) {
            for (int j = 2 * i; j <= MAX; j += i) {
                mobius[j] -= mobius[i];
            }
        }
    }
}
