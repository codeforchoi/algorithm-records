package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q28701 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int sum = n * (n + 1) / 2;
        sb.append(sum).append("\n");
        sb.append((long)Math.pow(sum, 2)).append("\n");
        sb.append((long)Math.pow(sum, 2));
        System.out.println(sb);
    }
}
