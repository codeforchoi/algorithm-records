package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q13752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            sb.append("=".repeat(Integer.parseInt(br.readLine()))).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
