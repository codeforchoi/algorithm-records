package boj.ex17;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11050sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int result = factorial(n) / (factorial(n - k) * factorial(k));
        System.out.println(result);
    }

    public static int factorial(int n) {
        int result = 1;
        while (n != 0) {
            result *= n;
            n--;
        }
        return result;
    }
}