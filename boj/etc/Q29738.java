package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q29738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append("Case #").append(i).append(": ");
            if (n <= 25) {
                sb.append("World Finals");
            } else if (n <= 1000) {
                sb.append("Round 3");
            } else if (n <= 4500) {
                sb.append("Round 2");
            } else {
                sb.append("Round 1");
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
