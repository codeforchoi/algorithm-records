package ex19;
//포스팅
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10870sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fibonacci = 1;
        if (n == 0) {
            fibonacci = 0;
        }
        int prev = 0;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = fibonacci;
            fibonacci += prev;
            prev = temp;
        }
        System.out.println(fibonacci);
    }
}