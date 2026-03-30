package ex15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (is_Prime(i)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static boolean is_Prime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}