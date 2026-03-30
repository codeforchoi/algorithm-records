package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q30402sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 15; i++) {
            String str = br.readLine();
            if (str.contains("w")) {
                System.out.println("chunbae");
                break;
            } else if (str.contains("b")) {
                System.out.println("nabi");
                break;
            } else if (str.contains("g")) {
                System.out.println("yeongcheol");
                break;
            }
        }
    }
}
