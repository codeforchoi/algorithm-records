package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines = new String[29];
        for (int i = 0; i < 15; i++) {
            lines[i] = br.readLine();
        }

        boolean flag = false;
        for (int i = 0; i < 15; i++) {
            if (flag) break;
            String line = lines[i];
            for (int j = 0; j < 29; j++) {
                char ch = line.charAt(j);
                if (ch == 'w') {
                    flag = true;
                    System.out.println("chunbae");
                    break;
                } else if (ch == 'b') {
                    flag = true;
                    System.out.println("nabi");
                    break;

                } else if (ch == 'g') {
                    flag = true;
                    System.out.println("yeongcheol");
                    break;
                }
            }
        }
    }
}
