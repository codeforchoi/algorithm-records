package ex30;

import java.io.*;
import java.util.*;

public class Q1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체 알고리즘으로 N까지의 소수 걸러내기
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 리스트에 소수들 추가
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if(isPrime[i]) primes.add(i);
        }

        // 투 포인터 알고리즘 사용
        int count = 0;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < primes.size(); right++) {
            sum += primes.get(right);
            while (sum > N) {
                sum -= primes.get(left++);
            }
            if(sum == N) count++;
        }
        System.out.println(count);
    }
}
