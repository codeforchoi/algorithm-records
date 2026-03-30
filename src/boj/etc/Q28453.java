package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q28453 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());
            if (level < 250) {
                sb.append(4);
            } else if (level < 275) {
                sb.append(3);
            } else if (level < 300) {
                sb.append(2);
            } else {
                sb.append(1);
            }
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
