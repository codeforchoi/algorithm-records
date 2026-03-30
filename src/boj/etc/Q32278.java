package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n <= Math.pow(2, 15) - 1 && n >= Math.pow(2, 15) * -1) {
            System.out.println("short");
        } else if (n <= Math.pow(2, 31) - 1 && n >= Math.pow(2, 31) * -1) {
            System.out.println("int");
        } else {
            System.out.println("long long");
        }
    }
}
