package ex15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4134 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            sb.append(findMinPrime(Long.parseLong(br.readLine()))).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static long findMinPrime(long num) {
        if (is_Prime(num)) return num;
        else return findMinPrime(++num);
    }

    public static boolean is_Prime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}