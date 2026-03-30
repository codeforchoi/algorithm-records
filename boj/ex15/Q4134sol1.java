package ex15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4134sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            long num = Long.parseLong(br.readLine());
            while (!is_Prime(num)) {
                num++;
            }
            sb.append(num).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static boolean is_Prime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}