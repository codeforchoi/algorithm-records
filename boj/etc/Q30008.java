package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q30008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int p = Integer.parseInt(st.nextToken()) * 100 / n;
            if (p <= 4) {
                sb.append(1);
            } else if (p <= 11) {
                sb.append(2);
            } else if (p <= 23) {
                sb.append(3);
            } else if (p <= 40) {
                sb.append(4);
            } else if (p <= 60) {
                sb.append(5);
            } else if (p <= 77) {
                sb.append(6);
            } else if (p <= 89) {
                sb.append(7);
            } else if (p <= 96) {
                sb.append(8);
            } else {
                sb.append(9);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
