package boj.ex6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine().toUpperCase();
        int[] count = new int[26];
        int max = -1;
        char ch = '?';

        for (int i = 0; i < inputStr.length(); i++) {
            count[inputStr.charAt(i) - 'A']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                ch = (char)(i + 65);
            } else if (count[i] == max) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}