package boj.ex15;
//포스팅
//시간초과 실패
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q17103pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(goldbachPartition(n)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static int goldbachPartition(int n) {
        int count = 0;
        List<Integer> prime = new ArrayList<>();

        // n보다 작은 소수들을 구한다.
        for (int i = 2; i < n; i++) {
            if (is_Prime(i)) {
                 prime.add(i);
            }
        }

        // 중복 가능, 순서 없이 2개 뽑아서 검사 (중복조합) (n + k - 1)C(k)개 경우
        int size = prime.size();
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (prime.get(i) + prime.get(j) == n) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean is_Prime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}