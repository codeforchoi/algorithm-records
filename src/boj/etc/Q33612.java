package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q33612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()) - 1;
        int totalMonth = 8 + 7 * n;
        sb.append(2024 + (totalMonth - 1) / 12).append(" ").append((totalMonth - 1) % 12 + 1);
        System.out.println(sb);
    }
}
