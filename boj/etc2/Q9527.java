package etc2;

import java.io.*;
import java.util.*;

// 10의 16제곱 반복은 시간 초과, 규칙을 찾고 계산한다.
public class Q9527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(countOnes(B) - countOnes(A - 1));
    }

    // 각 비트마다 반복주기, 1의 개수를 찾는다.
    // 10의 16제곱 필요 비트 수 = [log2(10^16)] + 1 = [16log2(10)] + 1 = [16 * 3.32] + 1 = 54이므로
    // 54비트 사용 ([]는 floor함수, 바닥 함수, 내림)
    private static long countOnes(long n) {
        long count = 0;

        for (int i = 0; i < 54; i++) {
            long bit = 1L << i; // i번째 비트, 2^i
            long cycle = bit << 1; // 2^(i + 1) 주기, 2^i 개 0, 2^i 개 1

            // 해당 비트 자리의 사이클이 반복되는 횟수 * 1의 비트 개수(2^i 개)
            long full = (n + 1) / cycle; // 0 ~ n까지 (n + 1) 길이
            count += full * bit;

            // 해당 비트 자리의 사이클 내에서 몇번째인지 확인
            long remain = (n + 1) % cycle;
            // 2^i보다 크면 0이 모두 나오고 1로 전환된 경우
            if (remain > bit) {
                count += remain - bit;
            }
        }
        return count;
    }
}
