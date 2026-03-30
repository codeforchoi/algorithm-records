package boj.ex17;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10872sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 1;

        for (int i = n; i > 0; i--) {
            result *= i;
        }

        /*while (n != 0) {
            result *= n;
            n--;
        }*/
        System.out.println(result);
    }
}