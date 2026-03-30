package boj.ex8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2292sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1, prevRange = 1;

        while (n > prevRange) {
            prevRange += 6 * count;
            count++;
        }
        System.out.println(count);
    }
}