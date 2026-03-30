package ex12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2231sol1 {
    // n의 생성자는 처음부터 탐색할 필요없이 n의 각 자리수가 9로 최대일 경우를 뺀 수부터 탐색을 시작하면 된다.
    // 따라서 n - (n_length * 9) 부터 탐색을 시작하면 불필요한 계산을 없앨 수 있다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        int n_length = number.length();
        int n = Integer.parseInt(number);
        int result = 0;

        for (int i = n - (n_length * 9); i < n; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}