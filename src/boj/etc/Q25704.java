package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q25704 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        double totalPrice = p;

        if (n >= 20) {
            totalPrice = Math.min(p - 500, Math.min(p - 2000, p * 0.75));
        } else if (n >= 15) {
            totalPrice = Math.min(p - 500, Math.min(p - 2000, p * 0.9));
        } else if (n >= 10) {
            totalPrice = Math.min(p - 500, p * 0.9);
        } else if (n >= 5) {
            totalPrice = p - 500;
        }
        System.out.println((int)Math.max(totalPrice, 0));
    }
}
