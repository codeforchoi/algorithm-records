package boj.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            StringBuilder divisor = new StringBuilder();
            int sum = 0;
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    divisor.append(i).append(" + ");
                }
            }

            if (sum == n) {
                divisor.setLength(divisor.length() - 3);
                sb.append(n).append(" = ").append(divisor).append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}