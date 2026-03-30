package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q25600 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int maxScore = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = 0;
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            score = a * (d + g);
            if (a == d + g) {
                score *= 2;
            }
            maxScore = Math.max(maxScore, score);
        }
        System.out.println(maxScore);
    }
}
