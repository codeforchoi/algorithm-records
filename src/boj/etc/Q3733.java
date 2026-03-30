package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String line;

        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken()) + 1;
            int s = Integer.parseInt(st.nextToken());
            sb.append(s / n).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}
