package boj.ex9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1978expp {
    public static void main(String[] args) throws IOException {
        /* 에라토스테네스의 체 자바 코드 구현
           N을 입력받아 1부터 N까지 소수를 구해서 출력하는 프로그램
           true는 소수, false는 소수가 아님. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true); // 초기값 모두 true로 설정
        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스테네스의 체 알고리즘
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (isPrime[i]) {
                sb.append(i).append(" ");
            }
        }
        sb.setLength(sb.length() - 1); // 마지막 공백 제거
        System.out.println(sb);
    }
}