package boj.ex9;
//에라토스테네스의 체를 사용해서 더 효율적으로 특정 범위 사이에 소수 찾기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2581sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int start = Integer.parseInt(br.readLine());
        int end = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[end + 1];
        isPrime[0] = isPrime[1] = true;

        for (int i = 2; i * i <= end; i++) {
            if(isPrime[i]) continue;
            for (int j = i * i; j <= end; j += i) {
                isPrime[j] = true;
            }
        }

        int totalSum = 0;
        int min = -1;
        for (int i = start; i <= end; i++) {
            if (!isPrime[i]) {
                totalSum += i;
                if (min == -1) {
                    min = i;
                }
            }
        }

        if (min == -1) {
            sb.append(min);
        } else {
            sb.append(totalSum).append("\n").append(min);
        }
        System.out.println(sb);
    }
}