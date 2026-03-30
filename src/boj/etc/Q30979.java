package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Integer.parseInt(st.nextToken());
        }
        System.out.println(total >= t ? "Padaeng_i Happy" : "Padaeng_i Cry");
    }
}
