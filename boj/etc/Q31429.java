package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31429 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] count = {12, 11, 11, 10, 9, 9, 9, 8, 7, 6, 6};
        int[] sum = {1600, 894, 1327, 1311, 1004, 1178, 1357, 837, 1055, 556, 773};
        int n = Integer.parseInt(br.readLine());
        sb.append(count[n - 1]).append(" ").append(sum[n - 1]);
        System.out.println(sb);
    }
}
