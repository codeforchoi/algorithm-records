package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());
        int score = 0;

        if (n < 3) {
            score = n * 10;
        } else if (n < 5) {
            score = n * 10 + 20;
        } else {
            score = n * 10 + 20 + 50;
        }

        if (w > 1000) {
            score -= 15;
        }
        System.out.println(Math.max(score, 0));
    }
}
