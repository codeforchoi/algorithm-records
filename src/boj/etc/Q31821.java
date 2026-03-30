package boj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q31821 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }

        int m = Integer.parseInt(br.readLine());
        int totalPrice = 0;
        for (int i = 0; i < m; i++) {
            totalPrice += price[Integer.parseInt(br.readLine()) - 1];
        }
        System.out.println(totalPrice);
    }
}
