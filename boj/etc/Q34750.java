package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int parents = 0;
        if (n >= 1000_000) {
            parents = n / 100 * 20;
        } else if (n >= 500_000) {
            parents = n / 100 * 15;
        } else if (n >= 100_000) {
            parents = n / 100 * 10;
        } else {
            parents = n / 100 * 5;
        }
        sb.append(parents).append(" ").append(n - parents);
        System.out.println(sb);
    }
}
