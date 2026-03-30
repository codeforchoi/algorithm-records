package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32278sol1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE) {
            System.out.println("short");
        } else if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE) {
            System.out.println("int");
        } else {
            System.out.println("long long");
        }
        //System.out.println(n >= Short.MIN_VALUE && n <= Short.MAX_VALUE ? "short" : n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE ? "int" : "long long");
    }
}
