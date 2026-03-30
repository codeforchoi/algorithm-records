package boj.ex13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] point = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(point, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(point[i][0] + " " + point[i][1]).append("\n");
        }
        sb.setLength(sb.length() -1);
        System.out.println(sb);
    }
}