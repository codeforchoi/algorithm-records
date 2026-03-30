package boj.ex4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3052sol1pp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        boolean[] remainder = new boolean[42];

        for (int i = 0; i < 10; i++) {
            remainder[Integer.parseInt(br.readLine()) % 42] = true;
        }

        for (boolean value : remainder) {
            if (value) {
                count++;
            }
        }

        System.out.println(count);
    }
}