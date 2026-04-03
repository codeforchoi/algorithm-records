package ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStr = br.readLine().split("");
        int isPalindrome = 1;

        for (int i = 0; i < inputStr.length / 2; i++) {
            if (!inputStr[i].equals(inputStr[inputStr.length - i - 1])) {
                isPalindrome = 0;
            }
        }
        System.out.println(isPalindrome);
    }
}