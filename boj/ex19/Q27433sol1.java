package ex19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q27433sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = 1;

        for (long i = n; i > 0; i--) {
            result *= i;
        }
        System.out.println(result);
    }
}