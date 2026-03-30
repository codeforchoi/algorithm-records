package boj.ex15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4948sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;

        // 소수 = false
        boolean[] prime = new boolean[246913];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!prime[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}