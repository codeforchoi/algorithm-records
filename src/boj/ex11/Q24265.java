package boj.ex11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q24265 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append((n * (n - 1)) / 2).append("\n").append(2);
        System.out.println(sb);
    }
}