package boj.ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5073sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int sum = a + b + c;
            int maxSide = Math.max(a, Math.max(b, c));

            if (maxSide >= sum - maxSide) {
                sb.append("Invalid");
            } else {
                if (a == b && b == c) {
                    sb.append("Equilateral");
                } else if (a == b || b == c || c == a) {
                    sb.append("Isosceles");
                } else {
                    sb.append("Scalene");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}