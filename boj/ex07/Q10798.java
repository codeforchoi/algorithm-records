package ex07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] inputStr = new String[5];
        int maxLength = 0;

        for (int i = 0; i < inputStr.length; i++) {
             inputStr[i] = br.readLine();
            if (inputStr[i].length() > maxLength) {
                maxLength = inputStr[i].length();
            }
        }

        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < inputStr.length; j++) {
                if (i < inputStr[j].length()) {
                    sb.append(inputStr[j].charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}