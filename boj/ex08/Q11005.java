package ex08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (n > 0) {
            if (n % b >= 10) {
                sb.append((char)((n % b) + 'A' - 10));
            } else {
                sb.append(n % b);
            }
            n /= b; // n과 b가 int형이므로 몫만 계산됨.
        }
        System.out.println(sb.reverse());
    }
}