package boj.ex12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2839sol1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n == 4 || n == 7) { // n이 4, 7일 경우에는 예외
            sb.append(-1);
        } else if (n % 5 == 0) { // n이 5로 나누어질 경우
            sb.append(n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) { // n이 6, 8, 11, 13, 16 등일 경우
            sb.append((n / 5) + 1);
        } else if (n % 5 == 2 || n % 5 == 4) { // n이 9, 12, 14, 17, 19 등일 경우
            sb.append((n / 5) + 2);
        }
        System.out.println(sb);
    }
}