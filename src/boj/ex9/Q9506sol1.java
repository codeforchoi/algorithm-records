package boj.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9506sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) break;

            int sum = 0;
            for (int i = 1; i <= n /2; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 1; i <= n / 2; i++) {
                    if (n % i == 0) {
                        sb.append(i).append(" + ");
                    }
                }
                sb.delete(sb.length() - 3, sb.length() - 1).append("\n");
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}