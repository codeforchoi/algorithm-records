package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q32642 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long rage = 0;
        long rageSum = 0;
        for (int i = 0; i < n; i++) {
            if (Long.parseLong(st.nextToken()) == 1) {
                rage++;
            } else {
                rage--;
            }
            rageSum += rage;
        }
        System.out.println(rageSum);
    }
}
