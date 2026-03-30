package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int year = Integer.parseInt(str) + 1;
            int div = Integer.parseInt(str.substring(str.length() - 2));
            if (year % div == 0) {
                sb.append("Good");
            } else {
                sb.append("Bye");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
