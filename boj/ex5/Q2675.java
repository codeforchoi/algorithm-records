package ex5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            String[] str = st.nextToken().split("");

            for (int j = 0; j < str.length; j++) {
                sb.append(str[j].repeat(r));
            }
            if (i != t - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}