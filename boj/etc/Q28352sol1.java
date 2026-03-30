package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28352sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long week = factorial(n) / (7 * 24 * 60 * 60);
        System.out.println(week);
    }

    static long factorial(long n) {
        return n < 2 ? 1 : n * factorial(n - 1);
    }
}
