package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q34071sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int first = Integer.parseInt(br.readLine());
        int min = first;
        int max = first;
        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        System.out.println(first == min ? "ez" : first == max ? "hard" : "?");
    }
}
