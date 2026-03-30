package boj.ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11729pp {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, n) - 1)).append("\n");
        hanoi(n, 1, 2, 3);
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }

    public static void hanoi (int n, int a, int b, int c) {
        // n = 1 이면 a -> c로 1번 옮긴다.
        if (n == 1) {
            sb.append(a + " " + c).append("\n");
            return;
        }

        // a -> b로 n-1 개 원판을 옮긴다.
        hanoi(n - 1, a, c, b);
        // a -> c로 1개 원판을 옮긴다.
        sb.append(a + " " + c).append("\n");
        // b -> c로 n-1 개 원판을 옮긴다.
        hanoi(n - 1, b, a, c);
    }
}