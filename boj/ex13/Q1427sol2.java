package boj.ex13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1427sol2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] counting = new int[10]; // 0 ~ 9 숫자

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            counting[str.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            while (counting[i]-- > 0) {
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}