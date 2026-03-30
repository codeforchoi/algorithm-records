package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        if (t >=  12 && t <= 16 && s == 0) {
            sb.append(320);
        } else {
            sb.append(280);
        }
        System.out.println(sb);
    }
}
