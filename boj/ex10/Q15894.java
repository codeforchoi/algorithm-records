package ex10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q15894 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 문제에서 n이 10의 9제곱까지이므로 4 * n은 int의 범위를 넘어간다.
        // int는 10의 9제곱에 2를 곱한 정도이다. (21억정도)
        long n = Long.parseLong(br.readLine());
        sb.append(4 * n);
        System.out.println(sb);
    }
}