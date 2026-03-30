package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q28453sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());
            sb.append(level < 250 ? 4 : level < 275 ? 3 : level < 300 ? 2 : 1).append(" ");
        }
        System.out.println(sb);
    }
}
