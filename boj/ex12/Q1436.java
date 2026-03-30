package ex12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 1;
        int name = 666;

        while (count != n) {
            name++;
            if (Integer.toString(name).contains("666")) {
                count++;
            }
        }
        System.out.println(name);
    }
}