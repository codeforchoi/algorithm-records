package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int good = 1, bad = 1;
        for (int i = 0; i < n; i++) {
            good += a;
            bad += b;
            if (good < bad) {
                int temp = good;
                good = bad;
                bad  = temp;
            } else if (good == bad) {
                bad--;
            }
        }
        sb.append(good).append(" ").append(bad);
        System.out.println(sb);
    }
}
