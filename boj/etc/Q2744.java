package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] word = br.readLine().toCharArray();
        for (int i = 0; i < word.length; i++) {
            if (word[i] <= 90) {
                word[i] += 32;
            } else {
                word[i] -= 32;
            }
        }
        String str = String.valueOf(word);
        System.out.println(str);
    }
}
