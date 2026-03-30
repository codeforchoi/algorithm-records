package boj.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int sum = a + b + c;
        int maxSide = Math.max(a, Math.max(b, c));

        if (sum - maxSide > maxSide) {
            sb.append(sum);
        } else {
            // a + b > a + b - 1 이면 가장 최대의 큰 변 만족
            sb.append((sum -maxSide) * 2 - 1);
        }
        System.out.println(sb);
    }
}