package ex15;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17103sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 에라토스테네스의 체 알고리즘으로 소수 찾아놓는다. 소수 = false
        boolean[] isPrime = new boolean[1000001];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i < isPrime.length; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j < isPrime.length; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        // 테스트 케이스 시작
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;

            // 순서만 다른 것은 같은 파티션이므로 n/2 까지만 검사하면 된다.
            for (int j = 2; j <= n / 2; j++) {
                // j + n - j = n 이므로 이 둘이 소수이기만 하면 골드바흐 파티션이 성립한다.
                if (!isPrime[j] && !isPrime[n - j]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}